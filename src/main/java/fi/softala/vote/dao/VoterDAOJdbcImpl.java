package fi.softala.vote.dao;

import fi.softala.vote.model.Team;
import fi.softala.vote.model.Voter;
import org.springframework.jdbc.core.JdbcTemplate;

public class VoterDAOJdbcImpl implements VoterDAO {

    private JdbcTemplate jdbc;
    
    @Override
    public Voter findByVoterName(String voterName) {
        String query = "SELECT * FROM voter WHERE voter_name = ?";
        Object[] params = new Object[] { voterName };
        Voter voter = new Voter();
        
        jdbc.queryForObject(query, params, (result, row) -> {
            voter.setFirstName(result.getString("fname"));
            voter.setLastName(result.getString("lname"));
            voter.setTeam(new Team());
            voter.setType(result.getString("type"));
            voter.setVoted(result.getBoolean("voted"));
            voter.setVoterId(result.getLong("voter_id"));
            return null;
        });
        
        return voter;
    }

    @Override
    public void AddVoter(Voter voter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
