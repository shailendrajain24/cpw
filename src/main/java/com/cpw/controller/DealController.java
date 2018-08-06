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

import com.cpw.model.DealRequest;
import com.cpw.model.DealResponse;
import com.cpw.services.DealImpl;


@RestController
public class DealController {

	private final Logger logger=LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="addDeals" , method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.ALL_VALUE)
	public ResponseEntity<?> upsertDeal(@RequestBody DealRequest Request){

		logger.debug("Entering into Deals");

		try {

			DealImpl dealImpl=new DealImpl();
			int response=dealImpl.upsertDeal(Request);

			if(response>0)
			{
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	@RequestMapping(value="deals/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<? extends DealResponse>> Deals(@PathVariable("id")long dealId)
	{
		logger.debug("Entering into deal list");
		try {
			DealImpl dealImpl=new DealImpl();
			List<DealResponse> dealResponse=dealImpl.dealList(dealId);
			if(dealResponse!= null && !dealResponse.isEmpty())
			{
				return new ResponseEntity<List<? extends DealResponse>>(dealResponse,HttpStatus.OK);
			}else {
				return new ResponseEntity<List<? extends DealResponse>>(dealResponse, HttpStatus.NO_CONTENT);

			}


		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;

	}
	@RequestMapping(value="removeDeal/{id}", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> removeList(@PathVariable("id") long dealId)
	{
		logger.debug("Entering into Remove");
		
		try {
			DealImpl dealImpl=new DealImpl();
			int response=dealImpl.removeList(dealId);
			if (response>0) {
				
				return new ResponseEntity<Object>(HttpStatus.OK);
				
			} else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}



}
