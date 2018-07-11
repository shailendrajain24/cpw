package com.cpw.model;

public class ScheduleSearchRequest {

	private int vesselId;
	private int podId;
	private int polId;
	private String FromETD;
	private String ToETD; 
	private String FromETA; 
	private String ToETA;
	public int getVesselId() {
		return vesselId;
	}
	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}
	public int getPodId() {
		return podId;
	}
	public void setPodId(int podId) {
		this.podId = podId;
	}
	public int getPolId() {
		return polId;
	}
	public void setPolId(int polId) {
		this.polId = polId;
	}
	public String getFromETD() {
		return FromETD;
	}
	public void setFromETD(String fromETD) {
		FromETD = fromETD;
	}
	public String getToETD() {
		return ToETD;
	}
	public void setToETD(String toETD) {
		ToETD = toETD;
	}
	public String getFromETA() {
		return FromETA;
	}
	public void setFromETA(String fromETA) {
		FromETA = fromETA;
	}
	public String getToETA() {
		return ToETA;
	}
	public void setToETA(String toETA) {
		ToETA = toETA;
	} 
}
