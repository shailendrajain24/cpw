package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cpw.dao.mapper.TaskMapper;
import com.cpw.jdbc.model.Task;

public class TaskDAOImpl implements TaskDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Task> taskList(long taskId) {
		logger.debug("Entering into taskList with taskId " + taskId);
		final String taskListSql = "Select TASK_ID, SUBJECT, DUE_DATE, CONTACT, ACCOUNT, STATUS, PRIORITY, SEND_NOTIFICATION_EMAIL,"
				+ "REMINDER, REPEAT, DESCRIPTION FROM  TASK  WHERE TASK_ID = ?";
		try {
			List<Task> taskList = jdbcTemplateObject.query(taskListSql, new Object[] { taskId }, new TaskMapper());
			return taskList;
		}  catch (EmptyResultDataAccessException e) {
			logger.error("No taskList in system");
			return null;
		}
	}

	@Override
	public int upsertTask(Task taskRequest) {
		logger.debug("Entering into Task DAO");
		CpwTemplete<Task> cpwTemplete = new CpwTempleteImpl<Task>();
		String requestedRecord = "select * from task where task_id=?";
		Task taskInSystem = null;
		try {
			taskInSystem = jdbcTemplateObject.queryForObject(requestedRecord, new Object[] { taskRequest.getTaskId() },
					new TaskMapper());
		} catch (EmptyResultDataAccessException e) {
			taskInSystem = null;
		}
		try {
			int count = -1;
			logger.debug("Task ID" + taskRequest.getTaskId());
			if (taskInSystem != null && taskInSystem.getTaskId() == taskRequest.getTaskId()) {
				String updateSql = "UPDATE TASK SET ACCOUNT=?, CONTACT=?, DESCRIPTION=?, DUE_DATE=?, PRIORITY=?,"
						+ " REMINDER=?, REPEAT=?, SEND_NOTIFICATION_EMAIL=?, STATUS=?, SUBJECT=?" + " WHERE TASK_ID=?";
				return jdbcTemplateObject.update(updateSql,
						taskRequest.getAccount() == null ? taskInSystem.getAccount() : taskRequest.getAccount(),
						taskRequest.getContact() == null ? taskInSystem.getContact() : taskRequest.getContact(),
						taskRequest.getDescription() == null ? taskInSystem.getDescription()
								: taskRequest.getDescription(),
						taskRequest.getDueDate() == null ? taskInSystem.getDueDate() : taskRequest.getDueDate(),
						taskRequest.getPriority() == null ? taskInSystem.getPriority() : taskRequest.getPriority(),
						taskRequest.getReminder() == null ? taskInSystem.getReminder() : taskRequest.getReminder(),
						taskRequest.getRepeat() == null ? taskInSystem.getRepeat() : taskRequest.getRepeat(),
						taskRequest.getSendNotificationEmail() == null ? taskInSystem.getSendNotificationEmail()
								: taskRequest.getSendNotificationEmail(),
						taskRequest.getStatus() == null ? taskInSystem.getStatus() : taskRequest.getStatus(),
						taskRequest.getSubject() == null ? taskInSystem.getSubject() : taskRequest.getSubject(),
						taskRequest.getTaskId());
			} else {
				Object[] values = new Object[11];
				values[0] = taskRequest.getAccount();
				values[1] = taskRequest.getContact();
				values[2] = taskRequest.getDescription();
				values[3] = taskRequest.getDueDate();
				values[4] = taskRequest.getPriority();
				values[5] = taskRequest.getReminder();
				values[6] = taskRequest.getRepeat();
				values[7] = taskRequest.getSendNotificationEmail();
				values[8] = taskRequest.getStatus();
				values[9] = taskRequest.getSubject();
				values[10] = taskRequest.getTaskId();
				String insertSql = "INSERT INTO TASK (ACCOUNT, CONTACT, DESCRIPTION, DUE_DATE, PRIORITY, REMINDER, REPEAT, SEND_NOTIFICATION_EMAIL, STATUS, SUBJECT, TASK_ID)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				count = cpwTemplete.upsert(insertSql, values, jdbcTemplateObject);
				logger.debug("Record creation status: " + count);
			}
			logger.debug("Before Calling upsert");

			return count;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int removeTask(long taskId) {
		logger.debug("Entering into remove Task");
		final String deleteTaskSql = "DELETE FROM TASK WHERE TASK_ID = ?";
		try {
			return jdbcTemplateObject.update(deleteTaskSql, taskId);
		} catch (DataAccessException e) {
			logger.error("No Task available in system coresponding to task id: " + taskId);
			return 0;
		}

	}

}
