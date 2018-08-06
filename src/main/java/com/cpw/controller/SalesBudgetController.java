/**
 * 
 */
package com.cpw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.SalesBudgetRequest;
import com.cpw.model.SalesBudgetResponse;
import com.cpw.services.SalesBudgetImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class SalesBudgetController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/salesBudget", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salesBudget(@RequestBody SalesBudgetRequest request) {

		logger.debug("Entering into SalesBudget");
		try {
			if (request.getId() == 0 || request.getBudgetNumber().isEmpty() || request.getBudgetType()==0) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("ID : " + request.getId() +" Budget Number : "+ request.getBudgetNumber());
			SalesBudgetImpl salesBudgetImpl = new SalesBudgetImpl();
			int response = salesBudgetImpl.salesBudget(request);
			if (response>0) {
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="salesBudgetList/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends SalesBudgetResponse>> SalesBudget(@PathVariable("id")long id)
	{
		logger.debug("Entering into saleBudget List");
		
		try {
			SalesBudgetImpl salesBudgetImpl=new SalesBudgetImpl();
			List<SalesBudgetResponse> salesBudgetResponse=salesBudgetImpl.salesBudgetResponseList(id);
			if(salesBudgetResponse!=null && !salesBudgetResponse.isEmpty())
			{
				return new ResponseEntity<List<? extends SalesBudgetResponse>>(salesBudgetResponse, HttpStatus.OK);
			}else {
				
				return new ResponseEntity<List<? extends SalesBudgetResponse>>(salesBudgetResponse, HttpStatus.NO_CONTENT);
				
			}
			
		} catch (Exception e) {
			logger.debug("No salesBudgetList in system");
			e.printStackTrace();
		}
		return null;
		
	}

}
