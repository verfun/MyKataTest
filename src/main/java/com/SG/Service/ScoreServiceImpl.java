package com.SG.Service;

import org.springframework.stereotype.Service;

import com.SG.Model.Score;
import com.SG.Model.Team;
import com.SG.Model.Enum.ValueDeucePoint;
import com.SG.Model.Enum.ValuePoint;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Override
	public void initiliazeScore(Team team) {
		Score score = team.getScore();
		score.setValue(ValuePoint.ZERO);
		score.setTieBreakPoint(0);
		score.setValueDeuce(ValueDeucePoint.ZERO);
	}

}
