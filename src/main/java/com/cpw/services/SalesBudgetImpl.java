package com.cpw.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.SalesBudgetDAOImpl;
import com.cpw.jdbc.model.SalesBudget;
import com.cpw.model.SalesBudgetRequest;

public class SalesBudgetImpl {
	public SalesBudgetImpl() {
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public int salesBudget(SalesBudgetRequest salesBudgetRequest) {
		logger.debug("Entering into salesBudget");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		SalesBudgetDAOImpl salesBudgetDAO = (SalesBudgetDAOImpl) context.getBean("salesBudgetDAOImpl");
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

}
