package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.ScheduleSearch;

public class ScheduleSearchMapper implements RowMapper<ScheduleSearch> {

	public ScheduleSearch mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final ScheduleSearch scheduleSearch = new ScheduleSearch();
		scheduleSearch.setEta(resultSet.getDate("ETA"));
		scheduleSearch.setEtd(resultSet.getDate("ETD"));
		scheduleSearch.setPodCode(resultSet.getString("POD_CODE"));
		scheduleSearch.setPolCode(resultSet.getString("POL_CODE"));
		scheduleSearch.setVesselName(resultSet.getString("NAME"));
		return scheduleSearch;
	}

}
