package com.cpw.dao;

import java.util.Collections;
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

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<TrackingDetail> trackingDetail() {
		logger.debug("Entering into trackingDetail");
		List<TrackingDetail> trackingDetail = Collections.emptyList();
		final String trackingSql = "SELECT TYPE, MIN_LENGTH, MAX_LENGTH, CONTENT_TYPE, START_FROM, START_CHAR_LENGTH"
				+ " FROM TRACKTYPES";
		try {
			trackingDetail = jdbcTemplateObject.query(trackingSql, new TrackingDetailMapper());
			return trackingDetail;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Port data  in system");
			return null;
		}
	}

}
