package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.RatingDAOImpl;
import com.cpw.jdbc.model.Rating;
import com.cpw.model.RatingResponse;

public class RatingImpl {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context;

	public List<RatingResponse> ratingList() {
		logger.debug("Entering into ratingList");
		context = new ClassPathXmlApplicationContext("Beans.xml");
		RatingDAOImpl ratingDAOImpl = (RatingDAOImpl) context.getBean("ratingDAOImpl");
		final List<Rating> ratingList = ratingDAOImpl.ratingList();
		return map(ratingList);

	}

	private List<RatingResponse> map(List<Rating> ratingList) {
		List<RatingResponse> ratingResponseList = Collections.emptyList();
		if (ratingList != null && !ratingList.isEmpty()) {
			ratingResponseList = new ArrayList<RatingResponse>();
			for (Rating rating : ratingList) {
				RatingResponse trackingResponse = map(rating);
				ratingResponseList.add(trackingResponse);
			}
			ratingList.clear();
		}
		return ratingResponseList;

	}

	private RatingResponse map(Rating rating) {
		RatingResponse ratingResponse = new RatingResponse();
		if (rating != null) {
			ratingResponse.setRatingName(rating.getRatingName());
			ratingResponse.setId(rating.getId());
		}
		return ratingResponse;

	}

}
