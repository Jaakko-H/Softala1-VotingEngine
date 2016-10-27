package FormValidators;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
    
    @NotNull
    @NotEmpty
    @Size(min=3, max=20)
    public String voterName;
    
    public void setVoterName(String voterName){ this.voterName = voterName; }
    public String getVoterName(){ return this.voterName; }
    
}
