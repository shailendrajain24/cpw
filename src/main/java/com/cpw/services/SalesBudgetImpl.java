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

import com.cpw.dao.SalesBudgetDAOImpl;
import com.cpw.jdbc.model.SalesBudget;
import com.cpw.model.SalesBudgetRequest;
import com.cpw.model.SalesBudgetResponse;

public class SalesBudgetImpl {
	public SalesBudgetImpl() {
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private final SalesBudgetDAOImpl salesBudgetDAO = (SalesBudgetDAOImpl) context.getBean("salesBudgetDAOImpl");

	public int salesBudget(SalesBudgetRequest salesBudgetRequest) {
		logger.debug("Entering into salesBudget");
		
		return salesBudgetDAO.salesBudget(map(salesBudgetRequest));
	}

	private SalesBudget map(SalesBudgetRequest salesBudgetRequest) {
		SalesBudget salesBudget = new SalesBudget();

		if (salesBudgetRequest != null) {
			salesBudget.setId(salesBudgetRequest.getId());
			salesBudget.setBudgetNumber(salesBudgetRequest.getBudgetNumber());
			salesBudget.setYear(salesBudgetRequest.getYear());
			salesBudget.setBudgetType(salesBudgetRequest.getBudgetType());
			salesBudget.setSalesmanId(salesBudgetRequest.getSalesmanId());
			salesBudget.setSectorId(salesBudgetRequest.getSectorId());
			salesBudget.setCurrencyId(salesBudgetRequest.getCurrencyId());
			salesBudget.setRoe(salesBudgetRequest.getRoe());
			salesBudget.setFileName(salesBudgetRequest.getFileName());
			salesBudget.setNote(salesBudgetRequest.getNote());
			salesBudget.setLocId(salesBudgetRequest.getLocId());
			salesBudget.setFyId(salesBudgetRequest.getFyId());
			salesBudget.setFyPrdId(salesBudgetRequest.getFyPrdId());
			salesBudget.setCreatedBy(salesBudgetRequest.getCreatedBy());
			if (salesBudgetRequest.getCreatedDate() != null) {
				salesBudget
						.setCreatedDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime
								.ofInstant(salesBudgetRequest.getCreatedDate().toInstant(), ZoneId.systemDefault())));
			}
			salesBudget.setCreatedTime(salesBudgetRequest.getCreatedTime());
			salesBudget.setModifyBy(salesBudgetRequest.getModifyBy());
			if (salesBudgetRequest.getModifyDate() != null) {
				salesBudget.setModifyDate(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(LocalDateTime
						.ofInstant(salesBudgetRequest.getModifyDate().toInstant(), ZoneId.systemDefault())));
			}
			salesBudget.setModifyTime(salesBudgetRequest.getModifyTime());

		}
		return salesBudget;

	}
	
	public List<SalesBudgetResponse> salesBudgetResponseList(long id)
	{
		logger.debug("Entering into SalesBudget List");
		List<SalesBudget> salesBudgetList=salesBudgetDAO.salesBudgetList(id);
		return map(salesBudgetList);
		
	}
	
	private List<SalesBudgetResponse> map(List<SalesBudget> salesBudgetList)
	{
		List<SalesBudgetResponse> salesBudgetResponse=Collections.emptyList();
		if(salesBudgetList!=null && !salesBudgetList.isEmpty())
		{
			salesBudgetResponse=new ArrayList<SalesBudgetResponse>();
			for(SalesBudget salesBudget:salesBudgetList)
			{
				SalesBudgetResponse salesBudgetResponseList=map(salesBudget);
				salesBudgetResponse.add(salesBudgetResponseList);
			}
			salesBudgetList.clear();
		}
		return salesBudgetResponse;
		
	}
	
	private SalesBudgetResponse map(SalesBudget salesBudget)
	{
		SalesBudgetResponse salesBudgetResponse=new SalesBudgetResponse();
		
		if(salesBudget!= null)
		{
			salesBudgetResponse.setId(salesBudget.getId());
			salesBudgetResponse.setBudgetNumber(salesBudget.getBudgetNumber());
			salesBudgetResponse.setYear(salesBudget.getYear());
			salesBudgetResponse.setBudgetType(salesBudget.getBudgetType());
			salesBudgetResponse.setSalesmanId(salesBudget.getSalesmanId());
			salesBudgetResponse.setSectorId(salesBudget.getSectorId());
			salesBudgetResponse.setCurrencyId(salesBudget.getCurrencyId());
			salesBudgetResponse.setRoe(salesBudget.getRoe());
			salesBudgetResponse.setFileName(salesBudget.getFileName());
			salesBudgetResponse.setNote(salesBudget.getNote());
			salesBudgetResponse.setLocId(salesBudget.getLocId());
			salesBudgetResponse.setFyId(salesBudget.getFyId());
			salesBudgetResponse.setFyPrdId(salesBudget.getFyPrdId());
			salesBudgetResponse.setCreatedBy(salesBudget.getCreatedBy());
			salesBudgetResponse.setCreatedDate(salesBudget.getCreatedDate());
			salesBudgetResponse.setCreatedTime(salesBudget.getCreatedTime());
			salesBudgetResponse.setModifyBy(salesBudget.getModifyBy());
			salesBudgetResponse.setModifyDate(salesBudget.getModifyDate());
			salesBudgetResponse.setModifyTime(salesBudget.getModifyTime());
			
		}
		return salesBudgetResponse;
		
	}
	
	public int removeSalesBudget(long id)
	{
		logger.debug("Enter into remove list");

		return salesBudgetDAO.removeSalesBudget(id);
		
	}

}
