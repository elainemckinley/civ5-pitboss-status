package austinmckinley.pitboss.status.dataobjects;

public class PlayerTurnStatus {
	private String playerName;
	private boolean turnFinished;
	
	public PlayerTurnStatus(String playerName, boolean turnFinished) {
		this.playerName = playerName;
		this.turnFinished = turnFinished;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public boolean isTurnFinished() {
		return turnFinished;
	}
	
	public void setTurnFinished(boolean turnFinished) {
		this.turnFinished = turnFinished;
	}
}
