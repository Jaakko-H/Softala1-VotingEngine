package fi.softala.vote.model;

import lombok.Getter;
import lombok.Setter;

public class Voter {
	@Getter @Setter private long id;
	@Getter @Setter public String firstName;
	@Getter @Setter public String lastName;
	@Getter @Setter public String type;
	@Getter @Setter public boolean voted;
	@Getter @Setter public long teamID;
	
	public Voter() {
		id = 0;
		firstName = "";
		lastName = "";
		type = "";
		voted = false;
		teamID = 0;
	}
	
	public Voter(long id, String firstName, String lastName, String type,
			boolean voted, long teamID) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.voted = voted;
		this.teamID = teamID;
	}
	
	public String toString() {
		return "Voter [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", type=" + type + ", voted=" + voted
				+ ", teamID=" + teamID + "]";
	}
	
}
