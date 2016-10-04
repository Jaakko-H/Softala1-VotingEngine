package fi.softala.vote.model;

public interface Innovation {

	public abstract long getInnoId();

	public abstract void setInnoId(long InnoId);

	public abstract String getInnoName();

	public abstract void setInnoName(String InnoName);

	public abstract String getInnoDesc();

	public abstract void setInnoDesc(String InnoDesc);

	public abstract long getTeamId();

	public abstract void setTeamId(long TeamId);

}
