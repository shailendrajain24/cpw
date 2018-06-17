package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.UserRole;

public class UserRoleMapper implements RowMapper<UserRole> {

	public UserRole mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final UserRole userRole = new UserRole();
		userRole.setUserId(resultSet.getLong("USER_ID"));
		userRole.setRoleId(resultSet.getLong("ROLE_ID"));
		userRole.setDescription(resultSet.getString("DESCRIPTION"));
		userRole.setCreateBy(resultSet.getInt("CREATED_BY"));
		//userDetail.setCreateDate(resultSet.getDate("CREATED_DATE").toString());
		//userDetail.setCreateTime(resultSet.getTime("CREATED_TIME").toString());
		userRole.setModifyBy(resultSet.getInt("MODIFIED_BY"));
		//userDetail.setModifyDate(resultSet.getDate("MODIFIED_DATE").toString());
		//userDetail.setModifyTime(resultSet.getTime("MODIFIED_TIME").toString());
		userRole.setRemark(resultSet.getString("REMARK"));
		userRole.setDeleted(resultSet.getString("IS_DELETED"));
		return userRole;
	}

}
