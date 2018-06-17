package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.CustChallangePriortyDAOImpl;
import com.cpw.jdbc.model.CustChallangePriorty;
import com.cpw.model.CustChallangePriortyResponse;

public class CustChallangePriortyImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<CustChallangePriortyResponse> custChallangePriortyList() {
		logger.debug("Entering into custChallangePriortyList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CustChallangePriortyDAOImpl custChallangePriortyDAOImpl = (CustChallangePriortyDAOImpl) context
				.getBean("custChallangePriortyDAOImpl");
		final List<CustChallangePriorty> custChallangePriortyList = custChallangePriortyDAOImpl
				.custChallangePriortyList();
		return map(custChallangePriortyList);

	}

	private List<CustChallangePriortyResponse> map(List<CustChallangePriorty> custChallangePriortyList) {
		List<CustChallangePriortyResponse> custChallangePriortyResponseList = Collections.emptyList();
		if (custChallangePriortyList != null && !custChallangePriortyList.isEmpty()) {
			custChallangePriortyResponseList = new ArrayList<CustChallangePriortyResponse>();
			for (CustChallangePriorty custChallangePriorty : custChallangePriortyList) {
				CustChallangePriortyResponse trackingResponse = map(custChallangePriorty);
				custChallangePriortyResponseList.add(trackingResponse);
			}
			custChallangePriortyList.clear();
		}
		return custChallangePriortyResponseList;

	}

	private CustChallangePriortyResponse map(CustChallangePriorty custChallangePriorty) {
		CustChallangePriortyResponse custChallangePriortyResponse = new CustChallangePriortyResponse();
		if (custChallangePriorty != null) {
			custChallangePriortyResponse.setPriortyName(custChallangePriorty.getPriortyName());
			custChallangePriortyResponse.setPriortyId(custChallangePriorty.getPriortyId());
		}
		return custChallangePriortyResponse;

	}

}
