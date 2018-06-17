package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.CurrencyDAOImpl;
import com.cpw.jdbc.model.Currency;
import com.cpw.model.CurrencyResponse;

public class CurrencyImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<CurrencyResponse> currencyList() {
		logger.debug("Entering into currencyList");
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		CurrencyDAOImpl currencyDAOImpl = (CurrencyDAOImpl) context.getBean("currencyDAOImpl");
		final List<Currency> currencyList = currencyDAOImpl.currencyList();
		return map(currencyList);

	}

	private List<CurrencyResponse> map(List<Currency> currencyList) {
		List<CurrencyResponse> currencyResponseList = Collections.emptyList();
		if (currencyList != null && !currencyList.isEmpty()) {
			currencyResponseList = new ArrayList<CurrencyResponse>();
			for (Currency currency : currencyList) {
				CurrencyResponse trackingResponse = map(currency);
				currencyResponseList.add(trackingResponse);
			}
			currencyList.clear();
		}
		return currencyResponseList;

	}

	private CurrencyResponse map(Currency currency) {
		CurrencyResponse currencyResponse = new CurrencyResponse();
		if (currency != null) {
			currencyResponse.setCurrencyCode(currency.getCurrencyCode());
			currencyResponse.setCurrencyId(currency.getCurrencyId());
		}
		return currencyResponse;

	}

}
