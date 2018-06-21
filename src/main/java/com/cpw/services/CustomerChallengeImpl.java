package com.cpw.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.CustomerChallengeDAOImpl;
import com.cpw.jdbc.model.CustomerChallenge;
import com.cpw.model.CustomerChallengeRequest;

public class CustomerChallengeImpl {
	public CustomerChallengeImpl() {
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public int customerChallenge(CustomerChallengeRequest customerChallengeRequest) {
		logger.debug("Entering into customerChallenge");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		CustomerChallengeDAOImpl customerChallengeDAO = (CustomerChallengeDAOImpl) context
				.getBean("customerChallengeDAOImpl");
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

}
