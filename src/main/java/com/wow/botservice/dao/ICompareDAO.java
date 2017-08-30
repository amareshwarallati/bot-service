package com.wow.botservice.dao;

import com.wow.botservice.exception.CompareException;
import com.wow.botservice.model.PurchaseOrder;
import com.wow.botservice.model.SearchCriteria;
import com.wow.botservice.model.ValueObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ICompareDAO {

	public SearchCriteria getInitialData() throws CompareException;

	public Map<String, ArrayList<ValueObject>> getData(String query, String refInstance, List<String> pKeyList, List<String> colList);

	public PurchaseOrder getPurchaseOrder(PurchaseOrder po) throws CompareException;
	public String addPurchaseOrder(PurchaseOrder po) throws CompareException;
}
