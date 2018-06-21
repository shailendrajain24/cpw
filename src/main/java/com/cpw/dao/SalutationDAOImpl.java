package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.SalutationMapper;
import com.cpw.jdbc.model.Salutation;

public class SalutationDAOImpl implements SalutationDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Salutation> salutationList() {
		logger.debug("Entering into salutationList DAO");
		CpwTemplete<Salutation> cpwTemplete = new CpwTempleteImpl<Salutation>();
		final String sql = "SELECT ID, NAME FROM LEAD_SALUTATION";
		try {
			List<Salutation> salutations = cpwTemplete.getRecordList(sql, jdbcTemplateObject, new SalutationMapper());
			return salutations;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Salutation data  in system");
			return null;
		}
	}

}
