package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cpw.dao.AddAccountDAOImpl;
import com.cpw.jdbc.model.AddAccount;
import com.cpw.model.AddAccountRequest;
import com.cpw.model.AddAccountResponse;


public class AddAccountImpl {
	public AddAccountImpl() {
		// TODO Auto-generated constructor stub
	}

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private final AddAccountDAOImpl addAccountDAO = (AddAccountDAOImpl) context.getBean("addAccountDAOImpl");

	public int upsertAccount(AddAccountRequest addAccountRequest) {
		logger.debug("Entering into upsert Account");
		return addAccountDAO.upsertAccount(map(addAccountRequest));
	}

	public int removeAccount(long id) {
		logger.debug("Entering into Remove Account");
		return addAccountDAO.removeAccount(id);
	}

	public List<AddAccountResponse> accountList(String createdBy) {
		logger.debug("Entering into Account List");
		final List<AddAccount> AccountList = addAccountDAO.accountList(createdBy);
		return map(AccountList);

	}

	private List<AddAccountResponse> map(List<AddAccount> accountList) {
		List<AddAccountResponse> addAccountResponseList = Collections.emptyList();
		if (accountList != null && !accountList.isEmpty()) {
			addAccountResponseList = new ArrayList<AddAccountResponse>();
			for (AddAccount addAccount : accountList) {
				AddAccountResponse trackingResponse = map(addAccount);
				addAccountResponseList.add(trackingResponse);
			}
			accountList.clear();
		}
		return addAccountResponseList;

	}

	private AddAccountResponse map(AddAccount addAccount) {
		AddAccountResponse accountResponse = new AddAccountResponse();
		if (addAccount != null) {
			accountResponse.setId(addAccount.getId());
			accountResponse.setAccountOwner(addAccount.getAccountOwner());
			accountResponse.setRating(addAccount.getRating());
			accountResponse.setAccountName(addAccount.getAccountName());
			accountResponse.setPhone(addAccount.getPhone());
			accountResponse.setAccountSite(addAccount.getAccountSite());
			accountResponse.setFax(addAccount.getFax());
			accountResponse.setParentAccount(addAccount.getParentAccount());
			accountResponse.setWebSite(addAccount.getWebSite());
			accountResponse.setAccountNumber(addAccount.getAccountNumber());
			accountResponse.setTickerSymbol(addAccount.getTickerSymbol());
			accountResponse.setAccountType(addAccount.getAccountType());
			accountResponse.setOwnerShip(addAccount.getOwnerShip());
			accountResponse.setIndustry(addAccount.getIndustry());
			accountResponse.setEmployees(addAccount.getEmployees());
			accountResponse.setAnnualRevenue(addAccount.getAnnualRevenue());
			accountResponse.setSicCode(addAccount.getSicCode());
			accountResponse.setBillingAddressStreet(addAccount.getBillingAddressStreet());
			accountResponse.setBillingAddressCity(addAccount.getBillingAddressCity());
			accountResponse.setBillingAddressState(addAccount.getBillingAddressState());
			accountResponse.setBillingAddressCode(addAccount.getBillingAddressCode());
			accountResponse.setBillingAddressCountry(addAccount.getBillingAddressCountry());
			accountResponse.setShippingAddressStreet(addAccount.getShippingAddressStreet());
			accountResponse.setShippingAddressCity(addAccount.getShippingAddressCity());
			accountResponse.setShippingAddressState(addAccount.getShippingAddressState());
			accountResponse.setShippingAddressCode(addAccount.getShippingAddressCode());
			accountResponse.setShippingAddressCountry(addAccount.getShippingAddressCountry());
			accountResponse.setDescription(addAccount.getDescription());
			accountResponse.setCreatedBy(addAccount.getCreatedBy());
			accountResponse.setCreatedTime(addAccount.getCreatedTime());
			accountResponse.setModifyBy(addAccount.getModifyBy());
			accountResponse.setModifyTime(addAccount.getModifyTime());
			accountResponse.setParentAccountId(addAccount.getParentAccountId());



		}
		return accountResponse;

	}

	private AddAccount map(AddAccountRequest addAccountRequest) {
		AddAccount addAccount = new AddAccount();
		if (addAccountRequest != null) {
			addAccount.setId(addAccountRequest.getId());
			addAccount.setAccountOwner(addAccountRequest.getAccountOwner());
			addAccount.setRating(addAccountRequest.getRating());
			addAccount.setAccountName(addAccountRequest.getAccountName());
			addAccount.setPhone(addAccountRequest.getPhone());
			addAccount.setAccountSite(addAccountRequest.getAccountSite());
			addAccount.setFax(addAccountRequest.getFax());
			addAccount.setParentAccount(addAccountRequest.getParentAccount());
			addAccount.setWebSite(addAccountRequest.getWebSite());
			addAccount.setAccountNumber(addAccountRequest.getAccountNumber());
			addAccount.setTickerSymbol(addAccountRequest.getTickerSymbol());
			addAccount.setAccountType(addAccountRequest.getAccountType());
			addAccount.setOwnerShip(addAccountRequest.getOwnerShip());
			addAccount.setIndustry(addAccountRequest.getIndustry());
			addAccount.setEmployees(addAccountRequest.getEmployees());
			addAccount.setAnnualRevenue(addAccountRequest.getAnnualRevenue());
			addAccount.setSicCode(addAccountRequest.getSicCode());
			addAccount.setBillingAddressStreet(addAccountRequest.getBillingAddressStreet());
			addAccount.setBillingAddressCity(addAccountRequest.getBillingAddressCity());
			addAccount.setBillingAddressState(addAccountRequest.getBillingAddressState());
			addAccount.setBillingAddressCode(addAccountRequest.getBillingAddressCode());
			addAccount.setBillingAddressCountry(addAccountRequest.getBillingAddressCountry());
			addAccount.setShippingAddressStreet(addAccountRequest.getShippingAddressStreet());
			addAccount.setShippingAddressCity(addAccountRequest.getShippingAddressCity());
			addAccount.setShippingAddressState(addAccountRequest.getShippingAddressState());
			addAccount.setShippingAddressCode(addAccountRequest.getShippingAddressCode());
			addAccount.setShippingAddressCountry(addAccountRequest.getShippingAddressCountry());
			addAccount.setDescription(addAccountRequest.getDescription());
			addAccount.setCreatedBy(addAccountRequest.getCreatedBy());
			addAccount.setCreatedTime(addAccountRequest.getCreatedTime());
			addAccount.setModifyBy(addAccountRequest.getModifyBy());
			addAccount.setModifyTime(addAccountRequest.getModifyTime());
			addAccount.setParentAccountId(addAccountRequest.getParentAccountId());


		}
		return addAccount;

	}
}
