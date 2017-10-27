package com.SG.Model;

import com.SG.Model.Enum.GameStatus;
import com.SG.Model.Enum.ValuePoint;
import com.SG.Service.MatchServiceImpl;
import com.SG.Service.RuleServiceImpl;


public class GameRule {
	
	private Match match;
	private RuleServiceImpl ruleService = new RuleServiceImpl();
	private MatchServiceImpl matchService = new MatchServiceImpl();
	
	public void updateScore(Match match,Team team){
		switch (team.getScore().getValue().getValue()) 	{
		case 0: team.getScore().setValue(ValuePoint.FEFTEEN);
			break;
		case 15: team.getScore().setValue(ValuePoint.THIRTY);
			break;
		case 30: team.getScore().setValue(ValuePoint.FORTY);
				 matchService.updateMatchState(match);
			break;
		case 40: ruleService.winGame(match, team);
			break;
		}
	}
	
	public void winGame(Match match, Team team) {
		int winnedGame = team.getNumberWinnedGame()+1;
		team.setNumberWinnedGame(winnedGame);
		this.storeGame(match,team);
		this.ruleService.winSetGame(match, team);
	}

	private void storeGame(Match match, Team team) {
		Game game = matchService.getGameWithStatus(matchService.getSetGameWithStatus(match, GameStatus.CURRENT), GameStatus.CURRENT);
		
	}

	public void winSetGame(Match match, Team team) {
		int winnedSetGame = team.getNumberWinnedSetGame()+1;
		team.setNumberWinnedSetGame(winnedSetGame);
		this.ruleService.winMatch(match, team);
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
}
