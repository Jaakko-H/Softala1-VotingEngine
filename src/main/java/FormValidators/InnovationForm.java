package FormValidators;

import fi.softala.vote.model.Team;

public class InnovationForm {

    public long innoId;
    public String innoName;
    public String innoDesc;
    public Team team;
    public String innoOwner;
    
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getInnoOwner() {
		return innoOwner;
	}

	public void setInnoOwner(String innoOwner) {
		this.innoOwner = innoOwner;
	}
    
}
