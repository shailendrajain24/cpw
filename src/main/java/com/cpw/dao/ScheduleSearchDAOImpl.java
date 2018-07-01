package com.cpw.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.ScheduleSearchMapper;
import com.cpw.jdbc.model.ScheduleSearch;
import com.cpw.model.ScheduleSearchRequest;

public class ScheduleSearchDAOImpl implements ScheduleSearchDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ScheduleSearch> searchScheduleList(ScheduleSearchRequest scheduleSearchRequest) {
		StringBuilder sb = new StringBuilder();
		List<String> value = new ArrayList<>();
		sb.append("SELECT B.pol_code, B.pod_code, B.etd, B.eta, C.NAME " + "FROM sailing_schedule_hdr A "
				+ "INNER JOIN sailing_schedule_dtl B ON A.schedule_id = B.schedule_id "
				+ "LEFT JOIN vessel_master C ON A.vessel_id = C.vessel_id WHERE ");
		if (scheduleSearchRequest.getVesselId() != 0) {
			sb.append(" A.vessel_id = ? ");
			value.add(String.valueOf(scheduleSearchRequest.getVesselId()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getPodId() != 0) {
			sb.append(" B.pod_id = ? ");
			value.add(String.valueOf(scheduleSearchRequest.getPodId()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getPolId() != 0) {
			sb.append("B.pol_id = ? ");
			value.add(String.valueOf(scheduleSearchRequest.getPolId()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getFromETD() != null && !scheduleSearchRequest.getFromETD().isEmpty()) {
			sb.append("B.etd >= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getFromETD()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getToETD() != null && !scheduleSearchRequest.getToETD().isEmpty()) {
			sb.append(" B.etd <= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getToETD()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getFromETA() != null && !scheduleSearchRequest.getFromETA().isEmpty()) {
			sb.append(" B.eta >= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getFromETA()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getToETD() != null && !scheduleSearchRequest.getToETA().isEmpty()) {
			sb.append(" B.eta <= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getToETA()));
		}

		try {
			return jdbcTemplateObject.query(sb.toString(), value.toArray(), new ScheduleSearchMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Sailing Schedule detail in system");
			return null;
		}
	}

}
