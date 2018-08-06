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
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.AccountTypeResponse;
import com.cpw.services.AccountTypeImpl;

@RestController
public class AccountTypeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/account/AccountType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends AccountTypeResponse>> Tracking() {
		logger.debug("Entering into accountType");
		try {
			AccountTypeImpl accountTypeImpl = new AccountTypeImpl();
			List<AccountTypeResponse> accountTypeResponseList = accountTypeImpl.accountTypeList();
			if (accountTypeResponseList == null || accountTypeResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends AccountTypeResponse>>(accountTypeResponseList,
						HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<? extends AccountTypeResponse>>(accountTypeResponseList, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<? extends AccountTypeResponse>>(Collections.emptyList(),
					HttpStatus.NOT_FOUND);
		}
	}

}
