package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.CustChallangePriortyMapper;
import com.cpw.jdbc.model.CustChallangePriorty;

public class CustChallangePriortyDAOImpl implements CustChallangePriortyDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CustChallangePriorty> custChallangePriortyList() {
		logger.debug("Entering into custChallangePriortyList");
		final String custChallangePriortySql = "SELECT PRIORTY_ID, NAME FROM CUST_CHALLENGE_PRIORTY";
		try {
			return jdbcTemplateObject.query(custChallangePriortySql, new CustChallangePriortyMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No custChallangePriorty data  in system");
			return null;
		}
	}

}
