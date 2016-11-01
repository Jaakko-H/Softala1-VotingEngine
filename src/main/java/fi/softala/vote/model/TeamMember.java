package fi.softala.vote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
/*
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 */
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "team_member")
public class TeamMember {

                 @NotNull
                 @NotEmpty
	@Size(min = 1, max = 225)
                 @Column(name="fname", nullable = false)
	private String firstName;

                 @NotNull
                 @NotEmpty
	@Size(min = 1, max = 225)
                 @Column(name="lname", nullable = false)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;

	/*
	 * 
	 * if to validate team members to not vote their own innovation via java...?
	 * 
	 * $ desc table team_member; $ alter table team_member add member_id
	 * bigint(20) primary key auto_increment; $ alter table team_member drop
	 * column member_id;
	 * 
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) private long memberId;
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "TeamMember [firstName=" + firstName + ", lastName=" + lastName
				+ ", team=" + team + "]";
	}

}
