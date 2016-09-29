package fi.softala.vote.model;

import lombok.Getter;
import lombok.Setter;

public class TeamMember {
	@Getter @Setter private long id;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private long teamID;
	
	public TeamMember() {
		this.id = 0;
		this.firstName = "";
		this.lastName = "";
		this.teamID = 0;
	}
	
	public TeamMember(long id, String firstName, String lastName, long teamID) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.teamID = teamID;
	}
	
	public String toString() {
		return "TeamMember [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", teamID=" + teamID + "]";
	}
}
