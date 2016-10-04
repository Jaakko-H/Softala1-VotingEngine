package fi.softala.vote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

 @Entity
 @Table(name = "team")
public class TeamImpl implements Team{

	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long teamId;
	 @Size (min = 1, max = 50)
	 private String teamName;
	
	 
	public long getTeamId() {
		return teamId;
	}
	
	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}
	
	
	public void seTeamName(String teamName) {
		this.teamName = teamName;
		
	}
	 
	 
}
