package com.cpw.services;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cpw.dao.ImageStoreDAOImpl;

public class ImageImpl {
	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	ImageStoreDAOImpl imageDAOImpl = (ImageStoreDAOImpl) context.getBean("imageDAOImpl");

	/*
	 * public byte[] readImage(String url) { url =
	 * "C:\\Users\\fission\\Downloads\\"; File file = new File(url);
	 * 
	 * FileInputStream fis = null; try { fis = new FileInputStream(file); } catch
	 * (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); return null; } // create FileInputStream which obtains
	 * input bytes from a file in a // file system // FileInputStream is meant for
	 * reading streams of raw bytes such as // image data. For reading streams of
	 * characters, consider using // FileReader.
	 * 
	 * ByteArrayOutputStream bos = new ByteArrayOutputStream(); byte[] buf = new
	 * byte[1024]; try { for (int readNum; (readNum = fis.read(buf)) != -1;) { //
	 * Writes to this byte array output stream bos.write(buf, 0, readNum);
	 * System.out.println("read " + readNum + " bytes,"); } } catch (IOException ex)
	 * { return null; //
	 * Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, // null,
	 * ex); }
	 * 
	 * return bos.toByteArray(); }
	 */

	public String writeImage(byte[] bytes) {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

		// ImageIO is a class containing static methods for locating ImageReaders
		// and ImageWriters, and performing simple encoding and decoding.

		ImageReader reader = (ImageReader) readers.next();
		Object source = bis;
		ImageInputStream iis = null;
		try {
			iis = ImageIO.createImageInputStream(source);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();

		Image image = null;
		try {
			image = reader.read(0, param);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// got an image file

		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		// bufferedImage is the RenderedImage to be written

		Graphics2D g2 = bufferedImage.createGraphics();
		g2.drawImage(image, null, null);
		String filePath = "C:\\ttspl\\images\\";
		String fileName = System.currentTimeMillis() + "";
		// System.out.println(fileName);
		File imageFile = new File(filePath + fileName + ".jpg");
		try {
			ImageIO.write(bufferedImage, "jpg", imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(imageFile.getPath());

		return imageFile.getPath();

	}

}
