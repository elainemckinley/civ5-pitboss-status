package austinmckinley.pitboss.status.dataobjects;

import java.util.List;

public class StatusRecord {
	List<PlayerTurnStatus> playerStatuses;
	List<ChatMessage> chatMessgaes;

	public StatusRecord(List<PlayerTurnStatus> playerStatuses, List<ChatMessage> chatMessgaes) {
		this.playerStatuses = playerStatuses;
		this.chatMessgaes = chatMessgaes;
	}

	public List<PlayerTurnStatus> getPlayerStatuses() {
		return playerStatuses;
	}

	public void setPlayerStatuses(List<PlayerTurnStatus> playerStatuses) {
		this.playerStatuses = playerStatuses;
	}

	public List<ChatMessage> getChatMessgaes() {
		return chatMessgaes;
	}

	public void setChatMessgaes(List<ChatMessage> chatMessgaes) {
		this.chatMessgaes = chatMessgaes;
	}
}
