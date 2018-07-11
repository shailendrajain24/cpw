package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cpw.dao.LeadFieldDAOImpl;
import com.cpw.jdbc.model.LeadField;

import com.cpw.model.LeadFieldResponse;


public class LeadFieldImpl {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<LeadFieldResponse> leadFieldList() {
		logger.debug("Entering into leadFieldList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		LeadFieldDAOImpl leadFieldDAOImpl = (LeadFieldDAOImpl) context.getBean("leadFieldDAOImpl");
		final List<LeadField> leadFieldList = leadFieldDAOImpl.leadFieldList();
		return map(leadFieldList);

	}

	private List<LeadFieldResponse> map(List<LeadField> leadFieldList) {
		List<LeadFieldResponse> leadFieldResponseList = Collections.emptyList();
		if (leadFieldList != null && !leadFieldList.isEmpty()) {
			leadFieldResponseList = new ArrayList<LeadFieldResponse>();
			for (LeadField leadField : leadFieldList) {
				LeadFieldResponse trackingResponse = map(leadField);
				leadFieldResponseList.add(trackingResponse);
			}
			leadFieldList.clear();
		}
		return leadFieldResponseList;

	}

	private LeadFieldResponse map(LeadField leadField) {
		LeadFieldResponse leadFieldResponse = new LeadFieldResponse();
		if (leadField != null) {
			leadFieldResponse.setFieldName(leadField.getFieldName());
			leadFieldResponse.setId(leadField.getId());
		}
		return leadFieldResponse;

	}

	
	

}
