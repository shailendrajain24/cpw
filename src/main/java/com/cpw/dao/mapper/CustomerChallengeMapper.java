package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.CustomerChallenge;

public class CustomerChallengeMapper implements RowMapper<CustomerChallenge> {

	public CustomerChallenge mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final CustomerChallenge customerChallenge = new CustomerChallenge();
		customerChallenge.setId(resultSet.getLong("CUSTOMER_CHALLENGE_ID"));
		customerChallenge.setCode(resultSet.getString("CODE"));
		customerChallenge.setCustomerId(resultSet.getLong("CUSTOMER_ID"));
		customerChallenge.setContactId(resultSet.getLong("CONTACT_ID"));
		customerChallenge.setLogDate(resultSet.getString("LOG_DATE"));
		customerChallenge.setStatus(resultSet.getInt("STATUS"));
		customerChallenge.setPriority(resultSet.getLong("PRIORITY"));
		customerChallenge.setOrigin(resultSet.getInt("ORIGIN"));
		customerChallenge.setTypeId(resultSet.getInt("TYPE_ID"));
		customerChallenge.setReason(resultSet.getString("REASON"));
		customerChallenge.setDueDate(resultSet.getString("DUE_DATE"));
		customerChallenge.setInchargeId(resultSet.getLong("INCHARGE_ID"));
		customerChallenge.setCcEmail(resultSet.getString("CC_MAIL"));
		customerChallenge.setSubject(resultSet.getString("SUBJECT"));
		customerChallenge.setDescription(resultSet.getString("DESCRIPTION"));
		customerChallenge.setInternalNote(resultSet.getString("INTERNAL_NOTE"));
		customerChallenge.setCustomerFeedback(resultSet.getString("CUSTOMER_FEEDBACK"));
		customerChallenge.setCloseDate(resultSet.getString("CLOSED_DATE"));
		customerChallenge.setNote(resultSet.getString("NOTE"));
		customerChallenge.setLocId(resultSet.getLong("LOC_ID"));
		customerChallenge.setFyId(resultSet.getLong("FY_ID"));
		customerChallenge.setTime(resultSet.getLong("CREATED_TIME"));
		customerChallenge.setIsDeleted(resultSet.getInt("IS_DELETED"));
		customerChallenge.setCreatedBy(resultSet.getLong("CR_BY"));
		customerChallenge.setCreatedDate(resultSet.getString("CR_DATE"));
		customerChallenge.setCreatedTime(resultSet.getString("CR_TIME"));
		customerChallenge.setModifyBy(resultSet.getLong("MD_BY"));
		customerChallenge.setModifyDate(resultSet.getString("MD_DATE"));
		customerChallenge.setModifyTime(resultSet.getString("MD_TIME"));
		return customerChallenge;
	}

}
