package com.SG.Model;

import com.SG.Service.MatchServiceImpl;
import com.SG.Service.RuleServiceImpl;
import com.SG.Service.ScoreServiceImpl;

public class Deuce extends GameRule {
	
	private RuleServiceImpl ruleService = new RuleServiceImpl();
	private MatchServiceImpl matchService = new MatchServiceImpl();
	private ScoreServiceImpl scoreService =  new ScoreServiceImpl();

	@Override
	public void updateScore(Match match, Team team) {
		if(team.isAdvantaged()) {
			this.winGame(match, team);
		}else {
			Team teamOpponent = this.matchService.getOpponent(match, team);
			if(teamOpponent.isAdvantaged()) {
				teamOpponent.setAdvantaged(false);
			}else {
				team.setAdvantaged(true);
			}
		}
	}

}
