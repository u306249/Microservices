package com.motion.vote;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class MotionTask {

	private Set<String> voters = new HashSet<String>();
	private final int MAX_VOTE = 101;
	private boolean maxVoteCasted = false;
	private int forVote = 0;
	private Vote vpVote = null;
	private static long timeout = 5;//timer is set to 15 mnts
	private boolean motionCloseSignal = false;
	private boolean motionStartSignal = false;
	private Date motionStartTime = null;
	private Date motionEndTime = null;
	
	private int againstVote = 0;
	
	public void initiateMotion() {
		Timer timer = new Timer();
		motionStartSignal = true;
		motionStartTime = new Date();
		timer.schedule(new ShowResult(), timeout * 1000);	
	}
	public void castVote(Vote vote) {
		if (motionStartSignal) {
			if (!voters.contains(vote.getVoterName()) && !vote.isVP() && !motionCloseSignal&& !maxVoteCasted) {
				voters.add(vote.getVoterName());
				if (vote.getOpinion() == Opinion.Y) {
					forVote++;
				} else if (vote.getOpinion() == Opinion.N) {
					againstVote++;
				}
				if(forVote+againstVote>=MAX_VOTE) {
					maxVoteCasted = true;
				}
			} else {
				if (vote.isVP()) {
					vpVote = vote;
				}
			}
		}
	}
	public MotionResults getResult() {
		
		MotionResults result = new MotionResults();
		result.setForVote(forVote);
		result.setAgainstVote(againstVote);
		
		if(forVote > againstVote) {
			result.setMotionPassed(true);
		}else if(forVote < againstVote) {
			result.setMotionPassed(false);
		}else if(forVote == againstVote) {
			if(this.vpVote != null) {
				if(this.vpVote.getOpinion()==Opinion.Y) {
					result.setMotionPassed(true);
				}else {
					result.setMotionPassed(false);
				}
			}
		}else {
			result.setMotionPassed(false);
		}
		if(motionCloseSignal) {
			result.setMotionStatus(MotionStatus.MOTIONCLOSED);
		}else if(motionStartSignal){
			result.setMotionStatus(MotionStatus.MOTIONOPEN);
		}
		result.setMotionStartTime(motionStartTime);
		result.setMotionEndTime(motionEndTime);
		return result;
	}
	public int getForVote() {
		return forVote;
	}
	public int getAgainstVote() {
		return againstVote;
	}
	public Vote getVpVote() {
		return vpVote;
	}
	class ShowResult extends TimerTask {
		public void run() {
			motionCloseSignal = true;
			motionEndTime = new Date();
		}
	}
}

