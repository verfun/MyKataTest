package com.SG.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Score score;
	private String name;
	private boolean advantaged = false;
	private int numberWinnedGame = 0;
	private int numberWinnedSetGame = 0;
	
	
	public Team(String name) {
		super();
		this.name = name;
		this.score = new Score();
	}
	public Team() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAdvantaged() {
		return advantaged;
	}
	public void setAdvantaged(boolean advantaged) {
		this.advantaged = advantaged;
	}
	public int getNumberWinnedGame() {
		return numberWinnedGame;
	}
	public void setNumberWinnedGame(int numberWinnedGame) {
		this.numberWinnedGame = numberWinnedGame;
	}
	public int getNumberWinnedSetGame() {
		return numberWinnedSetGame;
	}
	public void setNumberWinnedSetGame(int numberWinnedSetGame) {
		this.numberWinnedSetGame = numberWinnedSetGame;
	}
	
	
}
