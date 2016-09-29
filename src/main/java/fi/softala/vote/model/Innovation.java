package fi.softala.vote.model;

import lombok.Getter;
import lombok.Setter;

public class Innovation {
	@Getter @Setter public long id;
	@Getter @Setter public String name;
	@Getter @Setter public String topic;
	
	public Innovation() {
		id = 0;
		name = "";
		topic = "";
	}
	
	public Innovation(long id, String name, String topic) {
		this.id = id;
		this.name = name;
		this.topic = topic;
	}
	public String toString() {
		return "Innovation [id=" + id + ", name=" + name + ", topic=" + topic
				+ "]";
	}
}

