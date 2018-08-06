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

import com.cpw.model.LeadFieldResponse;
import com.cpw.services.LeadFieldImpl;


@RestController
public class LeadFieldController {
	
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping
	(value = "/lead/leadField", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends LeadFieldResponse>> Tracking() {
		logger.debug("Entering into leadField");
		try {
			LeadFieldImpl leadFieldImpl = new LeadFieldImpl();
			List<LeadFieldResponse> leadFieldResponseList = leadFieldImpl.leadFieldList();
			if (leadFieldResponseList != null && !leadFieldResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends LeadFieldResponse>>(leadFieldResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends LeadFieldResponse>>(leadFieldResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	}


