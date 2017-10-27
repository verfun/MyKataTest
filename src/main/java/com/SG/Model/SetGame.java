package com.SG.Model;

import java.util.ArrayList;
import java.util.List;

import com.SG.Model.Enum.GameStatus;

public class SetGame {
	
	private Long id; 
	private List<Game> games;
	private GameStatus setStatus;
	private Match match; 
	
	
	public SetGame(Match match) {
		super();
		this.games = new ArrayList<Game>();
		this.match = match;
		this.setStatus = GameStatus.CURRENT;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public GameStatus getSetStatus() {
		return setStatus;
	}
	public void setSetStatus(GameStatus setStatus) {
		this.setStatus = setStatus;
	}
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}	
	
}
