package com.SG.Model.Enum;

public enum ValueDeucePoint {

	ZERO(0),ONE(1),TOW(2);
	
	private int value;

	private ValueDeucePoint(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
