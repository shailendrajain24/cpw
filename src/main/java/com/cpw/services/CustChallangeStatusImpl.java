package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.CustChallangeStatusDAOImpl;
import com.cpw.jdbc.model.CustChallangeStatus;
import com.cpw.model.CustChallangeStatusResponse;

public class CustChallangeStatusImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<CustChallangeStatusResponse> custChallangeStatusList() {
		logger.debug("Entering into custChallangeStatusList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CustChallangeStatusDAOImpl custChallangeStatusDAOImpl = (CustChallangeStatusDAOImpl) context
				.getBean("custChallangeStatusDAOImpl");
		final List<CustChallangeStatus> custChallangeStatusList = custChallangeStatusDAOImpl.custChallangeStatusList();
		return map(custChallangeStatusList);

	}

	private List<CustChallangeStatusResponse> map(List<CustChallangeStatus> custChallangeStatusList) {
		List<CustChallangeStatusResponse> custChallangeStatusResponseList = Collections.emptyList();
		if (custChallangeStatusList != null && !custChallangeStatusList.isEmpty()) {
			custChallangeStatusResponseList = new ArrayList<CustChallangeStatusResponse>();
			for (CustChallangeStatus custChallangeStatus : custChallangeStatusList) {
				CustChallangeStatusResponse trackingResponse = map(custChallangeStatus);
				custChallangeStatusResponseList.add(trackingResponse);
			}
			custChallangeStatusList.clear();
		}
		return custChallangeStatusResponseList;

	}

	private CustChallangeStatusResponse map(CustChallangeStatus custChallangeStatus) {
		CustChallangeStatusResponse custChallangeStatusResponse = new CustChallangeStatusResponse();
		if (custChallangeStatus != null) {
			custChallangeStatusResponse.setStatusName(custChallangeStatus.getStatusName());
			custChallangeStatusResponse.setStatusId(custChallangeStatus.getStatusId());
		}
		return custChallangeStatusResponse;

	}

}
