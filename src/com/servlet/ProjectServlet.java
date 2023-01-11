package com.servlet;


import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dao.ProjectDao;
/**
 * Servlet implementation class ProjectServlet
 */

public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int userid = Integer.parseInt(request.getParameter("uid"));
			int projectCode = Integer.valueOf(request.getParameter("pcode"));
			String startDate = request.getParameter("pstart");
			String endDate = request.getParameter("pend");
			String projectType = request.getParameter("ptype");
			
			
			Date start = Date.valueOf(startDate);
			Date end = Date.valueOf(endDate);
			
			ProjectDao dao = new ProjectDao();
		    boolean st = false;
			try {
				st = dao.uploadFile(userid, projectCode, start, end, projectType);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    if(st){
		    	String message = "Updated Successfully";
		    	request.setAttribute("message", message);
		    	response.sendRedirect("result.jsp");
		    }
		}	
}

