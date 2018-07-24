package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.TraceDAOImpl;
import com.cpw.jdbc.model.Trace;
import com.cpw.model.TraceResponse;

public class TraceImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<TraceResponse> traceDetail(String transactionId, int type) {
		logger.debug("Entering into traceDetail");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		TraceDAOImpl traceDAOImpl = (TraceDAOImpl) context.getBean("traceDAOImpl");
		final List <Trace> trace = traceDAOImpl.traceDetail(transactionId, type);
		return map(trace);
	}

	private List<TraceResponse> map(List<Trace> traceList) {
		List<TraceResponse> traceResponseList = Collections.emptyList();
		if (traceList != null && !traceList.isEmpty()) {
			traceResponseList = new ArrayList<TraceResponse>();
			for (Trace traceDetail : traceList) {
				TraceResponse trackingResponse = map(traceDetail);
				traceResponseList.add(trackingResponse);
			}
			traceList.clear();
		}
		return traceResponseList;

	}
	private TraceResponse map(Trace trace) {
		TraceResponse traceResponse = new TraceResponse();
		if (trace != null) {
			traceResponse.setBookingDate(trace.getBookingDate());
			traceResponse.setCustomerClearanceDate(trace.getCustomerClearanceDate());
			traceResponse.setJobId(trace.getJobId());
			traceResponse.setSobDate(trace.getSobDate());
			traceResponse.setContainerNumber(trace.getContainerNumber());
			traceResponse.setVolume(trace.getVolume());
			traceResponse.setCreateDate(trace.getCreateDate());
			traceResponse.setBookingNumber(trace.getBookingNumber());
			traceResponse.setGrWt(trace.getGrWt());
			traceResponse.setShippingBillNumber(trace.getShippingBillNumber());
			traceResponse.setCartingDate(trace.getCartingDate());
		}
		return traceResponse;

	}

}
