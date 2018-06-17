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

import com.cpw.model.CurrencyResponse;
import com.cpw.services.CurrencyImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class CurrencyController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/currency", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends CurrencyResponse>> Currency() {
		logger.debug("Entering into Currency");
		try {
			CurrencyImpl currencyImpl = new CurrencyImpl();
			List<CurrencyResponse> currencyResponseList = currencyImpl.currencyList();
			if (currencyResponseList != null && !currencyResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends CurrencyResponse>>(currencyResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends CurrencyResponse>>(currencyResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
