package com.SG.Service;

import com.SG.Model.Game;
import com.SG.Model.Match;
import com.SG.Model.SetGame;
import com.SG.Model.Enum.GameStatus;

public interface MatchService {

	void updateMatchState(Match match);
	
	SetGame getSetGameWithStatus(Match match, GameStatus gameStatus);

	Game getGameWithStatus(SetGame setGame, GameStatus gameStatus);
	
	Match createMatch();
	
}
