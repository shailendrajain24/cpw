/**
 * 
 */
package com.cpw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.jdbc.model.TrackHeader;
import com.cpw.model.TraceResponse;
import com.cpw.model.TrackingHeaderResponse;
import com.cpw.services.TraceImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class TraceController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/trace/{type}/{transactionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TrackHeader trace(@PathVariable(value = "type") int type,
			@PathVariable(value = "transactionId") String transactionId) {

		logger.debug("Entering into Trace");
		try {
			
				logger.debug("Transaction Id: " + transactionId + " , Tpye: " + type);
				TraceImpl traceImpl = new TraceImpl();
				List <TraceResponse> traceResponse = traceImpl.traceDetail(transactionId, type);
				TrackingHeaderResponse trackingResponse=traceImpl.headerDetail(transactionId, type);
				if (traceResponse != null && !traceResponse.isEmpty()&& trackingResponse!=null ) {
					return new TrackHeader(traceResponse,trackingResponse);
				} else {
					return new TrackHeader(traceResponse,trackingResponse);
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
