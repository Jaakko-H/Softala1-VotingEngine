package FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
    
    @NotNull
    @NotEmpty
    @Size(min=3, max=20)
    public String voterFirstName;
    
    @NotNull
    @NotEmpty
    @Size(min=3, max=20)
    public String voterSirName;
    
    public void setVoterFirstName(String voterFirstName){ this.voterFirstName = voterFirstName; }
    public String getVoterFirstName(){ return this.voterFirstName; }
    
    public void setVoterSirName(String voterSirName){ this.voterSirName = voterSirName; }
    public String getVoterSirName(){ return this.voterSirName; }
    
}
