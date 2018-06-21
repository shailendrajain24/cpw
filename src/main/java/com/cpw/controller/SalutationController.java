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

import com.cpw.model.SalutationResponse;
import com.cpw.services.SalutationImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class SalutationController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/salutation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends SalutationResponse>> Tracking() {
		logger.debug("Entering into salutation");
		try {
			SalutationImpl salutationImpl = new SalutationImpl();
			List<SalutationResponse> salutationResponseList = salutationImpl.salutationList();
			if (salutationResponseList != null && !salutationResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends SalutationResponse>>(salutationResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends SalutationResponse>>(salutationResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
