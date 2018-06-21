package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.IndustryDAOImpl;
import com.cpw.jdbc.model.Industry;
import com.cpw.model.IndustryResponse;

public class IndustryImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<IndustryResponse> industryList() {
		logger.debug("Entering into industryList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		IndustryDAOImpl industryDAOImpl = (IndustryDAOImpl) context.getBean("industryDAOImpl");
		final List<Industry> industryList = industryDAOImpl.industryList();
		return map(industryList);

	}

	private List<IndustryResponse> map(List<Industry> industryList) {
		List<IndustryResponse> industryResponseList = Collections.emptyList();
		if (industryList != null && !industryList.isEmpty()) {
			industryResponseList = new ArrayList<IndustryResponse>();
			for (Industry industry : industryList) {
				IndustryResponse trackingResponse = map(industry);
				industryResponseList.add(trackingResponse);
			}
			industryList.clear();
		}
		return industryResponseList;

	}

	private IndustryResponse map(Industry industry) {
		IndustryResponse industryResponse = new IndustryResponse();
		if (industry != null) {
			industryResponse.setIndustryName(industry.getIndustryName());
			industryResponse.setId(industry.getId());
		}
		return industryResponse;

	}

}
