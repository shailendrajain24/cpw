package com.cpw.services;

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

	public TraceResponse traceDetail(String transactionId, int type) {
		logger.debug("Entering into traceDetail");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		TraceDAOImpl traceDAOImpl = (TraceDAOImpl) context.getBean("traceDAOImpl");
		final Trace trace = traceDAOImpl.traceDetail(transactionId, type);
		return map(trace);
	}

	private TraceResponse map(Trace trace) {
		TraceResponse traceResponse = new TraceResponse();
		if (trace != null) {
			traceResponse.setBookingId(trace.getBookingId());
			traceResponse.setCartingDate(trace.getCartingDate());
			traceResponse.setCfsFdcCode(trace.getCfsFdcCode());
			traceResponse.setCfsPodCode(trace.getCfsPodCode());
			traceResponse.setCfsPolCode(trace.getCfsPolCode());
			traceResponse.setCfsReceivedId(trace.getCfsReceivedId());
			traceResponse.setCustomerClearanceDate(trace.getCustomerClearanceDate());
		}
		return traceResponse;

	}

}
