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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.LeadStatusResponse;
import com.cpw.services.LeadStatusImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class LeadStatusController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/leadStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends LeadStatusResponse>> Tracking() {
		logger.debug("Entering into leadStatus");
		try {
			LeadStatusImpl leadStatusImpl = new LeadStatusImpl();
			List<LeadStatusResponse> leadStatusResponseList = leadStatusImpl.leadStatusList();
			if (leadStatusResponseList != null && !leadStatusResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends LeadStatusResponse>>(leadStatusResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends LeadStatusResponse>>(leadStatusResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
