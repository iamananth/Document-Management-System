package com.servlet;

import java.io.File;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
				maxFileSize=1024*1024*50,      	// 50 MB
				maxRequestSize=1024*1024*100)   	// 100 MB
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "projectfiles";
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
		File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(uploadFilePath + File.separator + fileName);
        }
 
        request.setAttribute("message", fileName + " File uploaded successfully!");
        getServletContext().getRequestDispatcher("UserDashboard.jsp").forward(
                request, response);
	}
	private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
