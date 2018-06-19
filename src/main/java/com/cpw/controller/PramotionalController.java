/**
 * 
 */
package com.cpw.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.PramotionalRequest;
import com.cpw.services.PramotionalImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class PramotionalController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/pramotional", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> pramotional(@RequestBody PramotionalRequest request) {

		logger.debug("Entering into Pramotional");
		/*
		LocalDateTime ldt = LocalDateTime.ofInstant(request.getCreatedDate().toInstant(), ZoneId.systemDefault());
		System.out.println(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
		System.out.println(request.getCreatedDate());
		String a = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt);
		 * */
		try {
			if (request.getPrimaryId() == 0 || request.getFromEmailId().isEmpty() || request.getToEmailId().isEmpty()) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("Primary ID : " + request.getPrimaryId());
			PramotionalImpl pramotionalImpl = new PramotionalImpl();
			int response = pramotionalImpl.pramotional(request);
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
