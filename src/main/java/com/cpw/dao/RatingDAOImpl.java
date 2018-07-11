package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.RatingMapper;
import com.cpw.jdbc.model.Rating;

public class RatingDAOImpl implements RatingDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Rating> ratingList() {
		logger.debug("Entering into ratingList DAO");
		CpwTemplete<Rating> cpwTemplete = new CpwTempleteImpl<Rating>();
		final String sql = "SELECT ID, NAME FROM LEAD_RATING";
		try {
			List<Rating> ratings = cpwTemplete.getRecordList(sql, jdbcTemplateObject, new RatingMapper());
			return ratings;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Rating data  in system");
			return null;
		}
	}

}
