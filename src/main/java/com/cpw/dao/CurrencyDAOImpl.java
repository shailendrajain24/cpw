package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.CurrencyMapper;
import com.cpw.jdbc.model.Currency;

public class CurrencyDAOImpl implements CurrencyDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Currency> currencyList() {
		logger.debug("Entering into currencyList");
		final String currencySql = "SELECT CURRENCY_ID, CODE FROM CURRENCY_MASTER";
		try {
			return jdbcTemplateObject.query(currencySql, new CurrencyMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No currency data  in system");
			return null;
		}
	}

}
