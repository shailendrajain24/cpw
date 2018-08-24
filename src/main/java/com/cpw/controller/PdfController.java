/**
 * 
 */
package com.cpw.controller;

import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpw.pdf.App;

/**
 * @author Unknown
 *
 */
@RestController
public class PdfController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@RequestMapping(value = "/ShippingBillPdf/{}", method = RequestMethod.GET)
	public Response getShippingBillPdf() {
		logger.debug("Entering into ShippingBillPdf");
		try {
			App a = new App();
			a.createPdf("Hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
