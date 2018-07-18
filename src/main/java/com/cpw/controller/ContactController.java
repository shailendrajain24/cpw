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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.ContactData;
import com.cpw.model.ContactDataResponse;


import com.cpw.services.ContactImpl;


/**
 * @author Unknown
 *
 */
@RestController
public class ContactController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/contact/{createdBy}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends ContactDataResponse>> contacts(@PathVariable("createdBy") String createdBy) {
		logger.debug("Entering into contact list");
		try {
			ContactImpl contactImpl = new ContactImpl();
			List<ContactDataResponse> contactDateResponse = contactImpl.contactList(createdBy);
			if (contactDateResponse != null && !contactDateResponse.isEmpty()) {
				return new ResponseEntity<List<? extends ContactDataResponse>>(contactDateResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends ContactDataResponse>>(contactDateResponse, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/removeContact/{contactId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeContact(@PathVariable("contactId") long contactId) {
		logger.debug("Entering into removeContact");
		try {
			ContactImpl contactImpl = new ContactImpl();
			int response = contactImpl.removeContact(contactId);
			if (response>0) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> upsertContact(@RequestBody ContactData request) {

		logger.debug("Entering into addContact");
		try {
			if (request.getFirstName().isEmpty() || request.getLastName().isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("FirstName : " + request.getFirstName());
			ContactImpl contactImpl = new ContactImpl();
			int response = contactImpl.upsertContact(request);
			if (response>0) {
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
