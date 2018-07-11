package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.PortMasterDAOImpl;
import com.cpw.jdbc.model.PortMaster;
import com.cpw.model.PortDataResponse;
import com.cpw.model.PortResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PortImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public String getAllPort() {
		logger.debug("Entering into getAllPort");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		PortMasterDAOImpl portMasterDAOImpl = (PortMasterDAOImpl) context.getBean("portMasterDAOImpl");
		final List<PortMaster> portMastersList = portMasterDAOImpl.allPortMaster();
		try {
			return mapJson(portMastersList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;

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
			portResponse.setPortId(portMaster.getPortId());
		}
		return portResponse;

	}

	private String mapJson(List<PortMaster> portMastersList) throws JsonProcessingException {
		List<PortResponse> portResponse = map(portMastersList);
		// List<PortResponse2> p2 = new ArrayList<PortResponse2>();
		Map<String, List<PortDataResponse>> map = portResponse.stream()
				.collect(Collectors.groupingBy(PortResponse::getCountryName, Collectors.mapping(a -> {
					PortDataResponse portDataResponse = new PortDataResponse();
					portDataResponse.setCityCode(a.getCityCode());
					portDataResponse.setCityName(a.getCityName());
					portDataResponse.setPortId(a.getPortId());
					return portDataResponse;
				}, Collectors.toList())));
		logger.debug("Size of the Map : " + map.size());
		return new ObjectMapper().writeValueAsString(map);
	}
}
