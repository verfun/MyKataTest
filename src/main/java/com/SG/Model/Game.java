package com.SG.Model;

import com.SG.Model.Enum.GameStatus;

public class Game {
	
	private Long id;
	private Team winner;
	private GameStatus gameStatus;
	private SetGame setGame;
	
	
	
	public Game(GameStatus gameStatus, SetGame setGame) {
		super();
		this.gameStatus = gameStatus;
		this.setGame = setGame;
		this.winner = new Team();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Team getWinner() {
		return winner;
	}
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	public GameStatus getGameStatus() {
		return gameStatus;
	}
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	public SetGame getSetGame() {
		return setGame;
	}
	public void setSetGame(SetGame setGame) {
		this.setGame = setGame;
	}
	
}
