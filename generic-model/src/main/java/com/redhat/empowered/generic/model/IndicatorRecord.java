package com.redhat.empowered.generic.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class IndicatorRecord implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String uid;
	protected BigDecimal value;
	protected Date timestmp;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Date getTimestmp() {
		return timestmp;
	}
	
	public void setTimestmp(Date timestmp) {
		this.timestmp = timestmp;
	}
	
	//allows to do roundings to calculate frequency chart
	public abstract BigDecimal frequencyGroupValue();
	
}
