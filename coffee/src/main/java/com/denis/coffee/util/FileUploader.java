package com.denis.coffee.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.denis.coffeebackend.utils.PropertiesClass;

public class FileUploader {

	private static final String ABSTRACT_PATH = PropertiesClass.getSettings("assetsPath").getProperty("assets.image");
	private static String REAL_PATH = null;

	private static final Logger logger = LoggerFactory.getLogger(FileUploader.class);

	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		String arrayPath[] = code.split("/");

		String extraPath = "";

		for (int i = 0; i < arrayPath.length - 1; i++) {
			extraPath += arrayPath[i] + "/";
		}

		String fileName = arrayPath[arrayPath.length - 1];

		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/" + extraPath);
		String newABSTRACT_PATH = ABSTRACT_PATH + extraPath;
		logger.info(REAL_PATH);

		// want be sure all directory exists
		if (!new File(newABSTRACT_PATH).exists()) {
			// create the directories
			new File(newABSTRACT_PATH).mkdirs();
		}

		if (!new File(REAL_PATH).exists()) {
			// create the directories
			new File(REAL_PATH).mkdirs();
		}

		try {
			// transfer the file to both the location
			file.transferTo(new File(REAL_PATH + fileName + ".jpg"));
			file.transferTo(new File(newABSTRACT_PATH + fileName + ".jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
