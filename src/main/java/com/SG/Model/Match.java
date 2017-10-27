package com.SG.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.SG.Model.Enum.MatchState;

@Entity
public class Match implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Team teamA;
	private Team teamB;
	private int nbrOfSetGame;
	private GameRule rule;
	private MatchState state;
	private Team winner;
	private List<SetGame> setGames;
	
	public Match(Team teamA, Team teamB) {
		 this.teamA = teamA;
		 this.teamB = teamB;
		 this.nbrOfSetGame = 3;
		 this.rule = new GameRule();
		 this.state = MatchState.SIMPLE;
		 this.setGames = new ArrayList<SetGame>();
	}
	
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	public int getNbrOfSetGame() {
		return nbrOfSetGame;
	}
	public void setNbrOfSetGame(int nbrOfSetGame) {
		this.nbrOfSetGame = nbrOfSetGame;
	}
	public GameRule getRule() {
		return rule;
	}
	public void setRule(GameRule rule) {
		this.rule = rule;
	}
	public MatchState getState() {
		return state;
	}
	public void setState(MatchState state) {
		this.state = state;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public List<SetGame> getSetGames() {
		return setGames;
	}

	public void setSetGames(List<SetGame> setGames) {
		this.setGames = setGames;
	}
	
	
	
}
