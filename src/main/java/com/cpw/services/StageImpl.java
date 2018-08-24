package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.StageDAOImpl;
import com.cpw.jdbc.model.Stage;
import com.cpw.model.StageResponse;

public class StageImpl {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<StageResponse> stageList() {
		logger.debug("Entering into stageList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		StageDAOImpl stageDAOImpl = (StageDAOImpl) context.getBean("stageDAOImpl");
		final List<Stage> stageList=stageDAOImpl.stageList();
		return map(stageList);

	}
	private List<StageResponse> map(List<Stage> stageList) {
		List<StageResponse> stageResponseList = Collections.emptyList();
		if (stageList != null) {
			stageResponseList = new ArrayList<StageResponse>();
			for (Stage stage : stageList) {
				StageResponse trackingResponse = map(stage);
				stageResponseList.add(trackingResponse);
			}
			stageList.clear();
		}
		//System.out.println("stageResponseList "+stageResponseList.size()+" stageList "+stageList);
		return stageResponseList;

	}
	private StageResponse map(Stage stage) {
		StageResponse stageResponse = new StageResponse();
		if (stage != null) {
			stageResponse.setStage(stage.getStage());
			stageResponse.setStageId(stage.getStageId());
			stageResponse.setProbability(stage.getProbability());
		}
	//	System.out.println("storage :"+stage.getStage());
		return stageResponse;

	}




}
