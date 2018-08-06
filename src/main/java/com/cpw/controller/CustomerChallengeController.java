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

import com.cpw.model.CustomerChallengeRequest;
import com.cpw.model.CustomerChallengeResponse;
import com.cpw.services.CustomerChallengeImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class CustomerChallengeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/customerChallenge", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> customerChallenge(@RequestBody CustomerChallengeRequest request) {

		logger.debug("Entering into CustomerChallenge");
		try {
			if (request.getId() == 0 || request.getCustomerId() == 0 || request.getInchargeId() == 0) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("ID : " + request.getId() + " Customer ID : " + request.getCustomerId());
			CustomerChallengeImpl customerChallengeImpl = new CustomerChallengeImpl();
			int response = customerChallengeImpl.customerChallenge(request);
			if (response > 0) {
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
@RequestMapping(value="customerChallengeList/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends CustomerChallengeResponse>> CustomerChallenge(@PathVariable("id") long id)
	{
	logger.debug("Entering into List");
	try {
		CustomerChallengeImpl customerChallengeImpl=new CustomerChallengeImpl();
		List<CustomerChallengeResponse> customerChallengeResponse=customerChallengeImpl.customerChallengeList(id);
		if(customerChallengeResponse!=null && !customerChallengeResponse.isEmpty())
		{
			return new ResponseEntity<List<? extends CustomerChallengeResponse>>(customerChallengeResponse, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<? extends CustomerChallengeResponse>>(customerChallengeResponse, HttpStatus.NO_CONTENT);
		}
		
	} catch (Exception e) {
		logger.debug("No list in the system");
		e.printStackTrace();
	}
		return null;
		
	}

}
