package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.TraceDetailMapper;
import com.cpw.dao.mapper.TrackingHeaderMapper;
import com.cpw.jdbc.model.Trace;
import com.cpw.jdbc.model.TrackingHeader;

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
				+ " FROM vl_TRACKING A WHERE  ");
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

	@Override
	public TrackingHeader headerDetail(String transactionId, int type) {
		logger.debug("Entering into Tracking Header");
		StringBuilder sb = new StringBuilder();
				sb.append("SELECT distinct X.POL_CODE,X.POD_CODE,X.ETD,X.ETA,"  
						+"case when A.STATUS=1                             then 'Planning'"
						+"when A.STATUS=2                             then 'Carted'"
						+"when A.STATUS=3                             then 'Received'"
						+"when A.STATUS=4                             then 'Booked'"
						+"when A.STATUS=5                             then 'Stuffed'"
						+"when A.STATUS=6                             then 'Cancel'"
						+"when A.STATUS=7                             then 'Loaded'"
						+"when A.STATUS=8                             then 'Generated'"
						+"when A.STATUS=9                             then 'Merge' "
						+"else'' end as CURRENCT_STATUS FROM  CFS_RECEIVED_DTL A INNER JOIN CFS_RECEIVED_HDR B(nolock) ON B.CFS_RECEIVED_ID = A.CFS_RECEIVED_ID "
						+"INNER JOIN SAILING_SCHEDULE_DTL X(nolock) on B.SCHEDULE_ID=X.SCHEDULE_UID "  
						+"left JOIN BOOKING_HDR C (nolock) ON C.BOOKING_ID = A.BOOKING_ID  "   
						+"left JOIN JOB_HDR D (nolock) ON D.JOB_ID = C.JOB_ID  "  
						+"LEFT JOIN CLP_DTL E (nolock) ON E.CLP_DTL_ID = A.CFS_RECEIVED_ID AND "  
						+"E.CLP_DTL_SRL_NO = A.SRL_NO AND E.CLP_TYPE =  2   " 
						+"LEFT JOIN PROCUREMENT_DTL F (nolock) ON F.PROCURMENT_ID = E.CLP_HDR_ID AND   "
						+"F.SERIAL_NO = E.CLP_HDR_SRL_NO WHERE");
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
				
				List<TrackingHeader> trackingHeaderList=jdbcTemplateObject.query(sb.toString(), new Object[]{transactionId}, new TrackingHeaderMapper());
				return trackingHeaderList.get(0);
			}
			

	

	
}
