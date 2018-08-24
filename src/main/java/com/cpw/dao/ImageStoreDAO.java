package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.ImageStore;

public interface ImageStoreDAO {
	public void setDataSource(DataSource ds);
	
	public List<ImageStore> readImage(long imageId);
	
	public String writeImage(ImageStore imageStore);

}
