package com.cpw.jdbc.model;

import java.util.Arrays;

public class ImageStore {

	private long imageId;
	private String imageUrl;


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	private byte[] bytes;

	
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	@Override
	public String toString() {
		return "ImageStore [imageId=" + imageId + ", imageUrl=" + imageUrl + ", bytes=" + Arrays.toString(bytes) + "]";
	}
	
	

}
