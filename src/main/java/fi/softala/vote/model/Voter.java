package fi.softala.vote.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "voter")
public class Voter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long voterId;
	
	@Size(min = 1, max = 255)
	private String firstName;
	@Size(min = 1, max = 255)
	private String lastName;
	@Size(min = 7, max = 7)
	private String type;
	// student, teacher, visitor, innomem
	
	
	/*
	@Getter @Setter private long voterId;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;
	@Getter @Setter private String type;
	// student, teacher, visitor, innomem
	@Getter @Setter private boolean voted;
	@Getter @Setter private long teamID;
	

	@ToString (includeFieldNames=true)
	@Data (staticConstructor="of")
	class Exem<T> {
		@SuppressWarnings("unused")
		private long voterId;
		@SuppressWarnings("unused")
		private T x;
	}
	*/
}
