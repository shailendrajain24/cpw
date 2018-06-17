package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.PendingInvoiceDetailDAOImpl;
import com.cpw.jdbc.model.PendingInvoicesDetail;
import com.cpw.model.PendingInvoicesResponse;

public class PendingInvoiceImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<PendingInvoicesResponse> pendingInvoiceDetail(String userName) {
		logger.debug("Entering into trackingDetail");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		PendingInvoiceDetailDAOImpl pendingInvoiceDetailDAOImpl = (PendingInvoiceDetailDAOImpl) context
				.getBean("pendingInvoiceDetailDAOImpl");
		final List<PendingInvoicesDetail> pendingInvoicesDetails = pendingInvoiceDetailDAOImpl
				.pendingInvoiceList(userName);
		return map(pendingInvoicesDetails);

	}

	private List<PendingInvoicesResponse> map(List<PendingInvoicesDetail> pendingInvoicesList) {
		List<PendingInvoicesResponse> PendingInvoicesResponseList = Collections.emptyList();
		if (pendingInvoicesList != null && !pendingInvoicesList.isEmpty()) {
			PendingInvoicesResponseList = new ArrayList<PendingInvoicesResponse>();
			for (PendingInvoicesDetail pendingInvoicesDetail : pendingInvoicesList) {
				PendingInvoicesResponse trackingResponse = map(pendingInvoicesDetail);
				PendingInvoicesResponseList.add(trackingResponse);
			}
			pendingInvoicesList.clear();
		}
		return PendingInvoicesResponseList;

	}

	private PendingInvoicesResponse map(PendingInvoicesDetail pendingInvoicesDetail) {
		PendingInvoicesResponse pendingInvoicesResponse = new PendingInvoicesResponse();
		if (pendingInvoicesDetail != null) {
			pendingInvoicesResponse.setBookingId(pendingInvoicesDetail.getBookingId());
			pendingInvoicesResponse.setBookingNumber(pendingInvoicesDetail.getBookingNumber());
			pendingInvoicesResponse.setInvoiceNumber(pendingInvoicesDetail.getInvoiceNumber());
			pendingInvoicesResponse.setLocalAmount(pendingInvoicesDetail.getLocalAmount());
			pendingInvoicesResponse.setDueDate(pendingInvoicesDetail.getDueDate());
		}
		return pendingInvoicesResponse;

	}

}
