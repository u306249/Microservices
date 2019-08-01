package com.vote.votingsystem;

import org.junit.Before;
import org.junit.Test;
import com.motion.vote.MotionResults;
import com.motion.vote.MotionStatus;
import com.motion.vote.MotionTask;
import com.motion.vote.Opinion;
import com.motion.vote.Vote;

import junit.framework.TestCase;

public class MotionVoteWithoutStartTest {

	private MotionTask task1 = null;
	
	@Before
    public void init() {
    	task1 = new MotionTask();
    }
	//No votes can be accepted until motion starts
	@Test
	public void testMotionWithoutStarted() {    
    	Vote vote1 = new Vote("Anny",Opinion.Y,false);
    	Vote vote2 = new Vote("Jenny",Opinion.Y,false);
    	Vote vote3 = new Vote("Minnie",Opinion.Y,false);
    	Vote vote4 = new Vote("Simi",Opinion.Y,false);
    	Vote vote5 = new Vote("Renie",Opinion.Y,false);
    	Vote vote6 = new Vote("Benie",Opinion.Y,false);
    	Vote vote7 = new Vote("Amy",Opinion.Y,false);
    	Vote vote8 = new Vote("Demmy",Opinion.N,false);
    	Vote vote9 = new Vote("John",Opinion.Y,true);
   
    	task1.castVote(vote1);
    	task1.castVote(vote2);
    	task1.castVote(vote3);
    	task1.castVote(vote4);
    	task1.castVote(vote5);
    	task1.castVote(vote6);
    	task1.castVote(vote7);
    	task1.castVote(vote8);
    	task1.castVote(vote9);
    	
    	MotionResults result = task1.getResult();
    	TestCase.assertEquals(result.getMotionStatus(), MotionStatus.MOTIONNOTSTARTED);
    	TestCase.assertEquals(result.isMotionPassed(), false);
    	TestCase.assertEquals(result.getAgainstVote(), 0);
    	TestCase.assertEquals(result.getForVote(), 0);
	}
}
