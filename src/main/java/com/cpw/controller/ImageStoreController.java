package com.cpw.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.ImageStoreRequest;
import com.cpw.model.ImageStoreResponse;
import com.cpw.services.ImageStoreImpl;

@RestController
public class ImageStoreController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="imagePathStore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String writeImage(@RequestBody ImageStoreRequest imageRequest)
	{
		logger.debug("Entering into controller");
		try {


			ImageStoreImpl imageStoreImpl = new ImageStoreImpl();
			String response=imageStoreImpl.writeImage(imageRequest);


			return response;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value="imagePath/{imageId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<ImageStoreResponse> readPath(@PathVariable("imageId")long imageId)
	{
		logger.debug("Entering into ImagePath List");
		try {
			System.out.println(imageId);
			ImageStoreImpl imageStoreImpl=new ImageStoreImpl();



			List<ImageStoreResponse> imageResponse=imageStoreImpl.imagePathList(imageId);

			if(imageResponse!=null )
			{
				return imageResponse;
			}
			else {
				return imageResponse;

			}

		} catch (Exception e) {
			logger.debug("NO ImagePath List in the system" +e);
			e.printStackTrace();
		}
		return null;

	}



}
