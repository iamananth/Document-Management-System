package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.pojo.User;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(DownloadServlet.class);
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String path = "C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\";
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment; filename=\""+ fname + "\"");
		
		FileInputStream inputstream = new FileInputStream(path + fname);
		
		int in;
		while ((in = inputstream.read()) != -1) {
			out.write(in);
		}
		logger.info("User " + u.getUsername() + " downloaded the project document "+fname);
		inputstream.close();
		out.close();
	}


}
