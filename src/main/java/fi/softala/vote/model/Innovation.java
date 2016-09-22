package fi.softala.vote.model;
import lombok.Getter;
import lombok.Setter;



public class Innovation {
	@Getter @Setter private int id;
	@Getter @Setter private String name;
	@Getter @Setter private String topic;
	
	public Innovation(int id, String name, String topic) {
		super();
		this.id = id;
		this.name = name;
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "Innovation [id=" + id + ", name=" + name + ", topic=" + topic
				+ "]";
	}

}
