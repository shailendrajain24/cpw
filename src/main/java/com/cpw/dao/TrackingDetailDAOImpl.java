package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.TrackingDetailMapper;
import com.cpw.jdbc.model.TrackingDetail;

public class TrackingDetailDAOImpl implements TrackingDetailDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<TrackingDetail> trackingDetail() {
		logger.debug("Entering into trackingDetail");
		final String trackingSql = "SELECT TYPE_ID, TYPE, MIN_LENGTH, MAX_LENGTH, CONTENT_TYPE, START_FROM, START_CHAR_LENGTH"
				+ " FROM TRACKTYPES";
		try {
			return jdbcTemplateObject.query(trackingSql, new TrackingDetailMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Track data  in system");
			return null;
		}
	}

}
