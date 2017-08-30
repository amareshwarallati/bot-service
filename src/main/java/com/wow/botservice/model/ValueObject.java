package com.wow.botservice.model;

import java.io.Serializable;

public class ValueObject implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String instanceName;
	private String colName;
	private String colValue;

	
	public ValueObject(String refInstance, String colName, String colValue) {
		this.setInstanceName(refInstance);
		this.setColName(colName);
		this.setColValue(colValue);
	}


	public String getInstanceName() {
		return instanceName;
	}


	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}


	public String getColName() {
		return colName;
	}


	public void setColName(String colName) {
		this.colName = colName;
	}


	public String getColValue() {
		return colValue;
	}


	public void setColValue(String colValue) {
		this.colValue = colValue;
	}

}