package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.TraceDetailMapper;
import com.cpw.jdbc.model.Trace;

public class TraceDAOImpl implements TraceDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Trace> traceDetail(String transactionId, int type) {
		logger.debug("Entering into traceDetail");
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT JOB_ID, SOB_DATE, CONTAINER_NO, VOLUME, BOOKING_DATE, CUSTOMS_CLEARANCE_DATE, CARTING_DATE, CREATED_DATE, GR_WT, BOOKING_NO, SHIPPING_BILL_NO"
				+ " FROM vl_TRACKING A WHERE CLP_TYPE = 2 AND  ");
		if (type == 1) {
			sb.append(" BOOKING_NO = ? ");
		} else if (type == 2) {
			sb.append(" CONTAINER_NO = ? ");
		} else if (type == 3) {
			sb.append(" JOB_NO = ? ");
		} else if (type == 4) {
			sb.append(" MBL_NO = ? ");
		} else if (type == 5) {
			sb.append(" HBL_NO_OTHERS = ? ");
		} else if (type == 6) {
			sb.append(" SHIPPING_BILL_NO = ? ");
		}
		
		try {
			return jdbcTemplateObject.query(sb.toString(), new Object[] { transactionId }, new TraceDetailMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Track data  in system");
			return null;
		}
	}

}
