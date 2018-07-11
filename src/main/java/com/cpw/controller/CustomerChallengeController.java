/**
 * 
 */
package com.cpw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.CustomerChallengeRequest;
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

}
