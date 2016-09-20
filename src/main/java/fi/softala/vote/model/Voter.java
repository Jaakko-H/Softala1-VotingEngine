package fi.softala.vote.model;

import lombok.Getter;
import lombok.Setter;

public class Voter {
	@Getter @Setter private long id;
	@Getter @Setter public String firstName;
	@Getter @Setter public String lastName;
	@Getter @Setter public String type;
	@Getter @Setter public boolean voted;
	@Getter @Setter public long teamID;
}
