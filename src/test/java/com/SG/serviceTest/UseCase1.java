package com.SG.serviceTest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.SG.Model.Game;
import com.SG.Model.Match;
import com.SG.Model.SetGame;
import com.SG.Model.Team;
import com.SG.Model.Enum.GameStatus;
import com.SG.Model.Enum.MatchState;
import com.SG.Model.Enum.ValuePoint;
import com.SG.Service.MatchService;
import com.SG.Service.MatchServiceImpl;
import com.SG.Service.RuleService;
import com.SG.Service.RuleServiceImpl;
import com.SG.Service.ScoreService;

import junit.framework.Assert;


public class UseCase1 {
	
	private MatchServiceImpl matchService = new MatchServiceImpl();
	private Match match = matchService.createMatch();
	private SetGame currentSetGame = matchService.getSetGameWithStatus(match, GameStatus.CURRENT);
	@Autowired
	private RuleServiceImpl ruleService ;
	private static Logger LOGGER = Logger.getRootLogger();


	@Test
	public void test_UpdateScore_Win_point(){
		ValuePoint numberOfExpectedWinnedGame = ValuePoint.FORTY;
		MatchState matchExpetctedStatus = MatchState.DEUCE;
		this.match.setState(MatchState.SIMPLE);
		this.match.getTeamB().getScore().setValue((ValuePoint.FORTY));
		match.getTeamA().setAdvantaged(true);
		match.getTeamA().getScore().setValue(ValuePoint.FORTY);
		ruleService.initializeRule(this.match);
		match.getRule().updateScore(match, match.getTeamA());
		LOGGER.info("test !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Assert.assertEquals(numberOfExpectedWinnedGame, this.match.getTeamA().getScore().getValue());
		Assert.assertEquals(matchExpetctedStatus, match.getState());
		Assert.assertEquals(match.getTeamA().getName(), matchService.getGameWithStatus(currentSetGame, GameStatus.FINISHED).getWinner().getName());
	}
	
	
}
