package austinmckinley.pitboss.status;

import austinmckinley.pitboss.status.dataobjects.ChatMessage;
import austinmckinley.pitboss.status.dataobjects.PlayerTurnStatus;
import austinmckinley.pitboss.status.dataobjects.StatusRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StatusParser {
	private BufferedReader inputLogReader;
	private StatusRecord statusRecord;
    private boolean isHealthy;
	
	private static Pattern setTurnActivePattern = Pattern.compile("\\[[0-9]*\\.[0-9]*\\] DBG: changeNumGameTurnActive\\([0-9]\\) m_iNumActive=[0-9]* : setTurnActive\\(\\) for player ([0-9]*) (.*)$");
	private static Pattern netTurnCompletePattern = Pattern.compile("\\[[0-9]*\\.[0-9]*\\] Net SEND \\(.*\\): .*: NetTurnComplete : Turn Complete, ([0-9]+), .*$");
	private static Pattern netTurnUnreadyPattern = Pattern.compile("\\[[0-9]*\\.[0-9]*\\] Net RECV \\(.*\\) :NetTurnUnready : Turn Complete, ([0-9]+) .*$");
	private static Pattern netChatPattern = Pattern.compile("\\[[0-9]*\\.[0-9]*\\] Net RECV \\(.*\\) :NetChat : Player ([0-9]+) said \"(.*)\"$");
	private static Pattern gameTurnPattern = Pattern.compile("\\[[0-9]*\\.[0-9]*\\] DBG: Game Turn ([0-9]+)$");
	private static Pattern newPlayerPattern = Pattern.compile("\\[[0-9]*\\.[0-9]*\\] DBG: UpdateMoves\\(\\) : player.setEndTurn\\(true\\) called for player ([0-9]+) (.*)$");

	@Autowired
	public StatusParser(BufferedReader inputLogReader) {
		this.inputLogReader = inputLogReader;
		this.statusRecord = new StatusRecord();
        isHealthy = true;
	}
	
	public void generateInitialStatusRecord() throws IOException {
        readStatusUpdateIfExists();
	}

    public boolean isHealthy() {
        return isHealthy;
    }
	
	private void processSingleLine(String lineText) {
        System.out.println("Parsing line: " + lineText);

        Matcher netChatMatcher = netChatPattern.matcher(lineText);
        if (netChatMatcher.matches()) {
            String playerId = netChatMatcher.group(1);
            String messageText = netChatMatcher.group(2);

            statusRecord.getChatMessages().add(new ChatMessage(playerId, messageText));
            return;
        }

        Matcher newPlayerMatcher = newPlayerPattern.matcher(lineText);
        if (newPlayerMatcher.matches()) {
            String playerId = newPlayerMatcher.group(1);
            String playerName = newPlayerMatcher.group(2);

            statusRecord.getPlayerStatuses().put(playerId, new PlayerTurnStatus(playerName, false));
            return;
        }

        Matcher setTurnActiveMatcher = setTurnActivePattern.matcher(lineText);
        if (setTurnActiveMatcher.matches()) {
            String playerId = setTurnActiveMatcher.group(1);

            if (statusRecord.getPlayerStatuses().containsKey(playerId)) {
                statusRecord.getPlayerStatuses().get(playerId).setTurnFinished(false);
            }
            return;
        }

        Matcher netTurnCompleteMatcher = netTurnCompletePattern.matcher(lineText);
        if (netTurnCompleteMatcher.matches()) {
            String playerId = netTurnCompleteMatcher.group(1);

            if (statusRecord.getPlayerStatuses().containsKey(playerId)) {
                statusRecord.getPlayerStatuses().get(playerId).setTurnFinished(true);
            }
            return;
        }

        Matcher netTurnUnreadyMatcher = netTurnUnreadyPattern.matcher(lineText);
        if (netTurnUnreadyMatcher.matches()) {
            String playerId = netTurnUnreadyMatcher.group(1);

            if (statusRecord.getPlayerStatuses().containsKey(playerId)) {
                statusRecord.getPlayerStatuses().get(playerId).setTurnFinished(false);
            }
            return;
        }

        Matcher gameTurnMatcher = gameTurnPattern.matcher(lineText);
        if (gameTurnMatcher.matches()) {
            int turnNumber = Integer.parseInt(gameTurnMatcher.group(1));
            statusRecord.setTurnNumber(turnNumber);

            return;
        }
    }

	public StatusRecord getCurrentStatus() {
		readStatusUpdateIfExists();
        return this.statusRecord;
	}

    private void readStatusUpdateIfExists() {
        try {
            while(inputLogReader.ready()) {
                String lineText = inputLogReader.readLine();
                if(lineText == null) {
                    break;
                }

                processSingleLine(lineText);
            }
        } catch (IOException ex) {
            isHealthy = false;
        }
    }
}
