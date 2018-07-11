package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.VesselMapper;
import com.cpw.jdbc.model.Vessel;

public class VesselDAOImpl implements VesselDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Vessel> vesselList() {
		logger.debug("Entering into vesselList");
		final String vesselSql = "SELECT VESSEL_ID, NAME FROM VESSEL_MASTER";
		try {
			return jdbcTemplateObject.query(vesselSql, new VesselMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No vessel data  in system");
			return null;
		}
	}

}
