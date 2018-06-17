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

import com.cpw.model.CustChallangePriortyResponse;
import com.cpw.services.CustChallangePriortyImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class CustChallangePriortyController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/custChallangePriorty", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends CustChallangePriortyResponse>> CustChallangePriorty() {
		logger.debug("Entering into CustChallangePriorty");
		try {
			CustChallangePriortyImpl custChallangePriortyImpl = new CustChallangePriortyImpl();
			List<CustChallangePriortyResponse> custChallangePriortyResponseList = custChallangePriortyImpl
					.custChallangePriortyList();
			if (custChallangePriortyResponseList != null && !custChallangePriortyResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends CustChallangePriortyResponse>>(
						custChallangePriortyResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends CustChallangePriortyResponse>>(
						custChallangePriortyResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
