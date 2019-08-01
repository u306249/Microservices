package com.vote.votingsystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.motion.vote.MotionResults;
import com.motion.vote.MotionStatus;
import com.motion.vote.MotionTask;
import com.motion.vote.Opinion;
import com.motion.vote.Vote;

import junit.framework.TestCase;
/**
 * Unit test for simple App.
 */
public class MotionQueryTest {
	
	private MotionTask task = null;
    
    @Before
    public void init() {
    	task = new MotionTask();
    	task.initiateMotion();
    }
    @Test
    public void testMotionPassQuery(){
        
    	Vote vote1 = new Vote("Anny",Opinion.Y,false);
    	Vote vote2 = new Vote("Jenny",Opinion.Y,false);
    	Vote vote3 = new Vote("Minnie",Opinion.Y,false);
    	Vote vote4 = new Vote("Simi",Opinion.N,false);
    	Vote vote5 = new Vote("Renie",Opinion.N,false);
    	Vote vote6 = new Vote("Benie",Opinion.N,false);
    	Vote vote7 = new Vote("Amy",Opinion.N,false);
    	Vote vote8 = new Vote("Demmy",Opinion.N,false);
    	
    	task.castVote(vote1);
    	task.castVote(vote2);
    	task.castVote(vote3);
    	task.castVote(vote4);
    	task.castVote(vote5);
    	task.castVote(vote6);
    	task.castVote(vote7);
    	task.castVote(vote8);
    	
    	MotionResults result = task.getResult();    	
    	TestCase.assertEquals(result.getMotionStatus(), MotionStatus.MOTIONOPEN);
    	TestCase.assertEquals(result.getAgainstVote(), 5);
    	TestCase.assertEquals(result.getForVote(), 3);
    }
    @Test
    public void testMotionFailQuery(){
        
    	Vote vote1 = new Vote("Anny",Opinion.Y,false);
    	Vote vote2 = new Vote("Jenny",Opinion.Y,false);
    	Vote vote3 = new Vote("Minnie",Opinion.Y,false);
    	Vote vote4 = new Vote("Simi",Opinion.Y,false);
    	Vote vote5 = new Vote("Renie",Opinion.N,false);
    	Vote vote6 = new Vote("Benie",Opinion.N,false);
    	Vote vote7 = new Vote("Amy",Opinion.Y,false);
    	Vote vote8 = new Vote("Demmy",Opinion.N,false);
    	
    	task.castVote(vote1);
    	task.castVote(vote2);
    	task.castVote(vote3);
    	task.castVote(vote4);
    	task.castVote(vote5);
    	task.castVote(vote6);
    	task.castVote(vote7);
    	task.castVote(vote8);
    	
    	MotionResults result = task.getResult();    	
    	TestCase.assertEquals(result.getMotionStatus(), MotionStatus.MOTIONOPEN);
    	TestCase.assertEquals(result.getAgainstVote(), 3);
    	TestCase.assertEquals(result.getForVote(), 5);
    }
}
