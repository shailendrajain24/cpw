package com.cpw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddAccountRequest {
	private long id;
	private String accountOwner;
	private String rating;
	private String accountName;
	private String phone;
	private String accountSite;
	private String fax;
	private long parentAccountId;
	private String parentAccount;
	private String webSite;
	private int accountNumber;
	private String tickerSymbol;
	private String accountType;
	private String ownerShip;
	private String industry;
	private int employees;
	private String annualRevenue;
	private String sicCode;
	private String billingAddressStreet;
	private String billingAddressCity;
	private String billingAddressState;
	private String billingAddressCode;
	private String billingAddressCountry;
	private String shippingAddressStreet;
	private String shippingAddressCity;
	private String shippingAddressState;
	private String shippingAddressCode;
	private String shippingAddressCountry;
	private String description;
	private String createdBy;
	private long createdTime;
	private String modifyBy;
	private long modifyTime;

	@JsonCreator
	public AddAccountRequest(@JsonProperty("id")long id,@JsonProperty("accountOwner")String accountOwner,
			@JsonProperty("rating")String rating,@JsonProperty("accountName") String accountName,
			@JsonProperty("phone")String phone,@JsonProperty("accountSite")String accountSite,
			@JsonProperty("fax")String fax,@JsonProperty("parentAccount")String parentAccount,
			@JsonProperty("webSite")String webSite,@JsonProperty("accountNumber")int acaccountNumber,
			@JsonProperty("tickerSymbol")String tickerSymbol,@JsonProperty("accountType")String accountType,
			@JsonProperty("ownerShip")String ownerShip,@JsonProperty("indusrty")String indusrty,
			@JsonProperty("employees")int employees,@JsonProperty("annualRevenue")String annualRevenue,
			@JsonProperty("sicCode")String sicCode,@JsonProperty("billingAddressStreet")String billingAddressStreet,
			@JsonProperty("billingAddressCity")String billingAddressCity,@JsonProperty("billingAddressState")String billingAddressState,
			@JsonProperty("billingAddressCode")String billingAddressCode,
			@JsonProperty("billingAddressCountry")String billingAddressCountry,@JsonProperty("shippingAddressStreet")String shippingAddressStreet,
			@JsonProperty("shippingAddressCity")String shippingAddressCity,
			@JsonProperty("shippingAddressState")String shippingAddressState,@JsonProperty("shippingAddressCode")String shippingAddressCode,
			@JsonProperty("shippingAddressCountry")String shippingAddressCountry,@JsonProperty("description")String description,
			@JsonProperty("createdBy")String createdBy,@JsonProperty("createdTime")long createdTime,@JsonProperty("modifyBy")String modifyBy,
			@JsonProperty("modifyTime")long modifyTime,@JsonProperty("parentAccountId")long parentAccountId)
	{

		this.id=id;
		this.accountOwner=accountOwner;
		this.rating=rating;
		this.accountName=accountName;
		this.phone=phone;
		this.accountSite=accountSite;
		this.fax=fax;
		this.parentAccountId=parentAccountId;
		this.parentAccount=parentAccount;
		this.webSite=webSite;
		this.accountNumber=acaccountNumber;
		this.tickerSymbol=tickerSymbol;
		this.accountType=accountType;
		this.ownerShip=ownerShip;
		this.industry=indusrty;
		this.employees=employees;
		this.annualRevenue=annualRevenue;
		this.sicCode=sicCode;
		this.billingAddressStreet=billingAddressStreet;
		this.billingAddressCity=billingAddressCity;
		this.billingAddressState=billingAddressState;
		this.billingAddressCode=billingAddressCode;
		this.billingAddressCountry=billingAddressCountry;
		this.shippingAddressStreet=shippingAddressStreet;
		this.shippingAddressCity=shippingAddressCity;
		this.shippingAddressState=shippingAddressState;
		this.shippingAddressCode=shippingAddressCode;
		this.shippingAddressCountry=shippingAddressCountry;
		this.description=description;
		this.createdBy=createdBy;
		this.createdTime=createdTime;
		this.modifyBy=modifyBy;
		this.modifyTime=modifyTime;




	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountSite() {
		return accountSite;
	}

	public void setAccountSite(String accountSite) {
		this.accountSite = accountSite;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public long getParentAccountId() {
		return parentAccountId;
	}

	public void setParentAccountId(long parentAccountId) {
		this.parentAccountId = parentAccountId;
	}

	public String getParentAccount() {
		return parentAccount;
	}

	public void setParentAccount(String parentAccount) {
		this.parentAccount = parentAccount;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getOwnerShip() {
		return ownerShip;
	}

	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}

	public String getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public String getSicCode() {
		return sicCode;
	}

	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}

	public String getBillingAddressStreet() {
		return billingAddressStreet;
	}

	public void setBillingAddressStreet(String billingAddressStreet) {
		this.billingAddressStreet = billingAddressStreet;
	}

	public String getBillingAddressCity() {
		return billingAddressCity;
	}

	public void setBillingAddressCity(String billingAddressCity) {
		this.billingAddressCity = billingAddressCity;
	}

	public String getBillingAddressState() {
		return billingAddressState;
	}

	public void setBillingAddressState(String billingAddressState) {
		this.billingAddressState = billingAddressState;
	}

	public String getBillingAddressCode() {
		return billingAddressCode;
	}

	public void setBillingAddressCode(String billingAddressCode) {
		this.billingAddressCode = billingAddressCode;
	}

	public String getBillingAddressCountry() {
		return billingAddressCountry;
	}

	public void setBillingAddressCountry(String billingAddressCountry) {
		this.billingAddressCountry = billingAddressCountry;
	}

	public String getShippingAddressStreet() {
		return shippingAddressStreet;
	}

	public void setShippingAddressStreet(String shippingAddressStreet) {
		this.shippingAddressStreet = shippingAddressStreet;
	}

	public String getShippingAddressCity() {
		return shippingAddressCity;
	}

	public void setShippingAddressCity(String shippingAddressCity) {
		this.shippingAddressCity = shippingAddressCity;
	}

	public String getShippingAddressState() {
		return shippingAddressState;
	}

	public void setShippingAddressState(String shippingAddressState) {
		this.shippingAddressState = shippingAddressState;
	}

	public String getShippingAddressCode() {
		return shippingAddressCode;
	}

	public void setShippingAddressCode(String shippingAddressCode) {
		this.shippingAddressCode = shippingAddressCode;
	}

	public String getShippingAddressCountry() {
		return shippingAddressCountry;
	}

	public void setShippingAddressCountry(String shippingAddressCountry) {
		this.shippingAddressCountry = shippingAddressCountry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(long modifyTime) {
		this.modifyTime = modifyTime;
	}


}

