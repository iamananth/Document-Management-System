package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import com.dao.FileUploadDao;
import com.pojo.User;

/**
 * Servlet implementation class FileUploadServlet
 */

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(FileUploadServlet.class);
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String fileName = null;
		boolean st = false;
		HttpSession session = request.getSession();
		String pcode = (String) session.getAttribute("pcode");
		System.out.print(pcode);
		DiskFileItemFactory factory = new DiskFileItemFactory();

	        
	        ServletFileUpload upload = new ServletFileUpload(factory);

	        try {
	            
	            List<FileItem> items = upload.parseRequest(request);
	            
	            StringBuilder sb = new StringBuilder();

	            for (FileItem item : items) {
	                if (!item.isFormField()) {
	                    
	                    fileName = item.getName();
	                    sb.append(fileName).append(",");
	                    File file = new File("C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\" + fileName);
	                    item.write(file);
	                    String fileNames = sb.toString().substring(0, sb.toString().length() - 1);
	                    FileUploadDao dao = new FileUploadDao();
	    	            dao.FileUp(pcode, fileNames);
	    	            response.sendRedirect("UserDashboard.jsp");
	                }else{
	                	
	                }
	            }
//	            if(st){
//	            	HttpSession session1 = request.getSession();
//	  			  	User u = (User) session.getAttribute("user");
//	  			  	logger.info("User " + u.getUsername() + " uploaded documents successfully.");
//	            	String message = "Uploaded Successfully";
//			    	request.setAttribute("message", message);
//			    	
//	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
		String fileName = null;
		boolean st = false;
		String uuid = null;
		UUID guid = null;
        

		DiskFileItemFactory factory = new DiskFileItemFactory();

	        
	        ServletFileUpload upload = new ServletFileUpload(factory);

	        try {
	            
	            List<FileItem> items = upload.parseRequest(request);

	            for (FileItem item : items) {
	                if (!item.isFormField()) {
	                    
	                    fileName = item.getName();
	                    File file = new File("C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\" + fileName);
	                    item.write(file);
	                }
	                else{
	                	if ("guidd".equals(item.getFieldName())) {
	                        uuid = item.getString();
	                        guid = UUID.fromString(uuid);
	                      }
	                }
	            }
	            FileUploadDao dao = new FileUploadDao();
	            st = dao.FileUp(guid, fileName);
	        
	            if(st){
	            	HttpSession session = request.getSession();
	  			  	User u = (User) session.getAttribute("user");
	  			  	logger.info("User " + u.getUsername() + " uploaded documents successfully.");
	            	String message = "Uploaded Successfully";
			    	request.setAttribute("message", message);
			    	response.sendRedirect("UserDashboard.jsp");;
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
