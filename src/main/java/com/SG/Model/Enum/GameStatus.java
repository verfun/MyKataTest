package com.SG.Model.Enum;

public enum GameStatus {
	
	CURRENT("CURRENT"), FINISHED("FINISHED");
	
	private GameStatus(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
