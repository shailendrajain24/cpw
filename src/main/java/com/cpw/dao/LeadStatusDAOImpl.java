package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.LeadStatusMapper;
import com.cpw.jdbc.model.LeadStatus;

public class LeadStatusDAOImpl implements LeadStatusDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<LeadStatus> leadStatusList() {
		logger.debug("Entering into leadStatusList DAO");
		CpwTemplete<LeadStatus> cpwTemplete = new CpwTempleteImpl<LeadStatus>();
		final String sql = "SELECT ID, NAME FROM LEAD_STATUS";
		try {
			List<LeadStatus> ratings = cpwTemplete.getRecordList(sql, jdbcTemplateObject, new LeadStatusMapper());
			return ratings;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No LeadStatus data  in system");
			return null;
		}
	}

}
