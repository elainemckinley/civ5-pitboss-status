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

	@Override
	public String toString() {
		return "PlayerTurnStatus{" +
				"playerName='" + playerName + '\'' +
				", turnFinished=" + turnFinished +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PlayerTurnStatus that = (PlayerTurnStatus) o;

		if (turnFinished != that.turnFinished) return false;
		if (playerName != null ? !playerName.equals(that.playerName) : that.playerName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = playerName != null ? playerName.hashCode() : 0;
		result = 31 * result + (turnFinished ? 1 : 0);
		return result;
	}
}
