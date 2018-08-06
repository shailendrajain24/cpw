package com.cpw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.StageResponse;
import com.cpw.services.StageImpl;

@RestController
public class StageController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping
	(value = "stage/StageList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends StageResponse>> Tracking() {
		logger.debug("Entering into stage");
		try {
			StageImpl stageImpl = new StageImpl();
			List<StageResponse> stageResponseList = stageImpl.stageList();
			//System.out.println(stageResponseList.get(0).getStage());
			if (stageResponseList != null && !stageResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends StageResponse>>(stageResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends StageResponse>>(stageResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
