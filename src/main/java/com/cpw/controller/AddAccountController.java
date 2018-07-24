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
import com.cpw.model.AddAccountRequest;
import com.cpw.model.AddAccountResponse;
import com.cpw.services.AddAccountImpl;


@RestController
public class AddAccountController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/accounts/{createdBy}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends AddAccountResponse>> accounts(@PathVariable("createdBy") long createdBy) {
		logger.debug("Entering into Account list");
		try {
			AddAccountImpl accountImpl = new AddAccountImpl();
			List<AddAccountResponse> addAccountResponse = accountImpl.accountList(createdBy);
			if (addAccountResponse != null && !addAccountResponse.isEmpty()) {
				return new ResponseEntity<List<? extends AddAccountResponse>>(addAccountResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends AddAccountResponse>>(addAccountResponse, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/removeAccount/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeAccount(@PathVariable("id") long id) {
		logger.debug("Entering into removeAccount");
		try {
			AddAccountImpl accountImpl = new AddAccountImpl();
			int response = accountImpl.removeAccount(id);
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

	@RequestMapping(value = "/addAccount", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> upsertAccount(@RequestBody AddAccountRequest request) {

		logger.debug("Entering into addAccount");
		try {
			if (request.getAccountName().isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("Accountname : " + request.getAccountName());
			AddAccountImpl accountImpl = new AddAccountImpl();
			int response = accountImpl.upsertAccount(request);
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
