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

import com.cpw.model.LeadSourceResponse;
import com.cpw.services.LeadSourceImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class LeadSourceController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/leadSource", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends LeadSourceResponse>> Tracking() {
		logger.debug("Entering into leadSource");
		try {
			LeadSourceImpl leadSourceImpl = new LeadSourceImpl();
			List<LeadSourceResponse> leadSourceResponseList = leadSourceImpl.leadSourceList();
			if (leadSourceResponseList != null && !leadSourceResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends LeadSourceResponse>>(leadSourceResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends LeadSourceResponse>>(leadSourceResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
