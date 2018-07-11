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
	public int upsertAccount(AddAccount account) {
		logger.debug("Entering into account DAO");
		CpwTemplete<AddAccount> cpwTemplete = new CpwTempleteImpl<AddAccount>();

		String q1 = "SELECT *FROM ACCOUNT WHERE ACCOUNT_ID=?";
		AddAccount a = null;
		try {
			a = jdbcTemplateObject.queryForObject(q1, new Object[] { account.getId() }, new AddAccountMapper());
		} catch (EmptyResultDataAccessException e) {
			a = null;
		}
		try {
			int count = -1;
			if (a != null && a.getId() == account.getId()) {
				logger.debug("UPDATE values" + account.getId());
				String updateSql = "UPDATE ACCOUNT SET ACCOUNT_OWNER=?, RATING=?, ACCOUNT_NAME=?, PHONE=?, ACCOUNT_SITE=?, FAX=?,"
						+ " PARENT_ACCOUNT=?, WEBSITE=?, ACCOUNT_NUMBER=?, TICKER_SYMBOL=?, ACCOUNT_TYPE=?, OWNERSHIP=?, INDUSTRY=?, EMPLOYEE=?, ANNUAL_REVENUE=?,SIC_CODE=?"
						+ ", BILLING_STREET=?, BILLING_CITY=?, BILLING_STATE=?, BILLING_CODE=?, BILLING_COUNTRY=?, ADDRESS_STREET=?,"
						+ " ADDRESS_CITY=?, ADDRESS_STATE=?, ADDRESS_CODE=?,ADDRESS_COUNTRY=?, DESCRIPTION=?, MODIFY_BY=?,MODIFY_TIME=?,PARENT_ACCOUNT_ID=?"
						+ " WHERE ACCOUNT_ID=?";
				return jdbcTemplateObject.update(updateSql, account.getAccountOwner(), account.getRating(),
						account.getAccountName(), account.getPhone(), account.getAccountSite(), account.getFax(),
						account.getParentAccount(), account.getWebSite(), account.getAccountNumber(),
						account.getTickerSymbol(), account.getAccountType(), account.getOwnerShip(),
						account.getIndustry(), account.getEmployees(), account.getAnnualRevenue(), account.getSicCode(),
						account.getBillingAddressStreet(), account.getBillingAddressCity(),
						account.getBillingAddressState(), account.getBillingAddressCode(),
						account.getBillingAddressCountry(), account.getShippingAddressStreet(),
						account.getShippingAddressCity(), account.getShippingAddressState(),
						account.getShippingAddressCode(), account.getShippingAddressCountry(), account.getDescription(),
						account.getModifyBy(), account.getModifyTime(), account.getCreatedBy(),
						account.getCreatedTime(), account.getId(), account.getParentAccountId());
			} else {
				Object[] values = new Object[33];
				values[0] = account.getId();
				values[1] = account.getAccountOwner();
				values[2] = account.getRating();
				values[3] = account.getAccountName();
				values[4] = account.getPhone();
				values[5] = account.getAccountSite();
				values[6] = account.getFax();
				values[7] = account.getParentAccount();
				values[8] = account.getWebSite();
				values[9] = account.getAccountNumber();
				values[10] = account.getTickerSymbol();
				values[11] = account.getAccountType();
				values[12] = account.getOwnerShip();
				values[13] = account.getIndustry();
				values[14] = account.getEmployees();
				values[15] = account.getAnnualRevenue();
				values[16] = account.getSicCode();
				values[17] = account.getBillingAddressStreet();
				values[18] = account.getBillingAddressCity();
				values[19] = account.getBillingAddressState();
				values[20] = account.getBillingAddressCode();
				values[21] = account.getBillingAddressCountry();
				values[22] = account.getShippingAddressStreet();
				values[23] = account.getShippingAddressCity();
				values[24] = account.getShippingAddressState();
				values[25] = account.getShippingAddressCode();
				values[26] = account.getShippingAddressCountry();
				values[27] = account.getDescription();
				values[28] = account.getCreatedBy();
				values[29] = account.getCreatedTime();
				values[30] = account.getModifyBy();
				values[31] = account.getModifyTime();
				values[32] = account.getParentAccountId();
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
			// logger.error("Exception at time of creation" + e);
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public List<AddAccount> accountList(String createdBy) {
		logger.debug("Entering into accountList " + createdBy);
		final String trackingSql = "Select ACCOUNT_ID,ACCOUNT_OWNER, RATING, ACCOUNT_NAME, PHONE,"
				+ " ACCOUNT_SITE, FAX,PARENT_ACCOUNT_ID,PARENT_ACCOUNT, WEBSITE, ACCOUNT_NUMBER, TICKER_SYMBOL, "
				+ "ACCOUNT_TYPE, OWNERSHIP, INDUSRY, EMPLOYEE, ANNUAL_REVENUE, SIC_CODE,"
				+ " BILLING_STREET, BILLING_CITY, BILLING_STATE, BILLING_CODE,BILLING_COUNTRY "
				+ "ADDRESS_STREET, ADDRESS_CITY, ADDRESS_STATE,ADDRESS_CODE,ADDRESS_COUNTRY,"
				+ " DESCRIPTION,CREATED_BY, CREATED_TIME, MODIFY_BY, MODIFY_TIME"
				+ " from ACCOUNT WHERE CREATED_BY = ?";
		try {
			List<AddAccount> accountList = jdbcTemplateObject.query(trackingSql, new Object[] { createdBy },
					new AddAccountMapper());
			return accountList;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No ACCOUNTList in system");
			return null;
		}

	}

	@Override
	public int removeAccount(long id) {
		logger.debug("Entering into remove aCCOUNT");
		final String trackingSql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID = ?";
		try {
			return jdbcTemplateObject.update(trackingSql, id);
		} catch (DataAccessException e) {
			logger.error("No Account available in system coresponding to Account id: " + id);
			return 0;
		}

	}

}
