package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.VesselDAOImpl;
import com.cpw.jdbc.model.Vessel;
import com.cpw.model.VesselResponse;

public class VesselImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<VesselResponse> vesselList() {
		logger.debug("Entering into vesselList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		VesselDAOImpl vesselDAOImpl = (VesselDAOImpl) context.getBean("vesselDAOImpl");
		final List<Vessel> vesselList = vesselDAOImpl.vesselList();
		return map(vesselList);

	}

	private List<VesselResponse> map(List<Vessel> vesselList) {
		List<VesselResponse> vesselResponseList = Collections.emptyList();
		if (vesselList != null && !vesselList.isEmpty()) {
			vesselResponseList = new ArrayList<VesselResponse>();
			for (Vessel vessel : vesselList) {
				VesselResponse trackingResponse = map(vessel);
				vesselResponseList.add(trackingResponse);
			}
			vesselList.clear();
		}
		return vesselResponseList;

	}

	private VesselResponse map(Vessel vessel) {
		VesselResponse vesselResponse = new VesselResponse();
		if (vessel != null) {
			vesselResponse.setVesselName(vessel.getVesselName());
			vesselResponse.setVesselId(vessel.getVesselId());
		}
		return vesselResponse;

	}

}
