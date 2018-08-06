package com.cpw.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.CustomerChallengeDAOImpl;
import com.cpw.jdbc.model.CustomerChallenge;
import com.cpw.model.CustomerChallengeRequest;
import com.cpw.model.CustomerChallengeResponse;

public class CustomerChallengeImpl {
	public CustomerChallengeImpl() {
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private final CustomerChallengeDAOImpl customerChallengeDAO = (CustomerChallengeDAOImpl) context
			.getBean("customerChallengeDAOImpl");


	public int customerChallenge(CustomerChallengeRequest customerChallengeRequest) {
		logger.debug("Entering into customerChallenge");
				return customerChallengeDAO.customerChallenge(map(customerChallengeRequest));
	}

	private CustomerChallenge map(CustomerChallengeRequest customerChallengeRequest) {
		CustomerChallenge customerChallenge = new CustomerChallenge();

		if (customerChallengeRequest != null) {
			customerChallenge.setCcEmail(customerChallengeRequest.getCcEmail());
			customerChallenge.setId(customerChallengeRequest.getId());
			customerChallenge.setCode(customerChallengeRequest.getCode());
			customerChallenge.setCustomerId(customerChallengeRequest.getCustomerId());
			customerChallenge.setContactId(customerChallengeRequest.getContactId());
			if (customerChallengeRequest.getLogDate() != null) {
				customerChallenge
						.setLogDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime
								.ofInstant(customerChallengeRequest.getLogDate().toInstant(), ZoneId.systemDefault())));
			}
			customerChallenge.setStatus(customerChallengeRequest.getStatus());
			customerChallenge.setPriority(customerChallengeRequest.getPriority());
			customerChallenge.setOrigin(customerChallengeRequest.getOrigin());
			customerChallenge.setTypeId(customerChallengeRequest.getTypeId());
			customerChallenge.setReason(customerChallengeRequest.getReason());
			if (customerChallengeRequest.getDueDate() != null) {
				customerChallenge
						.setDueDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime
								.ofInstant(customerChallengeRequest.getDueDate().toInstant(), ZoneId.systemDefault())));
			}
			customerChallenge.setInchargeId(customerChallengeRequest.getInchargeId());
			customerChallenge.setCcEmail(customerChallengeRequest.getCcEmail());
			customerChallenge.setSubject(customerChallengeRequest.getSubject());
			customerChallenge.setDescription(customerChallengeRequest.getDescription());
			customerChallenge.setInternalNote(customerChallengeRequest.getInternalNote());
			customerChallenge.setCustomerFeedback(customerChallengeRequest.getCustomerFeedback());
			if(customerChallengeRequest.getCloseDate()!=null){
				customerChallenge.setCloseDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.
						ofInstant(customerChallengeRequest.getCloseDate().toInstant(),ZoneId.systemDefault())));
			}
			customerChallenge.setNote(customerChallengeRequest.getNote());
			customerChallenge.setLocId(customerChallengeRequest.getLocId());
			customerChallenge.setFyId(customerChallengeRequest.getFyId());
			customerChallenge.setTime(customerChallengeRequest.getTime());
			customerChallenge.setIsDeleted(customerChallengeRequest.getIsDeleted());
			customerChallenge.setCreatedBy(customerChallengeRequest.getCreatedBy());
			if (customerChallengeRequest.getCreatedDate() != null) {
				customerChallenge.setCreatedDate(
						DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.ofInstant(
								customerChallengeRequest.getCreatedDate().toInstant(), ZoneId.systemDefault())));
			}
			customerChallenge.setCreatedTime(customerChallengeRequest.getCreatedTime());
			customerChallenge.setModifyBy(customerChallengeRequest.getModifyBy());
			if (customerChallengeRequest.getModifyDate() != null) {
				customerChallenge.setModifyDate(
						DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime.ofInstant(
								customerChallengeRequest.getModifyDate().toInstant(), ZoneId.systemDefault())));
			}
			customerChallenge.setModifyTime(customerChallengeRequest.getModifyTime());

		}
		return customerChallenge;

	}
	public List<CustomerChallengeResponse> customerChallengeList(long id)
	{
		logger.debug("Entering into customerList");
		List<CustomerChallenge> customerChallengeList=customerChallengeDAO.customerChallengeList(id);
		return map(customerChallengeList);
		
	}
	
	private List<CustomerChallengeResponse> map(List<CustomerChallenge> customerChallengeList)
	{
		List<CustomerChallengeResponse> customerChallengeResponse=Collections.emptyList();
		if(customerChallengeList!= null && !customerChallengeList.isEmpty())
		{
			customerChallengeResponse=new ArrayList<CustomerChallengeResponse>();
			for(CustomerChallenge customerChallenge: customerChallengeList)
			{
				CustomerChallengeResponse custChallengeResponseList=map(customerChallenge);
				customerChallengeResponse.add(custChallengeResponseList);
			}
			customerChallengeList.clear();
		}
		return customerChallengeResponse;
		
	}
	private CustomerChallengeResponse map(CustomerChallenge customerChallenge)
	{
		CustomerChallengeResponse customerResponse=new CustomerChallengeResponse();
		 if(customerChallenge!=null)
		 {
			customerResponse.setId(customerChallenge.getId()); 
			customerResponse.setCode(customerChallenge.getCode());
			customerResponse.setCustomerId(customerChallenge.getCustomerId());
			customerResponse.setContactId(customerChallenge.getContactId());
			customerResponse.setLogDate(customerChallenge.getLogDate());
			customerResponse.setStatus(customerChallenge.getStatus());
			customerResponse.setPriority(customerChallenge.getPriority());
			customerResponse.setOrigin(customerChallenge.getOrigin());
			customerResponse.setTypeId(customerChallenge.getTypeId());
			customerResponse.setReason(customerChallenge.getReason());
			customerResponse.setDueDate(customerChallenge.getDueDate());
			customerResponse.setInchargeId(customerChallenge.getInchargeId());
			customerResponse.setCcEmail(customerChallenge.getCcEmail());
			customerResponse.setSubject(customerChallenge.getSubject());
			customerResponse.setDescription(customerChallenge.getDescription());
			customerResponse.setInternalNote(customerChallenge.getInternalNote());
			customerResponse.setCustomerFeedback(customerChallenge.getCustomerFeedback());
			customerResponse.setCloseDate(customerChallenge.getCloseDate());
			customerResponse.setNote(customerChallenge.getNote());
			customerResponse.setLocId(customerChallenge.getLocId());
			customerResponse.setFyId(customerChallenge.getFyId());
			customerResponse.setTime(customerChallenge.getTime());
			customerResponse.setIsDeleted(customerChallenge.getIsDeleted());
			customerResponse.setCreatedBy(customerChallenge.getCreatedBy());
			customerResponse.setCreatedDate(customerChallenge.getCreatedDate());
			customerResponse.setCreatedTime(customerChallenge.getCreatedTime());
			customerResponse.setModifyBy(customerChallenge.getModifyBy());
			customerResponse.setModifyDate(customerChallenge.getModifyDate());
			customerResponse.setModifyTime(customerChallenge.getModifyTime());
		 }
		return customerResponse;
		
	}
	

}
