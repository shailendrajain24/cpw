package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.LeadStatusDAOImpl;
import com.cpw.jdbc.model.LeadStatus;
import com.cpw.model.LeadStatusResponse;

public class LeadStatusImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<LeadStatusResponse> leadStatusList() {
		logger.debug("Entering into leadStatusList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		LeadStatusDAOImpl leadStatusDAOImpl = (LeadStatusDAOImpl) context.getBean("leadStatusDAOImpl");
		final List<LeadStatus> leadStatusList = leadStatusDAOImpl.leadStatusList();
		return map(leadStatusList);

	}

	private List<LeadStatusResponse> map(List<LeadStatus> leadStatusList) {
		List<LeadStatusResponse> leadStatusResponseList = Collections.emptyList();
		if (leadStatusList != null && !leadStatusList.isEmpty()) {
			leadStatusResponseList = new ArrayList<LeadStatusResponse>();
			for (LeadStatus leadStatus : leadStatusList) {
				LeadStatusResponse trackingResponse = map(leadStatus);
				leadStatusResponseList.add(trackingResponse);
			}
			leadStatusList.clear();
		}
		return leadStatusResponseList;

	}

	private LeadStatusResponse map(LeadStatus leadStatus) {
		LeadStatusResponse leadStatusResponse = new LeadStatusResponse();
		if (leadStatus != null) {
			leadStatusResponse.setStatusName(leadStatus.getStatusName());
			leadStatusResponse.setId(leadStatus.getId());
		}
		return leadStatusResponse;

	}

}
