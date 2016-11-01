package fi.softala.vote.dao;

import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VoterDAOJdbcImpl implements VoterDAO {

    @Inject
    private JdbcTemplate jdbc;

   @Inject
   private TeamDAOJdbcImpl teamdao;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    public JdbcTemplate getJdbcTemplate() { return this.jdbc; }
    public void setJdbcTemplate(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    
    @Override
    public Voter findByVoterName(String voterName) {

        String query = "SELECT * FROM voter WHERE fname = ?";
        Object[] params = new Object[] { voterName };
        
        Voter found = jdbc.queryForObject(query, params, (result, row) -> {
            Voter voter = new Voter();
            voter.setFirstName(result.getString("fname"));
            voter.setLastName(result.getString("sname"));
            voter.setTeam(new Team());
            voter.setType(result.getString("type"));
            voter.setVoted(result.getBoolean("voted"));
            voter.setVoterId(result.getLong("voter_id"));
            return voter;
        });
        
        return found;
    }

    @Override
    public void addVoter(Voter voter) {
        
    }

    @Override
    public Voter find(long id) {
        String query = " SELECT fname as firstname, sname as surname, type, team_name as teamname, voted FROM voter JOIN team USING(team_id) WHERE voter_id = ?";
        Object[] params = new Object[]{ id };
        
        return (Voter) this.jdbc.queryForObject(query, params, (result, row) -> {
            Voter voter = new Voter();
            voter.setFirstName(result.getString("fname"));
            voter.setLastName(result.getString("sname"));
            voter.setType(result.getString("type"));
            voter.setTeam(teamdao.find(result.getLong("team_id")));
            voter.setVoted(result.getBoolean("voted"));
            return voter;
        });
        
    }
    
}
