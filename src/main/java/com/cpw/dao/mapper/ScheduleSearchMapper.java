package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.StoredProcedure;

import com.cpw.jdbc.model.ScheduleSearch;

@SuppressWarnings("rawtypes")
public class ScheduleSearchMapper implements RowMapper<ScheduleSearch> {

	public ScheduleSearch mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		ScheduleSearch scheduleSearch = new ScheduleSearch();
		scheduleSearch.setEta(resultSet.getDate("ETA"));
		scheduleSearch.setEtd(resultSet.getDate("ETD"));
		scheduleSearch.setPodCode(resultSet.getString("POD_CODE"));
		scheduleSearch.setPolCode(resultSet.getString("POL_CODE"));
		scheduleSearch.setVesselName(resultSet.getString("NAME"));
		return scheduleSearch;
	}

}

/*public class ScheduleSearchMapper extends StoredProcedure {

	@SuppressWarnings("rawtypes")
	 public ScheduleSearchMapper(JdbcTemplate jdbcTemplate) {
	 super(jdbcTemplate, "Sp_sailing_schedule_search");
	 //RowMapper rowMapper = new ScheduleSearchMapper(); 
	}
	
	 
	public ScheduleSearch mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		ScheduleSearch scheduleSearch = new ScheduleSearch();
		scheduleSearch.setEta(resultSet.getDate("ETA"));
		scheduleSearch.setEtd(resultSet.getDate("ETD"));
		scheduleSearch.setPodCode(resultSet.getInt("POD_CODE"));
		scheduleSearch.setPolId(resultSet.getInt("POL_ID"));
		scheduleSearch.setVesselName(resultSet.getString("NAME"));
		return scheduleSearch;
	}

}*/
