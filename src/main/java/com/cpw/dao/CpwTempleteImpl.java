package com.cpw.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CpwTempleteImpl<T> implements CpwTemplete<T>{

	@Override
	public List<T> getRecordList(String sql, JdbcTemplate jdbcTemplate, RowMapper<T> mapper) {
		return jdbcTemplate.query(sql, mapper);
	}
	
	@Override
	public int upsert(String sql, Object [] values, JdbcTemplate jdbcTemplate) {
		return jdbcTemplate.update(sql, values);
		
	}

}
