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

import com.cpw.model.IndustryResponse;
import com.cpw.services.IndustryImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class IndustryController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/industry", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends IndustryResponse>> Tracking() {
		logger.debug("Entering into industry");
		try {
			IndustryImpl industryImpl = new IndustryImpl();
			List<IndustryResponse> industryResponseList = industryImpl.industryList();
			if (industryResponseList != null && !industryResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends IndustryResponse>>(industryResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends IndustryResponse>>(industryResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
