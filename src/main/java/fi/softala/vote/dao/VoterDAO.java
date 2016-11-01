package fi.softala.vote.dao;

import fi.softala.vote.model.Voter;

public interface VoterDAO {
    public abstract void addVoter(Voter voter);
    public abstract Voter find(long id);
    public abstract Voter findByVoterName(String fname, String sname) throws Exception;
}
