package com.SG.Model.Enum;

public enum MatchState {
	
	SIMPLE("SIMPLE"),DEUCE("DEUCE"),TIE_BREAK("TIE-BREAK"),FINISHED("FINISHED");
	
	private String name;

	private MatchState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
