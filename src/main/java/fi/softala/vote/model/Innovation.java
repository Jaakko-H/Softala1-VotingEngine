package fi.softala.vote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inno")
public class Innovation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long innoId;
	@Size(min = 1, max = 50)
	private String innoName;
	@Size(min = 1, max = 225)
	private String innoDesc;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

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
		return innoName;
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

	@Override
	public String toString() {
		return "InnoImpl [innoId=" + innoId + ", innoName=" + innoName
				+ ", innoDesc=" + innoDesc + ", team=" + team + "]";
	}

}
