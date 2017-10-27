package com.SG.Service;

import com.SG.Model.Match;

import org.springframework.stereotype.Service;

import com.SG.Model.GameRule;
import com.SG.Model.Team;

@Service
public interface RuleService {
	
	void initializeRule(Match match);

	void winGame(Match match, Team team);

}
