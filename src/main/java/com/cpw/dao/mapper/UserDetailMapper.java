package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.UserDetail;

public class UserDetailMapper implements RowMapper<UserDetail> {

	public UserDetail mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final UserDetail userDetail = new UserDetail();
		userDetail.setUserId(resultSet.getLong("USER_ID"));
		userDetail.setUserName(resultSet.getString("USER_NAME"));
		userDetail.setStatus(resultSet.getString("STATUS"));
		userDetail.setPassword(resultSet.getString("PASSWORD"));
		userDetail.setEmployIdentifier(resultSet.getLong("EMP_ID"));
		userDetail.setLockId(resultSet.getInt("LOC_ID"));
		//userDetail.setPasswordExpiryDate(resultSet.getDate("PASSWORD_EXPIRY").toString());
		//userDetail.setPasswordExpiryTime(resultSet.getTime("PASSWORD_EXPIRY_TIME").toString());
		userDetail.setAccountLockAttempts(resultSet.getInt("LOCK_ATTEMPTS"));
		userDetail.setAccountLockDuration(resultSet.getString("LOCK_DURATION"));
		userDetail.setMaximumLogin(resultSet.getString("MAX_LOGIN"));
		userDetail.setIpAddress(resultSet.getString("IP_ADDRESS"));
		userDetail.setRemark(resultSet.getString("REMARK"));
		userDetail.setDeleted(resultSet.getString("IS_DELETED"));
		userDetail.setCreateBy(resultSet.getInt("CR_BY"));
		//userDetail.setCreateDate(resultSet.getDate("CR_DATE").toString());
		//userDetail.setCreateTime(resultSet.getTime("CR_TIME").toString());
		userDetail.setModifyBy(resultSet.getInt("MD_BY"));
		//userDetail.setModifyDate(resultSet.getDate("MD_DATE").toString());
		//userDetail.setModifyTime(resultSet.getTime("MD_TIME").toString());
		userDetail.setUserType(resultSet.getString("USER_TYPE"));
		userDetail.setActive(resultSet.getString("IS_ACTIVE"));
		userDetail.setAllAccess(resultSet.getString("IS_ALL_ACCESS"));
		return userDetail;
	}

}
