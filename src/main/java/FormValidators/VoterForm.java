package FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class VoterForm {
	
	@NotNull
	@NotEmpty(message="firstname can't be empty")
	@Size(min=2, max=20, message="Firstname size must be between 2 to 20 chars")
    public String fName;
	 
	@NotNull
	@NotEmpty(message="Surname can't be empty")
	@Size(min=2, max=20, message="Surname size must be between 2 to 20 chars")
    public String sName;
	 
    public String vType;
    public String tName;
    
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getvType() {
		return vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
    
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
    
}
