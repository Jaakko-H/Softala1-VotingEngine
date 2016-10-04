package fi.softala.vote.model;


//tähän tulee vielä  muutosta

public class Innovation {
	private long innoId;
	private String innoName;
	private String innoDesc;
	private long teamId;
	
	
	public Innovation(long innoId, String innoName, String innoDesc, long teamId) {
		super();
		this.innoId = innoId;
		this.innoName = innoName;
		this.innoDesc = innoDesc;
		this.teamId = teamId;
	}


	public long getInnoId() {
		return innoId;
	}


	public void setInnoId(long innoId) {
		this.innoId = innoId;
	}


	public String getInnoName() {
		return innoName;
	}


	public void setInnoName(String innoName) {
		this.innoName = innoName;
	}


	public String getInnoDesc() {
		return innoDesc;
	}


	public void setInnoDesc(String innoDesc) {
		this.innoDesc = innoDesc;
	}


	public long getTeamId() {
		return teamId;
	}


	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}


	@Override
	public String toString() {
		return "Innovation [innoId=" + innoId + ", innoName=" + innoName
				+ ", innoDesc=" + innoDesc + ", teamId=" + teamId + "]";
	}
	


}

