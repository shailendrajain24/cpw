/**
 * 
 */
package com.cpw.model;

/**
 * @author Unknown
 *
 */
public class TaskDataResponse {
	private long taskId;
	private String subject;
	private String dueDate;
	private String contact;
	private String account;
	private String status;
	private String priority;
	private String sendNotificationEmail;
	private String reminder;
	private String repeat;
	private String description;

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSendNotificationEmail() {
		return sendNotificationEmail;
	}

	public void setSendNotificationEmail(String sendNotificationEmail) {
		this.sendNotificationEmail = sendNotificationEmail;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
