package fi.softala.vote.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



public class Innovation {
	@Getter @Setter private long innoId;
	@Getter @Setter private String innoName;
	@Getter @Setter private String innoDesc;
	@Getter @Setter private long teamId;
	


	@ToString (includeFieldNames=true)
	@Data (staticConstructor="of")
	class Exem<T> {
		@SuppressWarnings("unused")
		private long innoId;
		@SuppressWarnings("unused")
		private T x;
	}
	
	// https://projectlombok.org/features/Data.html
	// @Data & @ToString annotations
	

}

