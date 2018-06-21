/**
 * 
 */
package com.cpw.jdbc.model;


/**
 * @author Unknown
 *
 */
public class SalesBudget {
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
	private String createdDate;
	private String createdTime;
	private long modifyBy;
	private String modifyDate;
	private String modifyTime;

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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
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

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
