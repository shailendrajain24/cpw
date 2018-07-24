package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.AccountTypeDAOImpl;
import com.cpw.jdbc.model.AccountType;
import com.cpw.model.AccountTypeResponse;


public class AccountTypeImpl {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<AccountTypeResponse> accountTypeList() {
		logger.debug("Entering into accountTypeList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		AccountTypeDAOImpl accountTypeDAOImpl = (AccountTypeDAOImpl) context.getBean("accountTypeDAOImpl");
		final List<AccountType> accountTypeList = accountTypeDAOImpl.accountTypeList();
		return map(accountTypeList);

	}

	private List<AccountTypeResponse> map(List<AccountType> accountTypeList) {
		List<AccountTypeResponse> accountTypeResponseList = Collections.emptyList();
		if (accountTypeList != null && !accountTypeList.isEmpty()) {
			accountTypeResponseList = new ArrayList<AccountTypeResponse>();
			for (AccountType accountType : accountTypeList) {
				AccountTypeResponse trackingResponse = map(accountType);
				accountTypeResponseList.add(trackingResponse);
			}
			accountTypeList.clear();
		}
		return accountTypeResponseList;

	}

	private AccountTypeResponse map(AccountType accountType) {
		AccountTypeResponse accountTypeResponse = new AccountTypeResponse();
		if (accountType != null) {
			accountTypeResponse.setAccTypeList(accountType.getAccTypeList());
			accountTypeResponse.setId(accountType.getId());
		}
		return accountTypeResponse;

	}

	
	

}
