package com.vote.votingsystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	MotionQueryTest.class,
	MotionVoteWithoutStartTest.class,
	MaxVoteTest.class,
	MotionOnCloseTest.class,
	MotionVoteWithoutStartTest.class,
	MultipleVotingAttemptTest.class,
	VPVoteConsiderationTest.class
})

public class AllTests {

}
