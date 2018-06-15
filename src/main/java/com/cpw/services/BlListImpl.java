package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.BlListDAOImpl;
import com.cpw.jdbc.model.BlList;
import com.cpw.model.BlListResponse;

public class BlListImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<BlListResponse> getBlList(String userType, int userId) {
		logger.debug("Entering into vesselList");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		BlListDAOImpl blListDAOImpl = (BlListDAOImpl) context.getBean("blListDAOImpl");
		final List<BlList> blList = blListDAOImpl.getBlList(userType, userId);
		return map(blList);

	}

	private List<BlListResponse> map(List<BlList> blList) {
		List<BlListResponse> blResponseList = Collections.emptyList();
		if (blList != null && !blList.isEmpty()) {
			blResponseList = new ArrayList<BlListResponse>();
			for (BlList vessel : blList) {
				BlListResponse blResponse = map(vessel);
				blResponseList.add(blResponse);
			}
			blList.clear();
		}
		return blResponseList;

	}

	private BlListResponse map(BlList bl) {
		BlListResponse blResponseList = new BlListResponse();
		if (bl != null) {
			blResponseList.setBookingDate(String.valueOf(bl.getBookingDate()));
			blResponseList.setBookingNumber(bl.getBookingNumber());
			blResponseList.setEta(String.valueOf(bl.getEta()));
			blResponseList.setEtd(String.valueOf(bl.getEtd()));
		}
		return blResponseList;

	}

}
