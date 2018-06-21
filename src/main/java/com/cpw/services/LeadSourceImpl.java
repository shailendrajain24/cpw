package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.LeadSourceDAOImpl;
import com.cpw.jdbc.model.LeadSource;
import com.cpw.model.LeadSourceResponse;

public class LeadSourceImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<LeadSourceResponse> leadSourceList() {
		logger.debug("Entering into leadSourceList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		LeadSourceDAOImpl leadSourceDAOImpl = (LeadSourceDAOImpl) context.getBean("leadSourceDAOImpl");
		final List<LeadSource> leadSourceList = leadSourceDAOImpl.leadSourceList();
		return map(leadSourceList);

	}

	private List<LeadSourceResponse> map(List<LeadSource> leadSourceList) {
		List<LeadSourceResponse> leadSourceResponseList = Collections.emptyList();
		if (leadSourceList != null && !leadSourceList.isEmpty()) {
			leadSourceResponseList = new ArrayList<LeadSourceResponse>();
			for (LeadSource leadSource : leadSourceList) {
				LeadSourceResponse trackingResponse = map(leadSource);
				leadSourceResponseList.add(trackingResponse);
			}
			leadSourceList.clear();
		}
		return leadSourceResponseList;

	}

	private LeadSourceResponse map(LeadSource leadSource) {
		LeadSourceResponse leadSourceResponse = new LeadSourceResponse();
		if (leadSource != null) {
			leadSourceResponse.setSourceName(leadSource.getSourceName());
			leadSourceResponse.setId(leadSource.getId());
		}
		return leadSourceResponse;

	}

}
