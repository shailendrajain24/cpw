package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.IndustryMapper;
import com.cpw.jdbc.model.Industry;

public class IndustryDAOImpl implements IndustryDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Industry> industryList() {
		logger.debug("Entering into industryList DAO");
		CpwTemplete<Industry> cpwTemplete = new CpwTempleteImpl<Industry>();
		final String sql = "SELECT ID, NAME FROM LEAD_INDUSTRY";
		try {
			List<Industry> industries = cpwTemplete.getRecordList(sql, jdbcTemplateObject, new IndustryMapper());
			return industries;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Rating data  in system");
			return null;
		}
	}

}
