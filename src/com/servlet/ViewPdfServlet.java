package com.servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewPdfServlet
 */
public class ViewPdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String path = "C:/Users/anant/workspace/DMS Project/WebContent/projectfiles/";

	    File pdfFile = new File(path+fname);
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "inline; filename=" + pdfFile.getName());

	    ServletOutputStream out = response.getOutputStream();
	    FileInputStream in = new FileInputStream(pdfFile);
	    byte[] buffer = new byte[4096];
	    int length;
	    while ((length = in.read(buffer)) > 0){
	        out.write(buffer, 0, length);
	    }
	    in.close();
	    out.flush();
	}

}
