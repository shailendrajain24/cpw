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

import com.cpw.model.PramotionalRequest;
import com.cpw.model.PramotionalResponse;
import com.cpw.services.PramotionalImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class PramotionalController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/pramotional", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> pramotional(@RequestBody PramotionalRequest request) {

		logger.debug("Entering into Pramotional");
		/*
		LocalDateTime ldt = LocalDateTime.ofInstant(request.getCreatedDate().toInstant(), ZoneId.systemDefault());
		System.out.println(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
		System.out.println(request.getCreatedDate());
		String a = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);
		 * */
		try {
			if (request.getPrimaryId() == 0 || request.getFromEmailId().isEmpty() || request.getToEmailId().isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("Primary ID : " + request.getPrimaryId());
			PramotionalImpl pramotionalImpl = new PramotionalImpl();
			int response = pramotionalImpl.pramotional(request);
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

	@RequestMapping(value="pramotion/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends PramotionalResponse>> Pramotional(@PathVariable("id")long primaryId)
	{
		logger.debug("Entering into Pramotional List");

		try {
			PramotionalImpl pramotionalImpl=new PramotionalImpl();
			List<PramotionalResponse> pramotionalResponse=pramotionalImpl.pramotionalList(primaryId);
			if(pramotionalResponse!=null && !pramotionalResponse.isEmpty())
			{
				return new ResponseEntity<List<? extends PramotionalResponse>>(pramotionalResponse,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<? extends PramotionalResponse>>(pramotionalResponse,HttpStatus.NO_CONTENT);

			}

		} catch (Exception e) {
			logger.debug("NO Pramotional List in the system");
			e.printStackTrace();
		}
		return null;

	}
	@RequestMapping(value="removePramotional/{id}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removePramotional(@PathVariable("id")long primaryId)
	{
		logger.debug("Entering into remove List" +primaryId);
		try {
			PramotionalImpl pramotionalImpl=new PramotionalImpl();
			int response=pramotionalImpl.removePramotional(primaryId);
			if(response > 0)
			{
				return new ResponseEntity<Object>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

}
