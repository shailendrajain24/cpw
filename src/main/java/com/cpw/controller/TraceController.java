/**
 * 
 */
package com.cpw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.TraceResponse;
import com.cpw.services.TraceImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class TraceController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/trace/{type}/{transactionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TraceResponse> authenticateUser(@PathVariable(value = "type") int type,
			@PathVariable(value = "transactionId") String transactionId) {

		logger.debug("Entering into Trace");
		try {
			if (type == 0 || transactionId.isEmpty()) {
				return new ResponseEntity<TraceResponse>(HttpStatus.NOT_FOUND);
			} else {
				logger.debug("Transaction Id: " + transactionId + " , Tpye: " + type);
				TraceImpl traceImpl = new TraceImpl();
				TraceResponse traceResponse = traceImpl.traceDetail(transactionId, type);
				if (traceResponse != null) {
					return new ResponseEntity<TraceResponse>(traceResponse, HttpStatus.OK);
				} else {
					return new ResponseEntity<TraceResponse>(traceResponse, HttpStatus.NOT_FOUND);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
