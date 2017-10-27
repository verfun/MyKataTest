package com.SG.serviceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.SG.Model.Match;
import com.SG.Model.Team;
import com.SG.Model.Enum.MatchState;
import com.SG.Service.MatchService;
import com.SG.Service.MatchServiceImpl;
import com.SG.Service.RuleServiceImpl;
import com.SG.Service.ScoreService;

import junit.framework.Assert;

public class UseCase2 {
	
	private MatchServiceImpl matchService = new MatchServiceImpl();
	private Match match = matchService.createMatch();
	@Autowired
	private RuleServiceImpl ruleService = new RuleServiceImpl();


	@Test
	public void test_UpdateScore_Story_Advantage(){
		int numberOfExpectedWinnedGame = this.match.getTeamA().getNumberWinnedGame() + 1;
		this.match.setState(MatchState.DEUCE);
		match.getTeamA().setAdvantaged(true);
		ruleService.initializeRule(this.match);
		match.getRule().updateScore(match, match.getTeamA());
//		team A will win the games
		Assert.assertEquals(numberOfExpectedWinnedGame, match.getTeamA().getNumberWinnedGame());
	}
	
	@Test
	public void test_UpdateScore_Story_Not_Advantage(){
		boolean expectedAdvantage = true;
		this.match.setState(MatchState.DEUCE);
		ruleService.initializeRule(this.match);
		match.getRule().updateScore(match, match.getTeamA());
//		team A will have the advantage 
		Assert.assertEquals(expectedAdvantage, match.getTeamA().isAdvantaged());
	}

}
