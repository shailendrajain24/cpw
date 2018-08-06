package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.DealDAOImpl;
import com.cpw.jdbc.model.Deal;
import com.cpw.model.DealRequest;
import com.cpw.model.DealResponse;

public class DealImpl {
	public DealImpl() {
		// TODO Auto-generated constructor stub
	}

	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
	private final DealDAOImpl dealDao=(DealDAOImpl)context.getBean("dealDAOImpl");

	public int upsertDeal(DealRequest dealRequest)
	{
		logger.debug("Entering into upsert deal");

		return dealDao.upsert(map(dealRequest));

	}

	public int removeList(long dealId) {
		logger.debug("Entering into Remove Deal");
		return dealDao.removeList(dealId);
	}

	public List<DealResponse> dealList(long dealId) {
		logger.debug("Entering into Deal List");
		final List<Deal> dealList = dealDao.dealList(dealId);
		return map(dealList);

	}
	private List<DealResponse> map(List<Deal> dealList) {
		List<DealResponse> dealResponseList = Collections.emptyList();
		if (dealList!= null && !dealList.isEmpty()) {
			dealResponseList = new ArrayList<DealResponse>();
			for (Deal deal : dealList) {
				DealResponse trackingResponse = map(deal);
				dealResponseList.add(trackingResponse);
			}
			dealList.clear();
		}
		return dealResponseList;

	}

	private DealResponse map(Deal deal) {
		DealResponse dealResponse=new DealResponse();

		if(deal!=null)
		{
			dealResponse.setDealId(deal.getDealId());
			dealResponse.setDealOwner(deal.getDealOwner());
			dealResponse.setAmount(deal.getAmount());
			dealResponse.setDealName(deal.getDealName());
			dealResponse.setClosingDate(deal.getClosingDate());
			dealResponse.setAccountName(deal.getAccountName());
			dealResponse.setStage(deal.getStage());
			dealResponse.setType(deal.getType());
			dealResponse.setProbability(deal.getProbability());
			dealResponse.setNextStep(deal.getNextStep());
			dealResponse.setExpectedRevenue(deal.getExpectedRevenue());
			dealResponse.setLeadSource(deal.getLeadSource());
			dealResponse.setCampaignSource(deal.getCampaignSource());
			dealResponse.setContactName(deal.getContactName());
			dealResponse.setDescription(deal.getDescription());
			dealResponse.setCreatedBy(deal.getCreatedBy());
			dealResponse.setModifiedBy(deal.getModifiedBy());
			dealResponse.setCreatedTime(deal.getCreatedTime());
			dealResponse.setModifiedTime(deal.getModifiedTime());
			dealResponse.setNotes(deal.getNotes());
			dealResponse.setAttachments(deal.getAttachments());
		}
		return dealResponse;
	}

	private Deal map(DealRequest dealRequest){

		Deal deal=new Deal();

		if(dealRequest!=null)
		{
			deal.setDealId(dealRequest.getDealId());
			deal.setDealOwner(dealRequest.getDealOwner());
			deal.setAmount(dealRequest.getAmount());
			deal.setDealName(dealRequest.getDealName());
			deal.setClosingDate(dealRequest.getClosingDate());
			deal.setAccountName(dealRequest.getAccountName());
			deal.setStage(dealRequest.getStage());
			deal.setType(dealRequest.getType());
			deal.setProbability(dealRequest.getProbability());
			deal.setNextStep(dealRequest.getNextStep());
			deal.setExpectedRevenue(dealRequest.getExpectedRevenue());
			deal.setLeadSource(dealRequest.getLeadSource());
			deal.setCampaignSource(dealRequest.getCampaignSource());
			deal.setContactName(dealRequest.getContactName());
			deal.setDescription(dealRequest.getDescription());
			deal.setCreatedBy(dealRequest.getCreatedBy());
			deal.setModifiedBy(dealRequest.getModifiedBy());
			deal.setCreatedTime(dealRequest.getCreatedTime());
			deal.setModifiedTime(dealRequest.getModifiedTime());
			deal.setNotes(dealRequest.getNotes());
			deal.setAttachments(dealRequest.getAttachments());
		}
		return deal;

	}


}
