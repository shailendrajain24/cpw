package com.cpw.dao;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cpw.dao.mapper.ImageStoreMapper;
import com.cpw.jdbc.model.ImageStore;

public class ImageStoreDAOImpl implements ImageStoreDAO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);

	}

	@Override
	public String writeImage(ImageStore imageStore) {
		logger.debug("Entering into ImageStore DAO");
		CpwTemplete<ImageStore> cpwTemplete = new CpwTempleteImpl<ImageStore>();

		String sql = "INSERT INTO IMAGE_PATHSTORE(IMAGE_ID,IMAGE_URL)VALUES(?,?)";

		Object[] values = new Object[2];
		values[0] = imageStore.getImageId();

		byte[] bytes = imageStore.getBytes();

		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");

		// ImageIO is a class containing static methods for locating
		// ImageReaders
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
		String filePath = "C:\\tomcat8\\Photos\\";
		String fileName = System.currentTimeMillis() + "";
		// System.out.println(fileName);
		File imageFile = new File(filePath + fileName + ".jpg");
		try {
			ImageIO.write(bufferedImage, "jpg", imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		values[1] = imageFile.getPath();
		int count = cpwTemplete.upsert(sql, values, jdbcTemplateObject);
		System.out.println(imageFile.getPath());

		return imageFile.getPath();

	}

	@Override
	public List<ImageStore> readImage(long imageId) {
		logger.debug("Entering into ImagePathList");

		System.out.println(imageId);

		String sql = "SELECT IMAGE_URL FROM IMAGE_PATHSTORE WHERE IMAGE_ID=?";

		List<ImageStore> urlList = jdbcTemplateObject.query(sql, new Object[] { imageId }, new RowMapper<ImageStore>() {

			@Override
			public ImageStore mapRow(ResultSet rs, int rowNum) throws SQLException {
				ImageStore imageStore = new ImageStore();
				String url = rs.getString("IMAGE_URL");
				System.out.println(url);

				FileInputStream fis = null;
				try {

					File file = new File(url);

					fis = new FileInputStream(file);

				} catch (FileNotFoundException e) {
					System.out.println("Exception is" + e);
					e.printStackTrace();
					return null;
				}
				// create FileInputStream which obtains input bytes from a file in a
				// file system
				// FileInputStream is meant for reading streams of raw bytes such as
				// image data. For reading streams of characters, consider using
				// FileReader.

				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				try {
					for (int readNum; (readNum = fis.read(buf)) != -1;) {
						// Writes to this byte array output stream
						bos.write(buf, 0, readNum);
						System.out.println("read " + readNum + " bytes,");
					}
				} catch (IOException ex) {
					logger.debug("no path in the system" + ex);
					return null;

				}

				imageStore.setBytes(bos.toByteArray());

				return imageStore;
			}
		});

		return urlList;

	}

}
