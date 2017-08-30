package com.wow.botservice.model;

import java.util.List;

public class SearchCriteria{
	
	private String tableName;
	private String whereClause;
	private List<String> instances;
	private List<String> tables;
	private String refInstance;
	private String compInstance;
	private String query;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getWhereClause() {
		return whereClause;
	}
	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}
	public List<String> getInstances() {
		return instances;
	}
	public void setInstances(List<String> instances) {
		this.instances = instances;
	}
	public String getRefInstance() {
		return refInstance;
	}
	public void setRefInstance(String refInstance) {
		this.refInstance = refInstance;
	}
	public String getCompInstance() {
		return compInstance;
	}
	public void setCompInstance(String compInstance) {
		this.compInstance = compInstance;
	}
	public List<String> getTables() {
		return tables;
	}
	public void setTables(List<String> tables) {
		this.tables = tables;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
}