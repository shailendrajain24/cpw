package com.cpw.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.ImageStoreDAOImpl;
import com.cpw.jdbc.model.ImageStore;
import com.cpw.model.ImageStoreRequest;
import com.cpw.model.ImageStoreResponse;

public class ImageStoreImpl {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationContext context  = new ClassPathXmlApplicationContext("Beans.xml");
	ImageStoreDAOImpl imageDAOImpl = (ImageStoreDAOImpl) context.getBean("imageDAOImpl");



	public String writeImage(ImageStoreRequest imageRequest)
	{

		logger.debug("Entering into imageStore");


		String imageDaoImpl=imageDAOImpl.writeImage(write(imageRequest));
		return imageDaoImpl;

	}
	private ImageStore write(ImageStoreRequest imageRequest)
	{
		ImageStore imageStore=new ImageStore();
		imageStore.setImageId(imageRequest.getImageId());
		imageStore.setBytes(imageRequest.getBytes());
		return imageStore;

	}


	public List<ImageStoreResponse> imagePathList(long imageId)
	{
		logger.debug("Entering into List");
		System.out.println(imageId);


		List<ImageStore> imageList=imageDAOImpl.readImage(imageId);


		return readImage(imageList);		
	}
	private List<ImageStoreResponse> readImage(List<ImageStore> imageStoreList){

		List<ImageStoreResponse> imageStoreResponse=Collections.emptyList();
		if(imageStoreList!=null && !imageStoreList.isEmpty())
		{
			imageStoreResponse=new ArrayList<ImageStoreResponse>();
			for(ImageStore imageStore : imageStoreList)
			{
				ImageStoreResponse imageStoreResponseList=readImage(imageStore);
				imageStoreResponse.add(imageStoreResponseList);
			}
			imageStoreList.clear();
		}
		return imageStoreResponse;

	}
	private ImageStoreResponse readImage(ImageStore imageStore)
	{
		ImageStoreResponse response=new ImageStoreResponse();
		if(response!=null)
		{

			response.setBytes(imageStore.getBytes());
		}
		return response;

	}

}
