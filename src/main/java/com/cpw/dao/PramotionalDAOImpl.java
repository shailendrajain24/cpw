package com.cpw.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.jdbc.model.Pramotional;

public class PramotionalDAOImpl implements PramotionalDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	//private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		//this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public String pramotinal(Pramotional pramotional) {
		logger.debug("Entering into pramotinal");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT BOOKING_NO, BOOKING_DATE, ETA, ETD FROM BOOKING_HDR WHERE");

		try {
			// blList = jdbcTemplateObject.query(sb.toString(), new Object[] { userId }, new
			// BlListMapper());
			return null;
		} catch (EmptyResultDataAccessException e) {
			logger.error("BL List data not present in system");
			return null;
		}
	}

}
