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

import com.cpw.model.TrackingResponse;
import com.cpw.services.TrackingImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class TrackingController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/tracking", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends TrackingResponse>> Tracking() {
		logger.debug("Entering into Tracking");
		try {
			TrackingImpl trackingImpl = new TrackingImpl();
			List<TrackingResponse> trackingResponseList = trackingImpl.trackingDetail();
			if (trackingResponseList != null && !trackingResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends TrackingResponse>>(trackingResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends TrackingResponse>>(trackingResponseList,
						HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
