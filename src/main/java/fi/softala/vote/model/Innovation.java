package fi.softala.vote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

 @Entity
 @Table(name = "inno")
public class Innovation {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long innoId;
	 @Size (min = 1, max = 50)
	private String innoName;
	 @Size (min = 1, max = 225)
	private String innoDesc;
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private long teamId;
	
	public long getInnoId(){
		return innoId;
	}
	
	public void setInnoId(long innoId){
		this.innoId = innoId;
	}
	
	public String getInnoName(){
		return innoName;
	}
	
	public void setInnoName(String innoName){
		this.innoName = innoName;
	}
	
	public String getInnoDesc(){
		return innoName;
	}
	
	public void setInnoDesc(String innoDesc){
		this.innoDesc = innoDesc;
	}

	public long getTeamId(){
		return teamId;
	}
	
	public void setTeamId(long teamId){
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "InnoImpl [innoId=" + innoId + ", innoName=" + innoName
				+ ", innoDesc=" + innoDesc + ", teamId=" + teamId + "]";
	}
	
	
}
