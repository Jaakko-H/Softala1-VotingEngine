package fi.softala.vote.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class TeamMember {
	@Getter @Setter private long teamId;
	@Getter @Setter private String firstName;
	@Getter @Setter private String lastName;

	
	@ToString (includeFieldNames=true)
	@Data (staticConstructor="of")
	class Exem<T> {
		@SuppressWarnings("unused")
		private long teamId;
		@SuppressWarnings("unused")
		private T x;
	}
}
