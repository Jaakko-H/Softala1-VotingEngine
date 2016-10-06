package fi.softala.vote.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="voter")
public class Voter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long voterId;
	
	@Size(min = 1, max = 225)
	private String firstName;
	
	@Size(min = 1, max = 225)
	private String lastName;
	
	@Size(min = 7, max = 7)
	@Column(name="type")
	private String type;
	// SQL default; visitor - student, teacher, innomem
	
	@org.hibernate.annotations.Type(type="yes_no")
	@NotNull
	@Column(name = "voted")
	private boolean voted;
	// SQL default 'N', if has voted -> 'Y'
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	/* if to validate team members to not vote their own innovation via java...?
	@OneToOne
	@JoinColumn(name = "member_id")
	private TeamMember teammember;
	
	$ desc table team_member;
	$ alter table team_member add member_id bigint(20) primary key auto_increment;
	$ alter table team_member drop column member_id;
	
	*/
	
}
