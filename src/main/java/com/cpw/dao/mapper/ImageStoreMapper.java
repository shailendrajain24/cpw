package com.cpw.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cpw.jdbc.model.ImageStore;

public class ImageStoreMapper implements RowMapper<ImageStore>{

	@Override
	public ImageStore mapRow(ResultSet rs, int rowNum) throws SQLException {
	final ImageStore imageStore=new ImageStore();

		imageStore.setImageId(rs.getLong("IMAGE_ID"));
		imageStore.setImageUrl(rs.getString("IMAGE_URL"));
		
		return imageStore;
	}

}
