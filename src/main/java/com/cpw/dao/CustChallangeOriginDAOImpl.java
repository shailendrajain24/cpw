package com.cpw.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.CustChallangeOriginMapper;
import com.cpw.jdbc.model.CustChallangeOrigin;

public class CustChallangeOriginDAOImpl implements CustChallangeOriginDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<CustChallangeOrigin> custChallangeOriginList() {
		logger.debug("Entering into custChallangeOriginList");
		List<CustChallangeOrigin> custChallangeOrigin = Collections.emptyList();
		final String custChallangeOriginSql = "SELECT PRIORTY_ID, NAME FROM CUST_CHALLENGE_ORIGIN";
		try {
			custChallangeOrigin = jdbcTemplateObject.query(custChallangeOriginSql, new CustChallangeOriginMapper());
			return custChallangeOrigin;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No custChallangeOrigin data  in system");
			return null;
		}
	}

}
