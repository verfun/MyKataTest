package com.SG.serviceTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.SG.Model.Match;
import com.SG.Model.SetGame;
import com.SG.Model.Enum.GameStatus;
import com.SG.Model.Enum.MatchState;
import com.SG.Model.Enum.ValuePoint;
import com.SG.Service.MatchServiceImpl;
import com.SG.Service.RuleServiceImpl;

import junit.framework.Assert;

public class UseCase4 {
	

	private MatchServiceImpl matchService = new MatchServiceImpl();
	private Match match = matchService.createMatch();
	private SetGame currentSetGame = matchService.getSetGameWithStatus(match, GameStatus.CURRENT);
	@Autowired
	private RuleServiceImpl ruleService = new RuleServiceImpl();
	private static Logger LOGGER = Logger.getRootLogger();

	
	@Test
	public void test_UpdateScore_Win_Set(){
		int numberOfExpectedWinnedSet = this.match.getTeamA().getNumberWinnedSetGame() + 1;
		match.getTeamA().setNumberWinnedGame(6);
		match.getTeamA().getScore().setValue(ValuePoint.FORTY);
		match.getTeamB().setNumberWinnedGame(4);
		this.match.setState(MatchState.SIMPLE);
		ruleService.initializeRule(this.match);
		match.getRule().updateScore(match, match.getTeamA());
		LOGGER.info("test !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Assert.assertEquals(numberOfExpectedWinnedSet, match.getTeamA().getNumberWinnedSetGame());
	}


}
