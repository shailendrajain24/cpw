package com.cpw.dao;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.cpw.dao.mapper.PendingInvoicesDetailMapper;
import com.cpw.dao.mapper.ScheduleSearchMapper;
import com.cpw.jdbc.model.PendingInvoicesDetail;
import com.cpw.jdbc.model.ScheduleSearch;
import com.cpw.model.ScheduleSearchRequest;

public class ScheduleSearchDAOImpl implements ScheduleSearchDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<ScheduleSearch> searchScheduleList(ScheduleSearchRequest scheduleSearchRequest) {
		/*final String sql = "SELECT B.pol_code, B.pod_code, B.etd, B.eta, C.NAME FROM "
				+ "  sailing_schedule_hdr A INNER JOIN sailing_schedule_dtl B ON A.schedule_id = B.schedule_id "
				+ "LEFT JOIN vessel_master C ON A.vessel_id = C.vessel_id WHERE  A.vessel_id = ? "*/
		/*
		 * + "AND B.pod_id = ? " +
		 * "AND B.pol_id = ? AND B.etd >= FromETD AND B.etd <= ToETD AND B.eta >= FromETA AND B.eta <= ToETA "
		 */;
		StringBuilder sb = new StringBuilder();
		List<ScheduleSearch> scheduleSearchList = Collections.emptyList();
		List<String> value = new ArrayList<>();
		sb.append("SELECT B.pol_code, B.pod_code, B.etd, B.eta, C.NAME " + "FROM sailing_schedule_hdr A "
				+ "INNER JOIN sailing_schedule_dtl B ON A.schedule_id = B.schedule_id "
				+ "LEFT JOIN vessel_master C ON A.vessel_id = C.vessel_id WHERE");
		if (scheduleSearchRequest.getVesselId() != 0) {
			sb.append(" A.vessel_id = ? ");
			value.add(String.valueOf(scheduleSearchRequest.getVesselId()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getPodId() != 0) {
			sb.append("B.pod_id = ? ");
			value.add(String.valueOf(scheduleSearchRequest.getPodId()));
			sb.append(" AND ");
		}
		if (scheduleSearchRequest.getPolId() != 0) {
			sb.append("B.pol_id = ? ");
			value.add(String.valueOf(scheduleSearchRequest.getPolId()));
			sb.append(" AND ");
		}
		/*String sDate = "2017-11-18";
		String eDate = "2017-11-19";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");*/
		if (scheduleSearchRequest.getFromETD()!= null && !scheduleSearchRequest.getFromETD().isEmpty()) {
			sb.append("B.etd >= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getFromETD()));
			sb.append(" AND ");
		} /*else {
			sb.append("AND B.etd >= ? ");
			java.util.Date dd = sdf.parse(sDate, new ParsePosition(0));

			java.sql.Timestamp  dd1 = new java.sql.Timestamp(dd.getTime());
			value.add(String.valueOf(dd1));
		}*/
		if (scheduleSearchRequest.getToETD()!= null && !scheduleSearchRequest.getToETD().isEmpty()) {
			sb.append("B.etd <= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getToETD()));
			sb.append(" AND ");
		} /*else {
			sb.append("AND B.etd <= ? ");
			java.util.Date dd = sdf.parse(sDate, new ParsePosition(0));

			java.sql.Timestamp  dd1 = new java.sql.Timestamp(dd.getTime());
			value.add(String.valueOf(dd1));
		}*/
		
		if (scheduleSearchRequest.getFromETA()!= null && !scheduleSearchRequest.getFromETA().isEmpty()) {
			sb.append("B.eta >= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getFromETA()));
			sb.append(" AND ");
		} /*else {
			sb.append("AND B.eta >= ? ");
			java.util.Date dd2 = sdf.parse(eDate, new ParsePosition(0));

			java.sql.Timestamp  dd12 = new java.sql.Timestamp (dd2.getTime());
			value.add(String.valueOf(dd12));
		}*/
		if (scheduleSearchRequest.getToETD()!= null && !scheduleSearchRequest.getToETA().isEmpty()) {
			sb.append("B.eta <= ? ");
			value.add(String.valueOf(scheduleSearchRequest.getToETA()));
		} /*else {
			sb.append("AND B.eta <= ? ");
			java.util.Date dd2 = sdf.parse(eDate, new ParsePosition(0));

			java.sql.Timestamp  dd12 = new java.sql.Timestamp (dd2.getTime());
			value.add(String.valueOf(dd12));
		}*/

		try {
			scheduleSearchList = jdbcTemplateObject.query(sb.toString(), value.toArray(), new ScheduleSearchMapper());
			return scheduleSearchList;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Sailing Schedule detail in system");
			return null;
		}
	}

}
