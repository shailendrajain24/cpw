package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.TrackingDetailDAOImpl;
import com.cpw.jdbc.model.TrackingDetail;
import com.cpw.model.TrackingResponse;

public class TrackingImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<TrackingResponse> trackingDetail() {
		logger.debug("Entering into trackingDetail");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		TrackingDetailDAOImpl trackingDetailDAOImpl = (TrackingDetailDAOImpl) context.getBean("trackingDetailDAOImpl");
		final List<TrackingDetail> trackingDetailList = trackingDetailDAOImpl.trackingDetail();
		return map(trackingDetailList);

	}

	private List<TrackingResponse> map(List<TrackingDetail> trackingDetailList) {
		List<TrackingResponse> trackingResponseList = Collections.emptyList();
		if (trackingDetailList != null && !trackingDetailList.isEmpty()) {
			trackingResponseList = new ArrayList<TrackingResponse>();
			for (TrackingDetail trackingDetail : trackingDetailList) {
				TrackingResponse trackingResponse = map(trackingDetail);
				trackingResponseList.add(trackingResponse);
			}
			trackingDetailList.clear();
		}
		return trackingResponseList;

	}

	private TrackingResponse map(TrackingDetail trackingDetail) {
		TrackingResponse trackingResponse = new TrackingResponse();
		if (trackingDetail != null) {
			trackingResponse.setTrackType(trackingDetail.getTrackType());
			trackingResponse.setMaxLength(trackingDetail.getMaxLength());
			trackingResponse.setMinLength(trackingDetail.getMinLength());
			trackingResponse.setType(trackingDetail.getType());
			trackingResponse.setStartWith(trackingDetail.getStartWith());
			trackingResponse.setStartWithLength(trackingDetail.getStartWithLength());
			trackingResponse.setTrackingId(trackingDetail.getTrackingId());
		}
		return trackingResponse;

	}

}
