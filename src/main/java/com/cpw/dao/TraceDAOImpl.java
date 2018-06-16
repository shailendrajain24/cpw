package com.cpw.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.TraceDetailMapper;
import com.cpw.jdbc.model.Trace;

public class TraceDAOImpl implements TraceDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public Trace traceDetail(String transactionId, int type) {
		logger.debug("Entering into trackingDetail");
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT A.CFS_RECEIVED_ID, A.SRL_NO, A.BOOKING_ID,A.JOB_ID, A.SHIPPING_BILL_NO, A.SHIPPING_BILL_DATE,A.CARTING_DATE,A.CUSTOMS_CLEARANCE_DATE,"
						+ "B.CFS_RECEIVED_ID AS HDR_CFS_RECEIVED_ID,B.RECEIPT_NO,B.RECEIPT_DATE,B.POL_CODE AS CFS_POL_CODE,B.POD_CODE AS CFS_POD_CODE,B.FDC_CODE AS CFS_FDC_CODE,B.STATUS,"
						+ "C.BOOKING_ID AS BOOKING_HDR_ID,C.BOOKING_NO,C.BOOKING_DATE,C.POL_CODE AS BOOKING_POL_CODE,C.POD_CODE AS BOOKING_POD_CODE,C.FDC_CODE AS BOOKING_FDC_CODE,"
						+ "C.MBL_NO,C.JOB_ID AS BOOK_JOB_ID,C.HBL_NO_OTHERS,"
						+ "D.JOB_ID AS JOB_HDR_ID,D.JOB_NO,D.POL_CODE AS JOB_POL_CODE,D.FDC_CODE AS JOB_FDC_CODE,D.POD_CODE AS JOB_POD_CODE,D.SOB_DATE,D.CREATED_DATE,"
						+ "E.CLP_ID,E.CLP_HDR_ID,E.CLP_HDR_SRL_NO,E.CLP_DTL_ID,E.CLP_DTL_SRL_NO,E.GR_WT,E.VOLUME,E.CLP_TYPE,"
						+ "F.PROCURMENT_ID,F.SERIAL_NO,F.CONTAINER_NO " + "FROM CFS_RECEIVED_DTL A "
						+ " INNER JOIN CFS_RECEIVED_HDR B(NOLOCK) ON B.CFS_RECEIVED_ID = A.CFS_RECEIVED_ID "
						+ " LEFT JOIN BOOKING_HDR C (NOLOCK) ON C.BOOKING_ID = A.BOOKING_ID "
						+ " LEFT JOIN JOB_HDR D (NOLOCK) ON D.JOB_ID = C.JOB_ID "
						+ " LEFT JOIN CLP_DTL E (NOLOCK) ON E.CLP_DTL_ID = A.CFS_RECEIVED_ID AND E.CLP_DTL_SRL_NO = A.SRL_NO AND E.CLP_TYPE = 2 "
						+ " LEFT JOIN PROCUREMENT_DTL F (NOLOCK) ON F.PROCURMENT_ID = E.CLP_HDR_ID AND F.SERIAL_NO = E.CLP_HDR_SRL_NO WHERE ");
		if (type == 1) {
			sb.append(" C.BOOKING_NO = ? ");
		} else if (type == 2) {
			sb.append(" F.CONTAINER_NO = ? ");
		} else if (type == 3) {
			sb.append(" D.JOB_NO = ? ");
		} else if (type == 4) {
			sb.append(" C.MBL_NO = ? ");
		} else if (type == 5) {
			sb.append(" C.HBL_NO_OTHERS = ? ");
		} else if (type == 6) {
			sb.append(" A.SHIPPING_BILL_NO = ? ");
		}
		try {
			Trace trackingDetail = jdbcTemplateObject.queryForObject(sb.toString(), new Object[] { transactionId },
					new TraceDetailMapper());
			return trackingDetail;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Track data  in system");
			return null;
		}
	}

}
