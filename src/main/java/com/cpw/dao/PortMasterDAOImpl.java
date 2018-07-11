package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.PortMasterMapper;
import com.cpw.jdbc.model.PortMaster;

public class PortMasterDAOImpl implements PortMasterDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<PortMaster> allPortMaster() {
		logger.debug("Entering into allPortMaster");
		final String userRoleSql = "SELECT PORT_MASTER.CODE, PORT_MASTER.PORT_ID, PORT_MASTER.NAME, COUNTRIES.COUNTRY_NAME "
				+ "FROM PORT_MASTER, COUNTRIES " + "WHERE COUNTRIES.COUNTRY_ID=PORT_MASTER.COUNTRY_ID ORDER BY PORT_ID";
		try {
			return jdbcTemplateObject.query(userRoleSql, new PortMasterMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Port data  in system");
			return null;
		}
	}

}
