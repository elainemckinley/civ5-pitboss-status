package austinmckinley.pitboss.status.dataobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusRecord {
	Map<String, PlayerTurnStatus> playerStatuses;
	List<ChatMessage> chatMessages;

	public StatusRecord(Map<String, PlayerTurnStatus> playerStatuses, List<ChatMessage> chatMessages) {
		this.playerStatuses = playerStatuses;
		this.chatMessages = chatMessages;
	}
	
	public StatusRecord() {
		this.playerStatuses = new HashMap<String, PlayerTurnStatus>();
		this.chatMessages = new ArrayList<>();
	}

	public Map<String, PlayerTurnStatus> getPlayerStatuses() {
		return playerStatuses;
	}

	public void setPlayerStatuses(Map<String, PlayerTurnStatus> playerStatuses) {
		this.playerStatuses = playerStatuses;
	}

	public List<ChatMessage> getChatMessages() {
		return chatMessages;
	}

	public void setChatMessages(List<ChatMessage> chatMessages) {
		this.chatMessages = chatMessages;
	}

	@Override
	public String toString() {
		return "StatusRecord{" +
				"playerStatuses=" + playerStatuses +
				", chatMessages=" + chatMessages +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StatusRecord that = (StatusRecord) o;

		if (chatMessages != null ? !chatMessages.equals(that.chatMessages) : that.chatMessages != null) return false;
		if (playerStatuses != null ? !playerStatuses.equals(that.playerStatuses) : that.playerStatuses != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = playerStatuses != null ? playerStatuses.hashCode() : 0;
		result = 31 * result + (chatMessages != null ? chatMessages.hashCode() : 0);
		return result;
	}
}
