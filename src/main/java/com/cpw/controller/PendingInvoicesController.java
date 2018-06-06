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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.PendingInvoicesResponse;
import com.cpw.services.PendingInvoiceImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class PendingInvoicesController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/pendingInvoices/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends PendingInvoicesResponse>> pendingInvoices(
			@PathVariable(value = "userId") String userId) {
		logger.debug("Entering into pendingInvoices");
		try {
			PendingInvoiceImpl pendingInvoiceImpl = new PendingInvoiceImpl();
			List<PendingInvoicesResponse> pendingInvoicesResponseList = pendingInvoiceImpl.pendingInvoiceDetail(userId);
			if (pendingInvoicesResponseList != null && !pendingInvoicesResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends PendingInvoicesResponse>>(pendingInvoicesResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends PendingInvoicesResponse>>(pendingInvoicesResponseList,
						HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
