package com.wow.botservice.resources;

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

@RestController
public class Authenticator {

	@Autowired
	private ICompareService compareService;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Autowired
    private ApplicationProperties properties;

	@RequestMapping(value = "/purchaseOrder", method = RequestMethod.GET)
	public ResponseEntity<PurchaseOrder> getPOStatus(@RequestParam("poNbr") final String poNbr) throws CompareException {
		PurchaseOrder po = new PurchaseOrder();
		//po.setStatus("Closed");
		po.setPoNbr(poNbr);
		po = this.compareService.getPurchaseOrder(po);
		return new ResponseEntity<PurchaseOrder>(po, HttpStatus.OK);
	}
	
	@RequestMapping(value = "rest/purcharOrder", method = RequestMethod.PUT)
	public ResponseEntity<String> addPurchaseOrder(@RequestBody final PurchaseOrder po) throws CompareException {

		PurchaseOrder order = this.compareService.addPurchaseOrder(po);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
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
