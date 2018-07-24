package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.LeadDAOImpl;
import com.cpw.jdbc.model.Lead;
import com.cpw.model.LeadData;
import com.cpw.model.LeadDataResponse;

public class LeadImpl {
	public LeadImpl() {
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private final LeadDAOImpl leadDAO = (LeadDAOImpl) context.getBean("leadDAOImpl");

	public int upsertLead(LeadData leadRequest) {
		logger.debug("Entering into upsert Lead");
		return leadDAO.upsertLead(map(leadRequest));
	}

	public int removeLead(long leadId) {
		logger.debug("Entering into Remove Lead");
		return leadDAO.removeLead(leadId);
	}

	public List<LeadDataResponse> leadList(long createdBy) {
		logger.debug("Entering into lead List");
		final List<Lead> leadList = leadDAO.leadList(createdBy);
		return map(leadList);

	}

	private List<LeadDataResponse> map(List<Lead> leadList) {
		List<LeadDataResponse> leadResponseList = Collections.emptyList();
		if (leadList != null && !leadList.isEmpty()) {
			leadResponseList = new ArrayList<LeadDataResponse>();
			for (Lead lead : leadList) {
				LeadDataResponse trackingResponse = map(lead);
				leadResponseList.add(trackingResponse);
			}
			leadList.clear();
		}
		return leadResponseList;

	}

	private LeadDataResponse map(Lead lead) {
		LeadDataResponse leadData = new LeadDataResponse();
		if (lead != null) {
			leadData.setAddressCity(lead.getAddressCity());
			leadData.setAddressCounty(lead.getAddressCounty());
			leadData.setAddressState(lead.getAddressState());
			leadData.setAddressStreet(lead.getAddressStreet());
			leadData.setAddressZipCode(lead.getAddressZipCode());
			leadData.setAnnualRevenue(lead.getAnnualRevenue());
			leadData.setCompany(lead.getCompany());
			leadData.setDescription(lead.getDescription());
			leadData.setEmail(lead.getEmail());
			leadData.setEmailOptOut(lead.isEmailOptOut());
			leadData.setFax(lead.getFax());
			leadData.setFirstName(lead.getFirstName());
			leadData.setLastName(lead.getLastName());
			leadData.setLeadId(lead.getLeadId());
			leadData.setLeadOwner(lead.getLeadOwner());
			leadData.setLeadSource(lead.getLeadSource());
			leadData.setLeadStatus(lead.getLeadStatus());
			leadData.setMobile(lead.getMobile());
			leadData.setNoOfEmployees(lead.getNoOfEmployees());
			leadData.setPhone(lead.getPhone());
			leadData.setRating(lead.getRating());
			leadData.setSkypeId(lead.getSkypeId());
			leadData.setTitle(lead.getTitle());
			// leadData.setUploadedInputStream(lead.getUploadedInputStream());
			leadData.setWebsite(lead.getWebsite());
			if (lead.getCreateDate() != null)
				leadData.setCreatedDate(lead.getCreateDate());
			if (lead.getModifyDate() != null)
				leadData.setModifyDate(lead.getModifyDate());
			leadData.setCreatedBy(lead.getCreatedBy());
		}
		return leadData;

	}

	private Lead map(LeadData leadRequest) {
		Lead lead = new Lead();
		if (leadRequest != null) {
			lead.setAddressCity(leadRequest.getAddressCity());
			lead.setAddressCounty(leadRequest.getAddressCounty());
			lead.setAddressState(leadRequest.getAddressState());
			lead.setAddressStreet(leadRequest.getAddressStreet());
			lead.setAddressZipCode(leadRequest.getAddressZipCode());
			lead.setAnnualRevenue(leadRequest.getAnnualRevenue());
			lead.setCompany(leadRequest.getCompany());
			lead.setDescription(leadRequest.getDescription());
			lead.setEmail(leadRequest.getEmail());
			lead.setEmailOptOut(leadRequest.isEmailOptOut());
			lead.setFax(leadRequest.getFax());
			lead.setFirstName(leadRequest.getFirstName());
			lead.setLastName(leadRequest.getLastName());
			lead.setLeadId(leadRequest.getLeadId());
			lead.setLeadOwner(leadRequest.getLeadOwner());
			lead.setLeadSource(leadRequest.getLeadSource());
			lead.setLeadStatus(leadRequest.getLeadStatus());
			lead.setMobile(leadRequest.getMobile());
			lead.setNoOfEmployees(leadRequest.getNoOfEmployees());
			lead.setPhone(leadRequest.getPhone());
			lead.setRating(leadRequest.getRating());
			lead.setSkypeId(leadRequest.getSkypeId());
			lead.setTitle(leadRequest.getTitle());
			// lead.setUploadedInputStream(leadRequest.getUploadedInputStream());
			lead.setWebsite(leadRequest.getWebsite());
				/*
				 * lead.setCreateDate(DateTimeFormatter.ofPattern("yyyy-MM-dd",
				 * Locale.ENGLISH).format(LocalDateTime
				 * .ofInstant(leadRequest.getCreatedDate().toInstant(),
				 * ZoneId.systemDefault())));
				 * System.out.println("Date:   -   "+lead.getCreateDate());
				 * if(leadRequest.getModifyDate()!=null)
				 * lead.setModifyDate(DateTimeFormatter.ofPattern("yyyy-MM-dd",
				 * Locale.ENGLISH).format(LocalDateTime
				 * .ofInstant(leadRequest.getModifyDate().toInstant(),
				 * ZoneId.systemDefault())));
				 */
			lead.setCreateDate(leadRequest.getCreatedDate());
			lead.setModifyDate(leadRequest.getModifyDate());
			lead.setCreatedBy(leadRequest.getCreatedBy());

		}
		return lead;

	}
}
