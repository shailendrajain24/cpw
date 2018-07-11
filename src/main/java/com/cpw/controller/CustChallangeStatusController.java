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

import com.cpw.model.CustChallangeStatusResponse;
import com.cpw.services.CustChallangeStatusImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class CustChallangeStatusController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/custChallangeStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends CustChallangeStatusResponse>> CustChallangeStatus() {
		logger.debug("Entering into CustChallangeStatus");
		try {
			CustChallangeStatusImpl custChallangeStatusImpl = new CustChallangeStatusImpl();
			List<CustChallangeStatusResponse> custChallangeStatusResponseList = custChallangeStatusImpl
					.custChallangeStatusList();
			if (custChallangeStatusResponseList != null && !custChallangeStatusResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends CustChallangeStatusResponse>>(custChallangeStatusResponseList,
						HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends CustChallangeStatusResponse>>(custChallangeStatusResponseList,
						HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
