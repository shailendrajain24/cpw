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

import com.cpw.model.VesselResponse;
import com.cpw.services.VesselImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class VesselController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/vessel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends VesselResponse>> Tracking() {
		logger.debug("Entering into Tracking");
		try {
			VesselImpl vesselImpl = new VesselImpl();
			List<VesselResponse> vesselResponseList = vesselImpl.vesselList();
			if (vesselResponseList != null && !vesselResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends VesselResponse>>(vesselResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends VesselResponse>>(vesselResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
