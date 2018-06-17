package com.cpw.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.SectorMapper;
import com.cpw.jdbc.model.Sector;

public class SectorDAOImpl implements SectorDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Sector> sectorList() {
		logger.debug("Entering into sectorList");
		List<Sector> sector = Collections.emptyList();
		final String sectorSql = "SELECT SECTOR_ID, NAME FROM SECTOR_MASTER";
		try {
			sector = jdbcTemplateObject.query(sectorSql, new SectorMapper());
			return sector;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No sector data  in system");
			return null;
		}
	}

}
