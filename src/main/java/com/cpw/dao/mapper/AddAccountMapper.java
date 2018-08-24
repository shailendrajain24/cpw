package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.AddAccount;

public class AddAccountMapper implements RowMapper<AddAccount>{

	@Override
	public AddAccount mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final AddAccount addAccount=new AddAccount();
		addAccount.setId(resultSet.getLong("ACCOUNT_ID"));
		addAccount.setAccountOwner(resultSet.getString("ACCOUNT_OWNER"));
		addAccount.setRating(resultSet.getString("RATING"));
		addAccount.setAccountName(resultSet.getString("ACCOUNT_NAME"));
		addAccount.setPhone(resultSet.getString("PHONE"));
		addAccount.setAccountSite(resultSet.getString("ACCOUNT_SITE"));
		addAccount.setFax(resultSet.getString("FAX"));
		addAccount.setParentAccount(resultSet.getString("PARENT_ACCOUNT"));
		addAccount.setWebSite(resultSet.getString("WEBSITE"));
		addAccount.setAccountNumber(resultSet.getInt("ACCOUNT_NUMBER"));
		addAccount.setTickerSymbol(resultSet.getString("TICKER_SYMBOL"));
		addAccount.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
		addAccount.setOwnerShip(resultSet.getString("OWNERSHIP"));
		addAccount.setIndustry(resultSet.getString("INDUSTRY"));
		addAccount.setEmployees(resultSet.getString("EMPLOYEE"));
		addAccount.setAnnualRevenue(resultSet.getString("ANNUAL_REVENUE"));
		addAccount.setSicCode(resultSet.getString("SIC_CODE"));
		addAccount.setBillingAddressStreet(resultSet.getString("BILLING_STREET"));
		addAccount.setBillingAddressCity(resultSet.getString("BILLING_CITY"));
		addAccount.setBillingAddressState(resultSet.getString("BILLING_STATE"));
		addAccount.setBillingAddressCode(resultSet.getString("BILLING_CODE"));
		addAccount.setBillingAddressCountry(resultSet.getString("BILLING_COUNTRY"));
		addAccount.setShippingAddressStreet(resultSet.getString("ADDRESS_STREET"));
		addAccount.setShippingAddressCity(resultSet.getString("ADDRESS_CITY"));
		addAccount.setShippingAddressState(resultSet.getString("ADDRESS_STATE"));
		addAccount.setShippingAddressCode(resultSet.getString("ADDRESS_CODE"));
		addAccount.setShippingAddressCountry(resultSet.getString("ADDRESS_COUNTRY"));
		addAccount.setDescription(resultSet.getString("DESCRIPTION"));
		addAccount.setCreatedBy(resultSet.getString("CREATED_BY"));
		addAccount.setCreatedTime(resultSet.getLong("CREATED_TIME"));
		addAccount.setModifyBy(resultSet.getString("MODIFY_BY"));
		addAccount.setModifyTime(resultSet.getLong("MODIFY_TIME"));
		addAccount.setParentAccountId(resultSet.getLong("PARENT_ACCOUNT_ID"));



		return addAccount;
	}

}
