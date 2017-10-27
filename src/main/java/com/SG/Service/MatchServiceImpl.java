package com.SG.Service;

import static org.mockito.Matchers.matches;

import org.springframework.stereotype.Service;

import com.SG.Model.Game;
import com.SG.Model.Match;
import com.SG.Model.SetGame;
import com.SG.Model.Team;
import com.SG.Model.Enum.GameStatus;
import com.SG.Model.Enum.MatchState;
import com.SG.Model.Enum.ValuePoint;

@Service
public class MatchServiceImpl implements MatchService {
	
	private ScoreServiceImpl scoreService = new ScoreServiceImpl();
	
	@Override
	public void updateMatchState(Match match) {
		if(isDeuce(match))
			match.setState(MatchState.DEUCE);
		else if(isTieBreak(match))
			match.setState(MatchState.TIE_BREAK);
		else
			match.setState(MatchState.SIMPLE);
	}

	private boolean isTieBreak(Match match) {
		return match.getTeamA().getNumberWinnedGame() == match.getTeamB().getNumberWinnedGame() && match.getTeamB().getNumberWinnedGame() == 7;
	}

	private boolean isDeuce(Match match) {
		return match.getTeamA().getScore().getValue().equals(match.getTeamB().getScore().getValue())
					&& match.getTeamA().getScore().getValue().equals(ValuePoint.FORTY);
	}

	public Team getOpponent(Match match, Team team) {
		return (match.getTeamA().getName().equals(team.getName())) ? team : match.getTeamB();
	}

	@Override
	public SetGame getSetGameWithStatus(Match match, GameStatus setGameStatus) {
		for(SetGame curreentSet : match.getSetGames()) {
			if(curreentSet.getSetStatus().equals(setGameStatus))
				return curreentSet;
		}
		return null;
	}

	@Override
	public Game getGameWithStatus(SetGame setGame, GameStatus gameStatus) {
		for(Game curreentGame : setGame.getGames()) {
			if(curreentGame.getGameStatus().equals(gameStatus))
				return curreentGame;
		}
		return null;
	}

	@Override
	public Match createMatch() {
		Match match = new Match(new Team("TeamA"), new Team("TeamB"));
		SetGame firstSet = new SetGame(match);
		match.getSetGames().add(firstSet);
		Game firstGame = new Game(GameStatus.CURRENT,firstSet);
		firstSet.getGames().add(firstGame);
		scoreService.initiliazeScore(match.getTeamA());
		scoreService.initiliazeScore(match.getTeamB());
		return match;
	}

	
}
