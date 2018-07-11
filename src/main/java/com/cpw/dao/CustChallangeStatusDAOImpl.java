package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.CustChallangeStatusMapper;
import com.cpw.jdbc.model.CustChallangeStatus;

public class CustChallangeStatusDAOImpl implements CustChallangeStatusDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CustChallangeStatus> custChallangeStatusList() {
		logger.debug("Entering into custChallangeStatusList");
		final String custChallangeStatusSql = "SELECT PRIORTY_ID, NAME FROM CUST_CHALLENGE_STATUS";
		try {
			return jdbcTemplateObject.query(custChallangeStatusSql, new CustChallangeStatusMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No custChallangeStatus data  in system");
			return null;
		}
	}

}
