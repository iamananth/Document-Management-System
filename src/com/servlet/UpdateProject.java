package com.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProjectDao;
import com.pojo.ProjectDetails;
import com.pojo.User;

/**
 * Servlet implementation class UpdateProject
 */
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String projectCode = request.getParameter("pcode");
		String startDate = request.getParameter("pstart");
		String endDate = request.getParameter("pend");
		String projectType = request.getParameter("ptype");
	
		ProjectDao dao = new ProjectDao();
	    dao.upProject(projectCode,startDate,endDate,projectType);
//	    logger.info("User " + u.getUsername() + " saved project details successfully.");
//	    FilePick f = new FilePick();
//	    f.start();
//	    	String message = "Updated Successfully";
//	    	request.setAttribute("message", message);
    	response.sendRedirect("UserDashboard.jsp");
	}

}
