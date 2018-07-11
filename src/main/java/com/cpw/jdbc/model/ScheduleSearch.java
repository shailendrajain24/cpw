package com.cpw.jdbc.model;

import java.util.Date;

public class ScheduleSearch {

	//private int vesselId;
	private int podId;
	private int polId;
	private Date etd;
	private Date eta;
	//private Date FromETA;
	//private Date ToETA;
	private String vesselName;
	private String podCode;
	private String polCode;

	/*public int getVesselId() {
		return vesselId;
	}

	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}*/

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

	public Date getEtd() {
		return etd;
	}

	public void setEtd(Date etd) {
		this.etd = etd;
	}

	public Date geteta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	/*public Date getFromETA() {
		return FromETA;
	}

	public void setFromETA(Date fromETA) {
		FromETA = fromETA;
	}

	public Date getToETA() {
		return ToETA;
	}

	public void setToETA(Date toETA) {
		ToETA = toETA;
	}*/

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getPodCode() {
		return podCode;
	}

	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}

	public String getPolCode() {
		return polCode;
	}

	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}

	public Date getEta() {
		return eta;
	}
}
