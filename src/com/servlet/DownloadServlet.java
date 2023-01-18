package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String path = "C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\";
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment; filename=\""+ fname + "\"");
		
		FileInputStream inputstream = new FileInputStream(path + fname);
		
		int in;
		while ((in = inputstream.read()) != -1) {
			out.write(in);
		}
		inputstream.close();
		out.close();
	}


}
