package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.StageMapper;
import com.cpw.jdbc.model.Stage;

public class StageDAOImpl implements StageDAO{
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject=new JdbcTemplate(ds);
		
	}

	@Override
	public List<Stage> stageList() {
		logger.debug("Entering into stageList DAO");
		CpwTemplete<Stage> cpwTemplete = new CpwTempleteImpl<Stage>();
		final String sql = "SELECT * FROM STAGE_LIST";
		try {
			List<Stage> stage = cpwTemplete.getRecordList(sql,jdbcTemplateObject,new StageMapper());
			System.out.println(stage);
			return stage;
		} catch (Exception e) {
			logger.error("No stage data  in system "+e.getMessage());
			return null;
		}

	
	}

}
