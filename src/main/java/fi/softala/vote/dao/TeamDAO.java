
package fi.softala.vote.dao;
import fi.softala.vote.model.Team;

public interface TeamDAO {
    public abstract Team find(long id);
}
