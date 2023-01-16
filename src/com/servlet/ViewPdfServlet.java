package com.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
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
		PrintWriter out = response.getWriter();
		
		response.setContentType("application/pdf");  
		out = response.getWriter();  
		
		String fname = request.getParameter("fname");
		String path = "C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\";
		
		response.setHeader("Content-Disposition", "inline; filename="+fname+";");  
		
		FileOutputStream fileOut = new FileOutputStream(path + fname);  
		fileOut.close();  
		out.close(); 
	}

}
