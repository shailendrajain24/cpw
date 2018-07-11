package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.LeadSourceMapper;
import com.cpw.jdbc.model.LeadSource;

public class LeadSourceDAOImpl implements LeadSourceDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LeadSource> leadSourceList() {
		logger.debug("Entering into leadSourceList DAO");
		CpwTemplete<LeadSource> cpwTemplete = new CpwTempleteImpl<LeadSource>();
		final String sql = "SELECT ID, NAME FROM LEAD_SOURCE";
		try {
			List<LeadSource> leadSource = cpwTemplete.getRecordList(sql, jdbcTemplateObject, new LeadSourceMapper());
			return leadSource;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No LeadSource data  in system");
			return null;
		}
	}

}
