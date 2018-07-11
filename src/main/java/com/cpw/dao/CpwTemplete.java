package com.cpw.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public interface CpwTemplete<T> {

	public List<T> getRecordList(String sql, JdbcTemplate jdbcTemplate, RowMapper<T> mapper);

	public int upsert(String sql, Object [] values, JdbcTemplate jdbcTemplate);
	
	//public int update();
}
