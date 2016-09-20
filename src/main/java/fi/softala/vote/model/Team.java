package fi.softala.vote.model;

import lombok.Getter;
import lombok.Setter;

public class Team {
	@Getter @Setter private long teamID;
	@Getter @Setter private String teamName;
	
	public Team() {
		teamID = 0;
		teamName = "";
	}
	
	public Team(long teamID, String teamName) {
		this.teamID = teamID;
		this.teamName = teamName;
	}
	
	public String toString() {
		return "Team [teamID=" + teamID + ", teamName=" + teamName + "]";
	}
	
}
