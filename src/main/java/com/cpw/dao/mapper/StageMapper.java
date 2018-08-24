package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Stage;

public class StageMapper implements RowMapper<Stage>{

	@Override
	public Stage mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		
		final Stage stage=new Stage();
		
		stage.setStage(resultSet.getString("STAGE"));
		stage.setStageId(resultSet.getLong("STAGE_ID"));
		stage.setProbability(resultSet.getString("PROBABILITY"));
		
		return stage;
	}

}
