package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.SectorDAOImpl;
import com.cpw.jdbc.model.Sector;
import com.cpw.model.SectorResponse;

public class SectorImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<SectorResponse> sectorList() {
		logger.debug("Entering into sectorList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		SectorDAOImpl sectorDAOImpl = (SectorDAOImpl) context.getBean("sectorDAOImpl");
		final List<Sector> sectorList = sectorDAOImpl.sectorList();
		return map(sectorList);

	}

	private List<SectorResponse> map(List<Sector> sectorList) {
		List<SectorResponse> sectorResponseList = Collections.emptyList();
		if (sectorList != null && !sectorList.isEmpty()) {
			sectorResponseList = new ArrayList<SectorResponse>();
			for (Sector sector : sectorList) {
				SectorResponse trackingResponse = map(sector);
				sectorResponseList.add(trackingResponse);
			}
			sectorList.clear();
		}
		return sectorResponseList;

	}

	private SectorResponse map(Sector sector) {
		SectorResponse sectorResponse = new SectorResponse();
		if (sector != null) {
			sectorResponse.setSectorName(sector.getSectorName());
			sectorResponse.setSectorId(sector.getSectorId());
		}
		return sectorResponse;

	}

}
