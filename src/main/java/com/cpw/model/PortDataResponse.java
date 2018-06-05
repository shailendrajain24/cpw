package com.cpw.model;

public class PortDataResponse {

	private long portId;
	private String cityName;
	private String cityCode;
	//private String countryName;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	/*public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}*/
	public long getPortId() {
		return portId;
	}
	public void setPortId(long portId) {
		this.portId = portId;
	}
	
}
