package com.cpw.dao;

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

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Sector> sectorList() {
		logger.debug("Entering into sectorList");
		final String sectorSql = "SELECT SECTOR_ID, NAME FROM SECTOR_MASTER";
		try {
			return jdbcTemplateObject.query(sectorSql, new SectorMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No sector data  in system");
			return null;
		}
	}

}
