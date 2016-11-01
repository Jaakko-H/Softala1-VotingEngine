package fi.softala.vote.dao;
import fi.softala.vote.model.Vote;
import fi.softala.vote.model.Voter;
import java.util.List;

public interface VoteDAO {
    public abstract void add(Vote vote);
    public abstract List<Vote> findByVoterAndType(Voter voter, String type);
}
