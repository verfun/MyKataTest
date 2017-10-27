package com.SG.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SG.Model.Deuce;
import com.SG.Model.Game;
import com.SG.Model.Match;
import com.SG.Model.GameRule;
import com.SG.Model.Score;
import com.SG.Model.SetGame;
import com.SG.Model.Team;
import com.SG.Model.TieBreak;
import com.SG.Model.Enum.GameStatus;
import com.SG.Model.Enum.MatchState;

@Service
public class RuleServiceImpl implements RuleService{
	
	private MatchServiceImpl matchService = new MatchServiceImpl();
	private ScoreServiceImpl scoreService =  new ScoreServiceImpl();

	@Override
	public void initializeRule(Match match) {
		if(match.getState().equals(MatchState.DEUCE)) {
			match.setRule(new Deuce());
		}else if(match.getState().equals(MatchState.TIE_BREAK))
			match.setRule(new TieBreak());
		else 
			match.setRule(new GameRule());
	}
	
	@Override
	public void winGame(Match match, Team team) {
		this.matchService.updateMatchState(match);
		this.initializeRule(match);
		match.getRule().winGame(match, team);
		SetGame setGame = matchService.getSetGameWithStatus(match, GameStatus.CURRENT);
		Game game = matchService.getGameWithStatus(setGame, GameStatus.CURRENT);
		game.setWinner(team);
		game.setGameStatus(GameStatus.FINISHED);
	}

	public void winSetGame(Match match, Team team) {
		this.matchService.updateMatchState(match);
		this.initializeRule(match);
		match.getRule().winSetGame(match, team);
		
	}

	public void winMatch(Match match, Team team) {
		if(team.getNumberWinnedSetGame() > (match.getNbrOfSetGame() / 2) )
			match.setWinner(team);
	}

}
