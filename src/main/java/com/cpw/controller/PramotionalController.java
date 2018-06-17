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

import com.cpw.model.PramotionalRequest;
import com.cpw.services.PramotionalImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class PramotionalController {
	private static final String SUCCESS_STATUS = "SUCESS";
	private static final String FAILED_STATUS = "FAILED";
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/pramotional", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> pramotional(@RequestBody PramotionalRequest request) {

		logger.debug("Entering into Pramotional");
		try {
			if (request.getPrimaryId() == 0 || request.getFromEmailId().isEmpty() || request.getToEmailId().isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("Primary ID : " + request.getPrimaryId());
			PramotionalImpl pramotionalImpl = new PramotionalImpl();
			String response = pramotionalImpl.pramotional(request);
			if (response.equals(SUCCESS_STATUS)) {
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			} else if (response.equals(FAILED_STATUS)) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}

			return null;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
