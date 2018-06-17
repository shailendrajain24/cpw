package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.BlListMapper;
import com.cpw.jdbc.model.BlList;

public class BlListDAOImpl implements BlListDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<BlList> getBlList(String userType, int userId) {
		logger.debug("Entering into getBlList");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT BOOKING_NO, BOOKING_DATE, ETA, ETD FROM BOOKING_HDR WHERE");
		if (!userType.isEmpty() && userType.trim().equals("E")) {
			sb.append(" CR_BY = ? ");
		} else {
			sb.append(" FORWARDER_ID = ? ");
		}

		try {
			return jdbcTemplateObject.query(sb.toString(), new Object[] { userId }, new BlListMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("BL List data not present in system");
			return null;
		}
	}

}
