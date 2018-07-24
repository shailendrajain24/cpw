/**
 * 
 */
package com.cpw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.TaskData;
import com.cpw.model.TaskDataResponse;
import com.cpw.services.TaskImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class TaskController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/tasks/{taskId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends TaskDataResponse>> taskList(@PathVariable("taskId") long taskId) {
		logger.debug("Entering into task list");
		try {
			TaskImpl taskImpl = new TaskImpl();
			List<TaskDataResponse> taskDateResponse = taskImpl.taskList(taskId);
			if (taskDateResponse == null || taskDateResponse.isEmpty()) {
				return new ResponseEntity<List<? extends TaskDataResponse>>(taskDateResponse, HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<? extends TaskDataResponse>>(taskDateResponse, HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<? extends TaskDataResponse>>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/removeTask/{taskId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> removeTask(@PathVariable("taskId") long taskId) {
		logger.debug("Entering into removeTask");
		try {
			TaskImpl taskImpl = new TaskImpl();
			int response = taskImpl.removeTask(taskId);
			if (response > 0) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> upsertTask(@RequestBody TaskData request) {

		logger.debug("Entering into addTask");
		try {
			if (request.getTaskId() == 0) {
				return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
			}
			logger.debug("Task Id : " + request.getTaskId());
			TaskImpl taskImpl = new TaskImpl();
			int response = taskImpl.upsertTask(request);
			if (response > 0) {
				return new ResponseEntity<Object>(HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_ACCEPTABLE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
