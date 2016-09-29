package fi.softala.vote.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Voter {
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
	
}
