package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.Rating;

public class RatingMapper implements RowMapper<Rating> {

	public Rating mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		final Rating rating = new Rating();
		rating.setRatingName(resultSet.getString("NAME"));
		rating.setId(resultSet.getInt("ID"));
		return rating;
	}

}
