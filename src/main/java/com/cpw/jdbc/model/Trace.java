package com.cpw.jdbc.model;

import java.util.Date;

public class Trace {
	private String cfsReceivedId;
	private String slrNumber;
	private String bookingId;
	private String jobId;
	private String shippingBillNumber;
	private Date shippingBillDate;
	private Date cartingDate;
	private Date customerClearanceDate;
	private String hdrCfsReceivedId;
	private String receiptNumber;
	private Date receiptDate;
	private String cfsPolCode;
	private String cfsPodCode;
	private String cfsFdcCode;
	private int status;
	public String getCfsReceivedId() {
		return cfsReceivedId;
	}
	public void setCfsReceivedId(String cfsReceivedId) {
		this.cfsReceivedId = cfsReceivedId;
	}
	public String getSlrNumber() {
		return slrNumber;
	}
	public void setSlrNumber(String slrNumber) {
		this.slrNumber = slrNumber;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getShippingBillNumber() {
		return shippingBillNumber;
	}
	public void setShippingBillNumber(String shippingBillNumber) {
		this.shippingBillNumber = shippingBillNumber;
	}
	public Date getShippingBillDate() {
		return shippingBillDate;
	}
	public void setShippingBillDate(Date shippingBillDate) {
		this.shippingBillDate = shippingBillDate;
	}
	public Date getCartingDate() {
		return cartingDate;
	}
	public void setCartingDate(Date cartingDate) {
		this.cartingDate = cartingDate;
	}
	public Date getCustomerClearanceDate() {
		return customerClearanceDate;
	}
	public void setCustomerClearanceDate(Date customerClearanceDate) {
		this.customerClearanceDate = customerClearanceDate;
	}
	public String getHdrCfsReceivedId() {
		return hdrCfsReceivedId;
	}
	public void setHdrCfsReceivedId(String hdrCfsReceivedId) {
		this.hdrCfsReceivedId = hdrCfsReceivedId;
	}
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public String getCfsPolCode() {
		return cfsPolCode;
	}
	public void setCfsPolCode(String cfsPolCode) {
		this.cfsPolCode = cfsPolCode;
	}
	public String getCfsPodCode() {
		return cfsPodCode;
	}
	public void setCfsPodCode(String cfsPodCode) {
		this.cfsPodCode = cfsPodCode;
	}
	public String getCfsFdcCode() {
		return cfsFdcCode;
	}
	public void setCfsFdcCode(String cfsFdcCode) {
		this.cfsFdcCode = cfsFdcCode;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
}
