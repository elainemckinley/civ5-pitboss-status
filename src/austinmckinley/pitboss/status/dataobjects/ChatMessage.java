package austinmckinley.pitboss.status.dataobjects;

public class ChatMessage {
	private String name;
	private String message;

	public ChatMessage(String name, String message) {
		this.name = name;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ChatMessage{" +
				"name='" + name + '\'' +
				", message='" + message + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ChatMessage that = (ChatMessage) o;

		if (message != null ? !message.equals(that.message) : that.message != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (message != null ? message.hashCode() : 0);
		return result;
	}
}
