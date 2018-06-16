package com.cpw.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.BlListMapper;
import com.cpw.jdbc.model.BlList;
import com.cpw.jdbc.model.Pramotional;

public class PramotionalDAOImpl implements PramotionalDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public String pramotinal(Pramotional pramotional) {
		logger.debug("Entering into pramotinal");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT BOOKING_NO, BOOKING_DATE, ETA, ETD FROM BOOKING_HDR WHERE");
		
		try {
			//blList = jdbcTemplateObject.query(sb.toString(), new Object[] { userId }, new BlListMapper());
			return null;
		} catch (EmptyResultDataAccessException e) {
			logger.error("BL List data not present in system");
			return null;
		}
	}

}
