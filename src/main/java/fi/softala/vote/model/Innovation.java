package fi.softala.vote.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



public class Innovation {
	@Getter @Setter private long innoid;
	@Getter @Setter private String innoname;
	@Getter @Setter private String innodesc;
	@Getter @Setter private long teamid;
	


	@ToString (includeFieldNames=true)
	@Data (staticConstructor="of")
	class Exem<T> {
		private long innoid;
		private T x;
	}
	
	// https://projectlombok.org/features/Data.html
	// @Data & @ToString annotations
	

}

