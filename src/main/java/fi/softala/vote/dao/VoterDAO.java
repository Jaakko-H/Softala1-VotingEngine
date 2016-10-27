package fi.softala.vote.dao;

import fi.softala.vote.model.Voter;

public interface VoterDAO {
    public abstract void AddVoter(Voter voter);
    public abstract Voter findByVoterName(String voterName);
}
