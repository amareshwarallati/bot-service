package com.wow.botservice.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.wow.botservice.model.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wow.botservice.configuration.ApplicationProperties;
import com.wow.botservice.dao.ICompareDAO;
import com.wow.botservice.exception.CompareException;
import com.wow.botservice.model.SearchCriteria;
import com.wow.botservice.model.SearchResult;
import com.wow.botservice.model.ValueObject;

@Component
public class CompareService implements ICompareService{

	@Autowired
	private ICompareDAO compareDAO;
	
	@Autowired
    private ApplicationProperties properties;
	
	@Override
	public SearchCriteria getInitialData() throws CompareException {
		SearchCriteria sc = null;
		try{
			sc = this.compareDAO.getInitialData();
		}catch(CompareException e){
			throw e;
		}
		return null;
	}

	@Override
	public PurchaseOrder getPurchaseOrder(PurchaseOrder po) throws CompareException {
		try{
			po = this.compareDAO.getPurchaseOrder(po);
		}catch(CompareException e){
			throw e;

		}
		return po;
	}

	@Override
	public PurchaseOrder addPurchaseOrder(PurchaseOrder po) throws CompareException {
		return new PurchaseOrder();
	}
}