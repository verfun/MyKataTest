package com.SG.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.SG.Model.Enum.ValueDeucePoint;
import com.SG.Model.Enum.ValuePoint;


@Entity
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private ValuePoint value;
	private ValueDeucePoint valueDeuce;
	private int tieBreakPoint;
	private Team team;
	
	public Score() {
		super();
		this.value = ValuePoint.ZERO;
		this.valueDeuce = ValueDeucePoint.ZERO;
		this.tieBreakPoint = 0;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public ValuePoint getValue() {
		return value;
	}
	public void setValue(ValuePoint value) {
		this.value = value;
	}
	public ValueDeucePoint getValueDeuce() {
		return valueDeuce;
	}
	public void setValueDeuce(ValueDeucePoint valueDeuce) {
		this.valueDeuce = valueDeuce;
	}
	public int getTieBreakPoint() {
		return tieBreakPoint;
	}
	public void setTieBreakPoint(int tieBreakPoint) {
		this.tieBreakPoint = tieBreakPoint;
	}
	
		
}
