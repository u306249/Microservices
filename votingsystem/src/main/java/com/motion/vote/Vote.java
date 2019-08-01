package com.motion.vote;

public class Vote {
	
	private String voterName;
	private Opinion opinion;
	private boolean isVP = false;
	
	public Vote(String voterName, Opinion opinion, boolean isVP) {
		super();
		this.voterName = voterName;
		this.opinion = opinion;
		this.isVP = isVP;
	}
	public boolean isVP() {
		return isVP;
	}
	public String getVoterName() {
		return voterName;
	}
	public Opinion getOpinion() {
		return opinion;
	}
}
