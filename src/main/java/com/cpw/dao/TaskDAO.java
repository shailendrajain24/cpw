package com.cpw.dao;

import java.util.List;

import javax.sql.DataSource;

import com.cpw.jdbc.model.Task;

public interface TaskDAO {

	public void setDataSource(DataSource ds);

	public int upsertTask(Task task);

	public List<Task> taskList(long createdBy);
	
	public int removeTask(long taskId);
}
