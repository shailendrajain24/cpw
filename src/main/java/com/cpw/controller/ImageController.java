package com.cpw.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.ImageStoreRequest;

@RestController
public class ImageController {
	@RequestMapping(value = "imageStore/{imageId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String imagePath(@RequestBody ImageStoreRequest imageRequest, @PathVariable("bytes") byte[] bytes,
			@PathVariable("imageId") long imageId) {
		return null;

	}
}
