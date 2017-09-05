package com.wow.botservice.resources;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wow.botservice.configuration.ApplicationProperties;
import com.wow.botservice.exception.CompareException;
import com.wow.botservice.model.ErrorResponse;
import com.wow.botservice.model.PurchaseOrder;
import com.wow.botservice.model.SearchCriteria;
import com.wow.botservice.model.SearchResult;
import com.wow.botservice.service.ICompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
public class Authenticator {

	@Autowired
	private ICompareService compareService;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Autowired
    private ApplicationProperties properties;

	//Get status of the purchaser order using GET method for simple NON- API.AI clients.
	@RequestMapping(value = "rest/getStatus", method = RequestMethod.GET)
	public ResponseEntity<PurchaseOrder> getPOStatus(@RequestParam("poNbr") final String poNbr) throws CompareException {
		PurchaseOrder po = new PurchaseOrder();
		//po.setStatus("Closed");
		po.setPoNbr(poNbr);
		po = this.compareService.getPurchaseOrder(po);
		return new ResponseEntity<PurchaseOrder>(po, HttpStatus.OK);
	}

	//Add purchase order to database.
	@RequestMapping(value = "rest/addOrder", method = RequestMethod.POST)
	public ResponseEntity<String> addPurchaseOrder(@RequestBody final PurchaseOrder po) throws CompareException {
		String res = this.compareService.addPurchaseOrder(po);
		return new ResponseEntity<String>(res, HttpStatus.CREATED);
	}

	// Get status of purchse order based on the order Id - For API.AI reuests.
	@RequestMapping(value = "rest/getStatus", method = RequestMethod.POST)
	public ResponseEntity<ObjectNode> addPurchaseOrder(@RequestBody String postMsg) throws JsonParseException, IOException,CompareException {
		ObjectMapper om = new ObjectMapper();
		JsonNode jNode = om.readTree(postMsg);
		PurchaseOrder po = new PurchaseOrder();
		po.setPoNbr(jNode.get("result").get("parameters").get("poNbr").asText());
		po = this.compareService.getPurchaseOrder(po);

		ObjectNode jn = JsonNodeFactory.instance.objectNode();


		ObjectNode result = JsonNodeFactory.instance.objectNode();
		if(po != null && po.getPoNbr() != null) {
			result.put("speech", "The status of the order '" + po.getPoNbr() + "' " + "is " + po.getStatus());
			result.put("displayText", "The status of the order '" + po.getPoNbr() + "' " + "is " + po.getStatus());
		}else{
			result.put("speech", "The  order '" + jNode.get("result").get("parameters").get("poNbr").asText() + "' " + "is not found.");
			result.put("displayText", "The  order '" + jNode.get("result").get("parameters").get("poNbr").asText() + "' " + "is not found.");

		}
		result.put("data", JsonNodeFactory.instance.objectNode());
		result.put("contextOut", JsonNodeFactory.instance.arrayNode());
		result.put("source", "Heroku-Amar");
		//result.put("followupEvent", JsonNodeFactory.instance.textNode(""));
/*
		if(po != null && po.getPoNbr() != null) {
			jn.put("poNbr", po.getPoNbr());
			jn.put("status", po.getStatus());
		}else{
			jn.put("poNbr", jNode.get("result").get("parameters").get("poNbr").asText());
			jn.put("status", "N/A");
		}
*/
		return new ResponseEntity<ObjectNode>(result, HttpStatus.OK);
	}
	
	@ExceptionHandler(CompareException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error,
				HttpStatus.EXPECTATION_FAILED);
	}
}
