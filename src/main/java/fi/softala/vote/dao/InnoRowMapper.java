package fi.softala.vote.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Team;
import javax.inject.Inject;

public class InnoRowMapper implements RowMapper<Innovation> {

         @Inject
         private TeamDAOJdbcImpl teamdao;
    
    
	public Innovation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Innovation inno = new Innovation();
		inno.setInnoId(rs.getLong("inno_id"));
		inno.setInnoName(rs.getString("inno_name"));
		inno.setInnoDesc(rs.getString("inno_desc"));
		try{
			inno.setTeam(teamdao.find(rs.getLong("team_id")));
			return inno;
		}catch(Exception e){
			inno.setTeam(null);
			return inno;
		}
		
	}

}
