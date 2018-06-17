package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.PendingInvoicesDetailMapper;
import com.cpw.jdbc.model.PendingInvoicesDetail;

public class PendingInvoiceDetailDAOImpl implements PendingInvoiceDetailDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<PendingInvoicesDetail> pendingInvoiceList(String userName) {
		logger.debug("Entering into pendingInvoiceList");
		final String trackingSql = "Select A.Booking_ID, A.BOOKING_NO, B.DUE_DATE, B.IV_NO, B.LOCAL_AMOUNT"
				+ " from  BOOKING_HDR A INNER JOIN IV_HDR B" + " ON A.BOOKING_ID=B.BOOKING_ID" + " LEFT JOIN RV_HDR C"
				+ " On A.BOOKING_ID=C.BOOKING_ID"
				+ " WHERE A.BILLING_CUST_ID=(SELECT EMP_ID FROM USERS WHERE USER_NAME = ?) AND C.BOOKING_ID IS NULL";
		try {
			return jdbcTemplateObject.query(trackingSql, new Object[] { userName }, new PendingInvoicesDetailMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Pending Invoice in system");
			return null;
		}
	}

}
