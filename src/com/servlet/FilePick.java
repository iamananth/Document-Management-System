package com.servlet;
import java.io.File;
import java.text.ParseException;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.dao.FileUploadDao;


public class FilePick extends Thread {
	
	static final Logger logger = Logger.getLogger(FilePick.class);
	String listenDir = "C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\";
	FileUploadDao fdao = new FileUploadDao();
	boolean st = false;
	
	public void run(){
		File dir = new File(listenDir);
		File[] listofFiles = dir.listFiles();
		logger.info("No of files in directory ="+ listofFiles.length);
		logger.info("Checking whether the file is saved or not.....");
		for (File file : listofFiles) {
			if (file.exists()) {
				String name = file.getName();
				logger.info(name);
				boolean status = fdao.chkFile(name);
				if(!status){
					logger.info(name + " is not saved");
					st = fdao.inFile(name);
					logger.info(name + " is saved");
				}else{
					logger.info("All Files are saved");
				}
			}
		}
		
	}

}
