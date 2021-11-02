package models;

public class Cookie {

	private String id;
	private Timestamp timestamp;

	public Cookie(String _id, Timestamp _timestamp) {
		this.id = _id;
		this.timestamp = _timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Cookie [id=" + id + ", timestamp=" + timestamp + "]";
	}

}
