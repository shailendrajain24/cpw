package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.AddAccountMapper;
import com.cpw.jdbc.model.AddAccount;

public class AddAccountDAOImpl implements AddAccountDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public int upsertAccount(AddAccount accountRequest) {
		logger.debug("Entering into account DAO");
		CpwTemplete<AddAccount> cpwTemplete = new CpwTempleteImpl<AddAccount>();

		String q1 = "SELECT *FROM ACCOUNT WHERE ACCOUNT_ID=?";
		AddAccount accountInSystem = null;
		try {
			accountInSystem = jdbcTemplateObject.queryForObject(q1, new Object[] { accountRequest.getId() },
					new AddAccountMapper());
		} catch (EmptyResultDataAccessException e) {
			accountInSystem = null;
		}
		try {
			int count = -1;
			if (accountInSystem != null && accountInSystem.getId() == accountRequest.getId()) {
				logger.debug("UPDATE values" + accountRequest.getId());
				String updateSql = "UPDATE ACCOUNT SET ACCOUNT_OWNER=?,RATING=?,ACCOUNT_NAME=?,PHONE=?,"
						+ "ACCOUNT_SITE=?,FAX=?,PARENT_ACCOUNT=?,WEBSITE=?,ACCOUNT_NUMBER=?,TICKER_SYMBOL=?,"
						+ "ACCOUNT_TYPE=?,OWNERSHIP=?,INDUSTRY=?,EMPLOYEE=?,ANNUAL_REVENUE=?,SIC_CODE=?,BILLING_STREET=?,"
						+ "BILLING_CITY=?,BILLING_STATE=?,BILLING_CODE=?,BILLING_COUNTRY=?,ADDRESS_STREET=?,ADDRESS_CITY=?,"
						+ "ADDRESS_STATE=?,ADDRESS_CODE=?,ADDRESS_COUNTRY=?,DESCRIPTION=?,CREATED_BY=?,CREATED_TIME=?,"
						+ "MODIFY_BY=?,MODIFY_TIME=?,PARENT_ACCOUNT_ID=? WHERE ACCOUNT_ID=?";
				return jdbcTemplateObject.update(updateSql,
						accountRequest.getAccountOwner() == null ? accountInSystem.getAccountOwner()
								: accountRequest.getAccountOwner(),
						accountRequest.getRating() == null ? accountInSystem.getRating() : accountRequest.getRating(),
						accountRequest.getAccountName() == null ? accountInSystem.getAccountName()
								: accountRequest.getAccountName(),
						accountRequest.getPhone() == null ? accountInSystem.getPhone() : accountRequest.getPhone(),
						accountRequest.getAccountSite() == null ? accountInSystem.getAccountSite()
								: accountRequest.getAccountSite(),
						accountRequest.getFax() == null ? accountInSystem.getFax() : accountRequest.getFax(),
						accountRequest.getParentAccount() == null ? accountInSystem.getParentAccount()
								: accountRequest.getParentAccount(),
						accountRequest.getWebSite() == null ? accountInSystem.getWebSite()
								: accountRequest.getWebSite(),
						accountRequest.getAccountNumber() == 0 ? accountInSystem.getAccountNumber()
								: accountRequest.getAccountNumber(),
						accountRequest.getTickerSymbol() == null ? accountInSystem.getTickerSymbol()
								: accountRequest.getTickerSymbol(),
						accountRequest.getAccountType() == null ? accountInSystem.getAccountType()
								: accountRequest.getAccountType(),
						accountRequest.getOwnerShip() == null ? accountInSystem.getOwnerShip()
								: accountRequest.getOwnerShip(),
						accountRequest.getIndustry() == null ? accountInSystem.getIndustry()
								: accountRequest.getIndustry(),
						accountRequest.getEmployees() == 0 ? accountInSystem.getEmployees()
								: accountRequest.getEmployees(),
						accountRequest.getAnnualRevenue() == null ? accountInSystem.getAnnualRevenue()
								: accountRequest.getAnnualRevenue(),
						accountRequest.getSicCode() == null ? accountInSystem.getSicCode()
								: accountRequest.getSicCode(),
						accountRequest.getBillingAddressStreet() == null ? accountInSystem.getBillingAddressStreet()
								: accountRequest.getBillingAddressStreet(),
						accountRequest.getBillingAddressCity() == null ? accountInSystem.getBillingAddressCity()
								: accountRequest.getBillingAddressCity(),
						accountRequest.getBillingAddressState() == null ? accountInSystem.getBillingAddressState()
								: accountRequest.getBillingAddressState(),
						accountRequest.getBillingAddressCode() == null ? accountInSystem.getBillingAddressCode()
								: accountRequest.getBillingAddressCode(),
						accountRequest.getBillingAddressCountry() == null ? accountInSystem.getBillingAddressCountry()
								: accountRequest.getBillingAddressCountry(),
						accountRequest.getShippingAddressStreet() == null ? accountInSystem.getShippingAddressStreet()
								: accountRequest.getShippingAddressStreet(),
						accountRequest.getShippingAddressCity() == null ? accountInSystem.getShippingAddressCity()
								: accountRequest.getShippingAddressCity(),
						accountRequest.getShippingAddressState() == null ? accountInSystem.getShippingAddressState()
								: accountRequest.getShippingAddressState(),
						accountRequest.getShippingAddressCode() == null ? accountInSystem.getShippingAddressCode()
								: accountRequest.getShippingAddressCode(),
						accountRequest.getShippingAddressCountry() == null ? accountInSystem.getShippingAddressCountry()
								: accountRequest.getShippingAddressCountry(),
						accountRequest.getDescription() == null ? accountInSystem.getDescription()
								: accountRequest.getDescription(),
						accountRequest.getCreatedBy() == null ? accountInSystem.getCreatedBy()
								: accountRequest.getCreatedBy(),
						accountRequest.getCreatedTime() == 0 ? accountInSystem.getCreatedTime()
								: accountRequest.getCreatedTime(),
						accountRequest.getModifyBy() == null ? accountInSystem.getModifyBy()
								: accountRequest.getModifyBy(),
						accountRequest.getModifyTime() == 0 ? accountInSystem.getModifyTime()
								: accountRequest.getModifyTime(),
						accountRequest.getParentAccountId() == 0 ? accountInSystem.getParentAccountId()
								: accountRequest.getParentAccountId(),
						accountRequest.getId());
			} else {
				Object[] values = new Object[33];
				values[0] = accountRequest.getId();
				values[1] = accountRequest.getAccountOwner();
				values[2] = accountRequest.getRating();
				values[3] = accountRequest.getAccountName();
				values[4] = accountRequest.getPhone();
				values[5] = accountRequest.getAccountSite();
				values[6] = accountRequest.getFax();
				values[7] = accountRequest.getParentAccount();
				values[8] = accountRequest.getWebSite();
				values[9] = accountRequest.getAccountNumber();
				values[10] = accountRequest.getTickerSymbol();
				values[11] = accountRequest.getAccountType();
				values[12] = accountRequest.getOwnerShip();
				values[13] = accountRequest.getIndustry();
				values[14] = accountRequest.getEmployees();
				values[15] = accountRequest.getAnnualRevenue();
				values[16] = accountRequest.getSicCode();
				values[17] = accountRequest.getBillingAddressStreet();
				values[18] = accountRequest.getBillingAddressCity();
				values[19] = accountRequest.getBillingAddressState();
				values[20] = accountRequest.getBillingAddressCode();
				values[21] = accountRequest.getBillingAddressCountry();
				values[22] = accountRequest.getShippingAddressStreet();
				values[23] = accountRequest.getShippingAddressCity();
				values[24] = accountRequest.getShippingAddressState();
				values[25] = accountRequest.getShippingAddressCode();
				values[26] = accountRequest.getShippingAddressCountry();
				values[27] = accountRequest.getDescription();
				values[28] = accountRequest.getCreatedBy();
				values[29] = accountRequest.getCreatedTime();
				values[30] = accountRequest.getModifyBy();
				values[31] = accountRequest.getModifyTime();
				values[32] = accountRequest.getParentAccountId();
				logger.debug("INSERT values" + values[1]);
				String insertSql = "INSERT INTO ACCOUNT (ACCOUNT_ID,ACCOUNT_OWNER,RATING,ACCOUNT_NAME,PHONE,"
						+ "ACCOUNT_SITE,FAX,PARENT_ACCOUNT,WEBSITE,ACCOUNT_NUMBER,TICKER_SYMBOL,ACCOUNT_TYPE,"
						+ "OWNERSHIP,INDUSTRY,EMPLOYEE,ANNUAL_REVENUE,SIC_CODE,BILLING_STREET,BILLING_CITY,"
						+ "BILLING_STATE,BILLING_CODE,BILLING_COUNTRY,ADDRESS_STREET,ADDRESS_CITY,"
						+ "ADDRESS_STATE,ADDRESS_CODE,ADDRESS_COUNTRY,DESCRIPTION,CREATED_BY"
						+ ",CREATED_TIME,MODIFY_BY,MODIFY_TIME,PARENT_ACCOUNT_ID)"
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				count = cpwTemplete.upsert(insertSql, values, jdbcTemplateObject);
				logger.debug("Record creation status: " + count);
			}
			logger.debug("Before Calling upsert");

			return count;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<AddAccount> accountList(long id) {
		CpwTemplete<AddAccount> cpwTemplete = new CpwTempleteImpl<AddAccount>();

		try {
			if (id == 0) {
				logger.debug("Entering into accountList ");
				final String trackingSql = "SELECT * FROM ACCOUNT";
				List<AddAccount> accountList = cpwTemplete.getRecordList(trackingSql, jdbcTemplateObject,
						new AddAccountMapper());
				return accountList;
			} else {
				logger.debug("Entering into accountList" + id);
				final String trackingSql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_ID=?";
				List<AddAccount> accountList = jdbcTemplateObject.query(trackingSql, new Object[] { id },
						new AddAccountMapper());
				return accountList;
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No ACCOUNTList in system");

		}
		return null;
	}

	@Override
	public int removeAccount(long id) {
		logger.debug("Entering into remove aCCOUNT");
		final String trackingSql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID=?";
		try {
			return jdbcTemplateObject.update(trackingSql, id);
		} catch (DataAccessException e) {
			logger.error("No Account available in system coresponding to Account id: " + id);
			return 0;
		}

	}

}
