package fi.softala.vote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vote")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long voteId;
	
	@OneToOne
	@JoinColumn(name = "voter_id")
	private Voter voter;
	
	@ManyToOne
	@JoinColumn(name = "inno_id")
	private Innovation innovation;
	
	private boolean legit;

	public boolean isLegit() {
		return legit;
	}

	public void setLegit(boolean legit) {
		this.legit = legit;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", voter=" + voter + ", innovation="
				+ innovation + ", legit=" + legit + "]";
	}
 
	
}
