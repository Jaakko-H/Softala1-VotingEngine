package fi.softala.vote.dao;

import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class VoterDAOJdbcImpl implements VoterDAO {

    private JdbcTemplate jdbc;
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
    public void AddVoter(Voter voter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
