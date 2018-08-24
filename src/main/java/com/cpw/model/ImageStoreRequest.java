package com.cpw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ImageStoreRequest {
	
	private long imageId;
	private byte[] bytes;
	
	
	@JsonCreator
	public ImageStoreRequest(@JsonProperty("imageId")long imageId,@JsonProperty("bytes")byte[] bytes)
	{
		//this.id=id;
		this.imageId=imageId;
		this.bytes=bytes;
		
	}

	
	

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
	
	
	
	

}
