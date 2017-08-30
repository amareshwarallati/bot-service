package com.wow.botservice.model;

import java.util.ArrayList;
import java.util.List;

public class SearchResult{
	
	private String tableName;
	private String whereClause;
	private ArrayList<ArrayList<ValueObject>> dataList1;
	private ArrayList<ArrayList<ValueObject>> dataList2;
	private List<String> headers;
	private String refInstance;
	private String compInstance;
	
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
	public ArrayList<ArrayList<ValueObject>> getDataList1() {
		return dataList1;
	}
	public void setDataList1(ArrayList<ArrayList<ValueObject>> dataList1) {
		this.dataList1 = dataList1;
	}
	public ArrayList<ArrayList<ValueObject>> getDataList2() {
		return dataList2;
	}
	public void setDataList2(ArrayList<ArrayList<ValueObject>> dataList2) {
		this.dataList2 = dataList2;
	}
	public List<String> getHeaders() {
		return headers;
	}
	public void setHeaders(List<String> headers) {
		this.headers = headers;
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
	
}