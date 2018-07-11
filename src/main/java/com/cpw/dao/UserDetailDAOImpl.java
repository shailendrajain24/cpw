package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.UserDetailMapper;
import com.cpw.dao.mapper.UserRoleMapper;
import com.cpw.jdbc.model.UserDetail;
import com.cpw.jdbc.model.UserRole;

public class UserDetailDAOImpl implements UserDetailDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void createUser(UserDetail userDetail) {

	}

	public UserDetail getUserDetail(String id) {
		logger.debug("Entering into getUserDetail");
		logger.debug("User Name is : " + id);
		String sql = "SELECT * FROM USERS WHERE USER_NAME = ?";
		try {
			UserDetail userDetail = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new UserDetailMapper());
			return userDetail;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No record found for user" + id);
			return null;
		}

	}

	public UserRole getUserRole(long id) {
		logger.debug("Entering into getUserRole");
		logger.debug("User Id is : " + id);
		String userRoleSql = "SELECT * FROM USER_ROLES WHERE USER_ID = ?";
		try {

			UserRole userRole = jdbcTemplateObject.queryForObject(userRoleSql, new Object[] { id },
					new UserRoleMapper());
			return userRole;
		} catch (EmptyResultDataAccessException e) {
			logger.error("No Role define for " + id + " in system");
			return null;
		}

	}

	public List<UserDetail> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(UserDetail userDetail) {
		// TODO Auto-generated method stub

	}

}
