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

import com.cpw.model.RatingResponse;
import com.cpw.services.RatingImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class RatingController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/rating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends RatingResponse>> Tracking() {
		logger.debug("Entering into rating");
		try {
			RatingImpl ratingImpl = new RatingImpl();
			List<RatingResponse> ratingResponseList = ratingImpl.ratingList();
			if (ratingResponseList != null && !ratingResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends RatingResponse>>(ratingResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends RatingResponse>>(ratingResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
