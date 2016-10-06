package fi.softala.vote.model;

import javax.persistence.Entity;
/*
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
*/
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="team_member")
public class TeamMember {
	
	@Size(min = 1, max = 225)
	private String firstName;
	
	@Size(min = 1, max = 225)
	private String lastName;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	/*
	
	if to validate team members to not vote their own innovation via java...?

	$ desc table team_member;
	$ alter table team_member add member_id bigint(20) primary key auto_increment;
	$ alter table team_member drop column member_id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long memberId;

	 */
}
