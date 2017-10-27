package com.SG.Model.Enum;

public enum ValuePoint {

	ZERO(0),FEFTEEN(15),THIRTY(30),FORTY(40);
	
	private int value;

	private ValuePoint(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
