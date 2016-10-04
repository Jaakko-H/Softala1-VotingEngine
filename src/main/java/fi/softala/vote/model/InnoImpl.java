package fi.softala.vote.model;

// @Entity
// @Table(name = "inno")
public class InnoImpl {

	// @Id
	// @GeneratedValue(strategy = GenerationType.Auto)
	private long innoId;
	// @Size (min = 1, max = 50)
	private String innoName;
	// @Size (min = 1, max = 225)
	private String innoDesc;

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
