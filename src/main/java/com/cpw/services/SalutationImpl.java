package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.SalutationDAOImpl;
import com.cpw.jdbc.model.Salutation;
import com.cpw.model.SalutationResponse;

public class SalutationImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<SalutationResponse> salutationList() {
		logger.debug("Entering into salutationList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		SalutationDAOImpl salutationDAOImpl = (SalutationDAOImpl) context.getBean("salutationDAOImpl");
		final List<Salutation> salutationList = salutationDAOImpl.salutationList();
		return map(salutationList);

	}

	private List<SalutationResponse> map(List<Salutation> salutationList) {
		List<SalutationResponse> salutationResponseList = Collections.emptyList();
		if (salutationList != null && !salutationList.isEmpty()) {
			salutationResponseList = new ArrayList<SalutationResponse>();
			for (Salutation salutation : salutationList) {
				SalutationResponse trackingResponse = map(salutation);
				salutationResponseList.add(trackingResponse);
			}
			salutationList.clear();
		}
		return salutationResponseList;

	}

	private SalutationResponse map(Salutation salutation) {
		SalutationResponse salutationResponse = new SalutationResponse();
		if (salutation != null) {
			salutationResponse.setSalutationName(salutation.getSalutationName());
			salutationResponse.setId(salutation.getId());
		}
		return salutationResponse;

	}

}
