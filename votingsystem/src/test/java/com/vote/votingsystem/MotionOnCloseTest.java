package com.vote.votingsystem;

import org.junit.Before;
import org.junit.Test;
import com.motion.vote.MotionResults;
import com.motion.vote.MotionStatus;
import com.motion.vote.MotionTask;
import com.motion.vote.Opinion;
import com.motion.vote.Vote;

import junit.framework.TestCase;

public class MotionOnCloseTest {

	private MotionTask task1 = null;
	
	@Before
    public void init() {
    	task1 = new MotionTask();
    	task1.initiateMotion();
    }
	//Vote counting on Motion Close
	@Test
	public void testMotionPassOnClose() {
		
    	Vote vote1 = new Vote("Anny",Opinion.Y,false);
    	Vote vote2 = new Vote("Jenny",Opinion.Y,false);
    	Vote vote3 = new Vote("Minnie",Opinion.Y,false);
    	Vote vote4 = new Vote("Simi",Opinion.Y,false);
    	Vote vote5 = new Vote("Renie",Opinion.Y,false);
    	Vote vote6 = new Vote("Benie",Opinion.Y,false);
    	Vote vote7 = new Vote("Amy",Opinion.Y,false);
    	Vote vote8 = new Vote("Demmy",Opinion.N,false);
   
    	task1.castVote(vote1);
    	task1.castVote(vote2);
    	task1.castVote(vote3);
    	task1.castVote(vote4);
    	task1.castVote(vote5);
    	task1.castVote(vote6);
    	task1.castVote(vote7);
    	task1.castVote(vote8);
    	
    	//Waiting for motion to be closed
    	try {
			Thread.sleep(5050);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	MotionResults result = task1.getResult();
    	TestCase.assertEquals(result.getMotionStatus(), MotionStatus.MOTIONCLOSED);
    	TestCase.assertEquals(result.isMotionPassed(), true);
    	TestCase.assertEquals(result.getAgainstVote(), 1);
    	TestCase.assertEquals(result.getForVote(), 7);
    	TestCase.assertNotNull(result.getMotionStartTime());
    	TestCase.assertNotNull(result.getMotionEndTime());
	}
	@Test
	public void testMotionFailOnClose() {
		
    	Vote vote1 = new Vote("Anny",Opinion.N,false);
    	Vote vote2 = new Vote("Jenny",Opinion.N,false);
    	Vote vote3 = new Vote("Minnie",Opinion.N,false);
    	Vote vote4 = new Vote("Simi",Opinion.N,false);
    	Vote vote5 = new Vote("Renie",Opinion.N,false);
    	Vote vote6 = new Vote("Benie",Opinion.Y,false);
    	Vote vote7 = new Vote("Amy",Opinion.Y,false);
    	Vote vote8 = new Vote("Demmy",Opinion.N,false);
   
    	task1.castVote(vote1);
    	task1.castVote(vote2);
    	task1.castVote(vote3);
    	task1.castVote(vote4);
    	task1.castVote(vote5);
    	task1.castVote(vote6);
    	task1.castVote(vote7);
    	task1.castVote(vote8);
    	
    	//Waiting for motion to be closed
    	try {
			Thread.sleep(5050);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	MotionResults result = task1.getResult();
    	TestCase.assertEquals(result.getMotionStatus(), MotionStatus.MOTIONCLOSED);
    	TestCase.assertEquals(result.isMotionPassed(), false);
    	TestCase.assertEquals(result.getAgainstVote(), 6);
    	TestCase.assertEquals(result.getForVote(), 2);
    	TestCase.assertNotNull(result.getMotionStartTime());
    	TestCase.assertNotNull(result.getMotionEndTime());
	}

}