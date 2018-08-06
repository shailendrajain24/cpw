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

import com.cpw.model.CallRequest;
import com.cpw.model.CallResponse;
import com.cpw.services.CallImpl;

@RestController
public class CallController {

	private final Logger logger=LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="addCall", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.ALL_VALUE)
	public ResponseEntity<?> upsertCall(@RequestBody CallRequest request)
	{
		logger.debug("Entering into Call");
		try {

			CallImpl callImpl=new CallImpl();
			int response=callImpl.upsertCall(request);

			if(response>0){
				return new ResponseEntity<Object>(HttpStatus.CREATED);

			}else {

				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}


		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}
	@RequestMapping(value="calls/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends CallResponse>> Call(@PathVariable ("id")long callId)
	{
		logger.debug("Entering into call list");
		try {
			CallImpl callImpl=new CallImpl();
			List<CallResponse> callResponse=callImpl.callList(callId);
			if(callResponse!= null && !callResponse.isEmpty())
			{
				return new ResponseEntity<List<? extends CallResponse>>(callResponse,HttpStatus.OK);
			}else {
				return new ResponseEntity<List<? extends CallResponse>>(callResponse, HttpStatus.NO_CONTENT);

			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
	@RequestMapping(value="removeCall/{id}", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> removeList(@PathVariable("id") long callId)
	{
		logger.debug("Entering into Remove");
		
		try {
			CallImpl callImpl=new CallImpl();
			int response=callImpl.removeCall(callId);
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
