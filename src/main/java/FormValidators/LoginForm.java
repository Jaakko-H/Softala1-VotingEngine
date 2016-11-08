package FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
    
    @NotNull
    @NotEmpty(message="firstname can't be empty")
    @Size(min=3, max=20, message="firstname size must be between 3 to 20 chars")
    public String voterFirstName;
    
    @NotNull
    @NotEmpty(message="surname can't be empty")
    @Size(min=3, max=20, message="surname size must be between 3 to 20 chars")
    public String voterSirName;
    
    public void setVoterFirstName(String voterFirstName){ this.voterFirstName = voterFirstName; }
    public String getVoterFirstName(){ return this.voterFirstName; }
    
    public void setVoterSirName(String voterSirName){ this.voterSirName = voterSirName; }
    public String getVoterSirName(){ return this.voterSirName; }
    
}
