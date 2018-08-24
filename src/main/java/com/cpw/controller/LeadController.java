/**
 * 
 */
package com.cpw.controller;

import java.util.Collections;
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

import com.cpw.model.LeadData;
import com.cpw.model.LeadDataResponse;
import com.cpw.services.LeadImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class LeadController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/leads/{createdBy}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends LeadDataResponse>> leads(@PathVariable("createdBy") String createdBy) {
		logger.debug("Entering into lead list");
		try {
			LeadImpl leadImpl = new LeadImpl();
			List<LeadDataResponse> leadDateResponse = leadImpl.leadList(createdBy);
			if (leadDateResponse == null || leadDateResponse.isEmpty()) {
				return new ResponseEntity<List<? extends LeadDataResponse>>(leadDateResponse, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<? extends LeadDataResponse>>(leadDateResponse, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<? extends LeadDataResponse>>(Collections.emptyList(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/removeLead/{leadId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeLead(@PathVariable("leadId") long leadId) {
		logger.debug("Entering into removeLead");
		try {
			LeadImpl leadImpl = new LeadImpl();
			int response = leadImpl.removeLead(leadId);
			if (response > 0) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/addLead", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> upsertLead(@RequestBody LeadData request) {

		logger.debug("Entering into addLead");
		try {
			if (request.getCompany().isEmpty() || request.getLastName().isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("Company : " + request.getCompany());
			LeadImpl leadImpl = new LeadImpl();
			int response = leadImpl.upsertLead(request);
			if (response > 0) {
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
