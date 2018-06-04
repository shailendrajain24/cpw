package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.PortMasterDAOImpl;
import com.cpw.jdbc.model.PortMaster;
import com.cpw.model.PortResponse;

public class PortImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<PortResponse> getAllPort() {
		logger.debug("Entering into getAllPort");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		PortMasterDAOImpl portMasterDAOImpl = (PortMasterDAOImpl) context.getBean("portMasterDAOImpl");
		final List<PortMaster> portMastersList = portMasterDAOImpl.allPortMaster();
		return map(portMastersList);

	}

	private List<PortResponse> map(List<PortMaster> portMasterList) {
		List<PortResponse> portResponseFinal = Collections.emptyList();
		if (portMasterList != null && !portMasterList.isEmpty()) {
			portResponseFinal = new ArrayList<PortResponse>();
			for (PortMaster portMaster : portMasterList) {
				PortResponse portResponse = map(portMaster);
				portResponseFinal.add(portResponse);
			}
			portMasterList.clear();
		}
		return portResponseFinal;

	}

	private PortResponse map(PortMaster portMaster) {
		PortResponse portResponse = new PortResponse();
		if (portMaster != null) {
			portResponse.setCityCode(portMaster.getCode());
			portResponse.setCityName(portMaster.getCityName());
			portResponse.setCountryName(portMaster.getCountryName());
		}
		return portResponse;

	}

}
