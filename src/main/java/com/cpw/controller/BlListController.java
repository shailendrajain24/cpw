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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.BlListResponse;
import com.cpw.services.BlListImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class BlListController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/bldata", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<List<? extends BlListResponse>> BlList(
			@RequestParam(value = "userType", required = false) String userType,
			@RequestParam(value = "userId", required = false) int userId) {
		logger.debug("Entering into BlList");
		try {
			if (userType.isEmpty() && userId != 0) {
				return new ResponseEntity<List<? extends BlListResponse>>(Collections.emptyList(),
						HttpStatus.NOT_FOUND);
			}
			BlListImpl blListImpl = new BlListImpl();
			List<BlListResponse> blListResponseList = blListImpl.getBlList(userType, userId);
			if (blListResponseList != null && !blListResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends BlListResponse>>(blListResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends BlListResponse>>(blListResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
