package com.wow.botservice.service;

import com.wow.botservice.exception.CompareException;
import com.wow.botservice.model.PurchaseOrder;
import com.wow.botservice.model.SearchCriteria;
import com.wow.botservice.model.SearchResult;

public interface ICompareService{
	
	public SearchCriteria getInitialData() throws CompareException;
	public PurchaseOrder addPurchaseOrder(PurchaseOrder po) throws CompareException;
	public PurchaseOrder getPurchaseOrder(PurchaseOrder po) throws CompareException;
}