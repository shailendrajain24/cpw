package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.ScheduleSearchDAOImpl;
import com.cpw.jdbc.model.ScheduleSearch;
import com.cpw.model.ScheduleSearchRequest;
import com.cpw.model.ScheduleSearchResponse;

public class SailingScheduleSearchImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<ScheduleSearchResponse> sailingSearchSchedule(ScheduleSearchRequest scheduleSearchRequest) {
		logger.debug("Entering into sailingSearchSchedule");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		ScheduleSearchDAOImpl scheduleSearchDAOImpl = (ScheduleSearchDAOImpl) context.getBean("scheduleSearchDAOImpl");
		final List<ScheduleSearch> scheduleSearchList = scheduleSearchDAOImpl.searchScheduleList(scheduleSearchRequest);
		return map(scheduleSearchList);

	}

	private List<ScheduleSearchResponse> map(List<ScheduleSearch> scheduleSearchList) {
		List<ScheduleSearchResponse> scheduleSearchResponseList = Collections.emptyList();
		if (scheduleSearchList != null && !scheduleSearchList.isEmpty()) {
			scheduleSearchResponseList = new ArrayList<ScheduleSearchResponse>();
			for (ScheduleSearch scheduleSearch : scheduleSearchList) {
				ScheduleSearchResponse scheduleSearchResponse = map(scheduleSearch);
				scheduleSearchResponseList.add(scheduleSearchResponse);
			}
			scheduleSearchList.clear();
		}
		return scheduleSearchResponseList;

	}

	private ScheduleSearchResponse map(ScheduleSearch scheduleSearch) {
		ScheduleSearchResponse scheduleSearchResponse = new ScheduleSearchResponse();
		if (scheduleSearch != null) {
			scheduleSearchResponse.setVesselName(scheduleSearch.getVesselName());
			scheduleSearchResponse.setEta(String.valueOf(scheduleSearch.geteta()));
			scheduleSearchResponse.setEtd(String.valueOf(scheduleSearch.getEtd()));
			scheduleSearchResponse.setPodCode(scheduleSearch.getPodCode());
			scheduleSearchResponse.setPolCode(scheduleSearch.getPolCode());
		}
		return scheduleSearchResponse;

	}

}
