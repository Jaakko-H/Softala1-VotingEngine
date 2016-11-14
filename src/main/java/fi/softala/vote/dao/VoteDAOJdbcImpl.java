package fi.softala.vote.dao;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fi.softala.vote.model.Innovation;
import fi.softala.vote.model.Vote;
import fi.softala.vote.model.Voter;

@Repository
public class VoteDAOJdbcImpl implements VoteDAO {

	@Inject
	private JdbcTemplate jdbc;

	@Inject
	private InnoDAOJdbcImpl innovationdao;

	@Inject
	private VoterDAOJdbcImpl voterdao;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public JdbcTemplate getJdbcTemplate() {
		return this.jdbc;
	}

	public void setJdbcTemplate(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void add(Vote vote) {
		String query = "INSERT INTO vote(voter_id, inno_id, legit) values(?, ?,'Y')";
		Object[] params = new Object[] { 
				vote.getVoter().getVoterId(),
				vote.getInnovation().getInnoId(),
				};
		int rows = this.jdbc.update(query, params);
		if (rows < 1) {
			log.warn("Could not add vote for innovation=%d", vote
					.getInnovation().getInnoId());
		} else {
			log.info(String.format("New vote was added for innovation=%d", vote
					.getInnovation().getInnoId()));
		}
	}

	@Override
	public Vote findByVoterAndType(Voter voter, String type) {
		String query = "SELECT * FROM vote WHERE voter_id=? AND type=?";
		Object[] params = new Object[] { voter.getVoterId(), type };

		return this.jdbc.queryForObject(query, params, (result, row) -> {
			Vote vote = new Vote();
			vote.setVoteId(result.getLong("vote_id"));
			vote.setLegit(result.getBoolean("legit"));
			vote.setInnovation(innovationdao.find(result.getLong("inno_id")));
			vote.setVoter(voterdao.find(result.getLong("voter_id")));
			return vote;
		});

	}

	@Override
	public List<Vote> findAllVotes() {
		String query = "SELECT * FROM vote";
		return this.jdbc.query(query, (result, row) -> {
			Vote vote = new Vote();
			vote.setVoteId(result.getLong("vote_id"));
			vote.setLegit(result.getBoolean("legit"));
			vote.setInnovation(innovationdao.find(result.getLong("inno_id")));
			vote.setVoter(voterdao.find(result.getLong("voter_id")));
			return vote;
		});
	}

	@Override
	public List<Vote> findByInnovation(Innovation innovation) {
		String query = "SELECT * FROM vote WHERE inno_id = ?";
		Object[] params = new Object[] { innovation.getInnoId() };
		
		return this.jdbc.query(query, params, (result, row) -> {
			Vote vote = new Vote();
			vote.setVoteId(result.getLong("vote_id"));
			vote.setLegit(result.getBoolean("legit"));
			vote.setInnovation(innovationdao.find(result.getLong("inno_id")));
			vote.setVoter(voterdao.find(result.getLong("voter_id")));
			return vote;
		});
	}
	
}
