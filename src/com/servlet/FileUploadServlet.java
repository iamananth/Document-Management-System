package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.dao.FileUploadDao;

/**
 * Servlet implementation class FileUploadServlet
 */

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = null;
		boolean st = false;
		

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
	            }
	            String pcode = FilenameUtils.removeExtension(fileName);
	            FileUploadDao dao = new FileUploadDao();
	            st = dao.FileUp(pcode, fileName);
	            System.out.println(fileName);
	            System.out.println(pcode);
	            if(st){
	            	String message = "Uploaded Successfully";
			    	request.setAttribute("message", message);
			    	response.sendRedirect("result.jsp");
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
