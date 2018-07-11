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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.model.SectorResponse;
import com.cpw.services.SectorImpl;

/**
 * @author Unknown
 *
 */
@RestController
public class SectorController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/sector", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<? extends SectorResponse>> Sector() {
		logger.debug("Entering into Sector");
		try {
			SectorImpl sectorImpl = new SectorImpl();
			List<SectorResponse> sectorResponseList = sectorImpl.sectorList();
			if (sectorResponseList != null && !sectorResponseList.isEmpty()) {
				return new ResponseEntity<List<? extends SectorResponse>>(sectorResponseList, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<? extends SectorResponse>>(sectorResponseList, HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
