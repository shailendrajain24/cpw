package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Rating;

public interface RatingDAO {

	public void setDataSource(DataSource ds);

	public List<Rating> ratingList();

}
