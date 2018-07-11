package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.LeadFieldMapper;
import com.cpw.jdbc.model.LeadField;

public class LeadFieldDAOImpl implements LeadFieldDAO {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<LeadField> leadFieldList() {
		logger.debug("Entering into leadFieldList DAO");
		CpwTemplete<LeadField> cpwTemplete = new CpwTempleteImpl<LeadField>();
		final String sql = "SELECT ID, Field FROM LEAD_FIELDS";
		try {
			List<LeadField> leadField = cpwTemplete.getRecordList(sql, jdbcTemplateObject, new LeadFieldMapper());
			return leadField;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No LeadField data  in system");
			return null;
		}
	}

}
