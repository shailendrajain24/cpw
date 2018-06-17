package com.cpw.dao;

import java.util.Collections;
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

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CustChallangePriorty> custChallangePriortyList() {
		logger.debug("Entering into custChallangePriortyList");
		List<CustChallangePriorty> custChallangePriorty = Collections.emptyList();
		final String custChallangePriortySql = "SELECT PRIORTY_ID, NAME FROM CUST_CHALLENGE_PRIORTY";
		try {
			custChallangePriorty = jdbcTemplateObject.query(custChallangePriortySql, new CustChallangePriortyMapper());
			return custChallangePriorty;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No custChallangePriorty data  in system");
			return null;
		}
	}

}
