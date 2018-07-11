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

import com.cpw.model.CustChallangeOriginResponse;
import com.cpw.services.CustChallangeOriginImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class CustChallangeOriginController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/custChallangeOrigin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends CustChallangeOriginResponse>> CustChallangeOrigin() {
		logger.debug("Entering into CustChallangeOrigin");
		try {
			CustChallangeOriginImpl custChallangeOriginImpl = new CustChallangeOriginImpl();
			List<CustChallangeOriginResponse> custChallangeOriginResponseList = custChallangeOriginImpl
					.custChallangeOriginList();
			if (custChallangeOriginResponseList != null && !custChallangeOriginResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends CustChallangeOriginResponse>>(custChallangeOriginResponseList,
						HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends CustChallangeOriginResponse>>(custChallangeOriginResponseList,
						HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
