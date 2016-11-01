package fi.softala.vote.dao;

import fi.softala.vote.model.Team;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDAOJdbcImpl implements TeamDAO {

    @Inject
    private JdbcTemplate jdbc;
    
    
    @Override
    public Team find(long id) {
      
        String query = "SELECT * FROM team WHERE team_id = ?";
        Object[] params = new Object[]{ id };
        return this.jdbc.queryForObject(query, params, (result, row) -> {
            Team team = new Team();
            team.setTeamId(result.getLong("team_id"));
            team.setTeamName(result.getString("team_name"));
            return team;
        });
        
        
    }


	@Override
	public Team findByTeamName(String teamName) {
		String query = "SELECT * FROM team WHERE team_name = ?";
		Object[] params = new Object[]{ teamName };
		return this.jdbc.queryForObject(query, params, (result, row) -> {
			Team team = new Team();
			team.setTeamId(result.getLong("team_id"));
			team.setTeamName(result.getString("team_name"));
			return team;
		});
	}

}
