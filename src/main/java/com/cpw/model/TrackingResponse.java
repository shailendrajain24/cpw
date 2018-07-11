package com.cpw.model;

public class TrackingResponse {

	private String trackType;
	private int minLength;
	private int maxLength;
	private String type;
	private String startWith;
	private String startWithLength;
	private int trackingId;
	public String getTrackType() {
		return trackType;
	}
	public void setTrackType(String trackType) {
		this.trackType = trackType;
	}
	public int getMinLength() {
		return minLength;
	}
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStartWith() {
		return startWith;
	}
	public void setStartWith(String startWith) {
		this.startWith = startWith;
	}
	public String getStartWithLength() {
		return startWithLength;
	}
	public void setStartWithLength(String startWithLength) {
		this.startWithLength = startWithLength;
	}
	public int getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}
}
