/**
 * 
 */
package com.cpw.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * @author Unknown
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesBudgetRequest {
	private long id;
	private String budgetNumber;
	private String year;
	private int budgetType;
	private long salesmanId;
	private long sectorId;
	private int currencyId;
	private double roe;
	private String fileName;
	private String note;
	private long locId;
	private long fyId;
	private long fyPrdId;
	private long createdBy;
	@JsonSerialize(using = DateSerializer.class)
	private Date createdDate;
	private String createdTime;
	private long modifyBy;
	@JsonSerialize(using = DateSerializer.class)
	private Date modifyDate;
	private String modifyTime;

	@JsonCreator
	public SalesBudgetRequest(@JsonProperty("id") long id, @JsonProperty("budgetNumber") String budgetNumber,
			@JsonProperty("year") String year, @JsonProperty("budgetType") int budgetType,
			@JsonProperty("salesmanId") long salesmanId, @JsonProperty("sectorId") long sectorId,
			@JsonProperty("currencyId") int currencyId, @JsonProperty("roe") Double roe,
			@JsonProperty("fileName") String fileName, @JsonProperty("note") String note,
			@JsonProperty("locId") long locId, @JsonProperty("fyId") long fyId, @JsonProperty("fyPrdId") long fyPrdId,
			@JsonProperty("createdBy") long createdBy, @JsonProperty("createdDate") Date createdDate,
			@JsonProperty("createdTime") String createdTime, @JsonProperty("modifyBy") long modifyBy,
			@JsonProperty("modifyDate") Date modifyDate, @JsonProperty("modifyTime") String modifyTime) {
		this.id = id;
		this.budgetNumber = budgetNumber;
		this.year = year;
		this.budgetType = budgetType;
		this.salesmanId = salesmanId;
		this.sectorId = sectorId;
		this.currencyId = currencyId;
		this.fileName = fileName;
		this.note = note;
		this.locId = locId;
		this.fyId = fyId;
		this.fyPrdId = fyPrdId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.createdTime = createdTime;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.modifyTime = modifyTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBudgetNumber() {
		return budgetNumber;
	}

	public void setBudgetNumber(String budgetNumber) {
		this.budgetNumber = budgetNumber;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getBudgetType() {
		return budgetType;
	}

	public void setBudgetType(int budgetType) {
		this.budgetType = budgetType;
	}

	public long getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(long salesmanId) {
		this.salesmanId = salesmanId;
	}

	public long getSectorId() {
		return sectorId;
	}

	public void setSectorId(long sectorId) {
		this.sectorId = sectorId;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public double getRoe() {
		return roe;
	}

	public void setRoe(double roe) {
		this.roe = roe;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getLocId() {
		return locId;
	}

	public void setLocId(long locId) {
		this.locId = locId;
	}

	public long getFyId() {
		return fyId;
	}

	public void setFyId(long fyId) {
		this.fyId = fyId;
	}

	public long getFyPrdId() {
		return fyPrdId;
	}

	public void setFyPrdId(long fyPrdId) {
		this.fyPrdId = fyPrdId;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
