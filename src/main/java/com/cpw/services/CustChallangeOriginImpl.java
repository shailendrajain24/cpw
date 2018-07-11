package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.CustChallangeOriginDAOImpl;
import com.cpw.jdbc.model.CustChallangeOrigin;
import com.cpw.model.CustChallangeOriginResponse;

public class CustChallangeOriginImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<CustChallangeOriginResponse> custChallangeOriginList() {
		logger.debug("Entering into custChallangeOriginList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CustChallangeOriginDAOImpl custChallangeOriginDAOImpl = (CustChallangeOriginDAOImpl) context
				.getBean("custChallangeOriginDAOImpl");
		final List<CustChallangeOrigin> custChallangeOriginList = custChallangeOriginDAOImpl.custChallangeOriginList();
		return map(custChallangeOriginList);

	}

	private List<CustChallangeOriginResponse> map(List<CustChallangeOrigin> custChallangeOriginList) {
		List<CustChallangeOriginResponse> custChallangeOriginResponseList = Collections.emptyList();
		if (custChallangeOriginList != null && !custChallangeOriginList.isEmpty()) {
			custChallangeOriginResponseList = new ArrayList<CustChallangeOriginResponse>();
			for (CustChallangeOrigin custChallangeOrigin : custChallangeOriginList) {
				CustChallangeOriginResponse trackingResponse = map(custChallangeOrigin);
				custChallangeOriginResponseList.add(trackingResponse);
			}
			custChallangeOriginList.clear();
		}
		return custChallangeOriginResponseList;

	}

	private CustChallangeOriginResponse map(CustChallangeOrigin custChallangeOrigin) {
		CustChallangeOriginResponse custChallangeOriginResponse = new CustChallangeOriginResponse();
		if (custChallangeOrigin != null) {
			custChallangeOriginResponse.setOriginName(custChallangeOrigin.getOriginName());
			custChallangeOriginResponse.setOriginId(custChallangeOrigin.getOriginId());
		}
		return custChallangeOriginResponse;

	}

}
