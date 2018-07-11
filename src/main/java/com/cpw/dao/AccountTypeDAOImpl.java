package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.AccountTypeMapper;
import com.cpw.jdbc.model.AccountType;

public class AccountTypeDAOImpl implements AccountTypeDAO {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);

	}

	@Override
	public List<AccountType> accountTypeList() {
		logger.debug("Entering into accountTypeList DAO");
		CpwTemplete<AccountType> cpwTemplete = new CpwTempleteImpl<AccountType>();
		final String sql = "SELECT ID, ACC_TYPE_LIST FROM ACC_TYPE";
		try {
			List<AccountType> accountType = cpwTemplete.getRecordList(sql, jdbcTemplateObject, new AccountTypeMapper());
			return accountType;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No AccountType data  in system");
			return null;
		}

	}
}
