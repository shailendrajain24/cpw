package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.ScheduleSearch;
import com.cpw.model.ScheduleSearchRequest;

public interface ScheduleSearchDAO {

	public void setDataSource(DataSource ds);

	public List<ScheduleSearch> searchScheduleList(ScheduleSearchRequest scheduleSearchRequest);

}
