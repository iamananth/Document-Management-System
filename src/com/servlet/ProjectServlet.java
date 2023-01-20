package com.servlet;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.ProjectDao;
import com.pojo.ProjectDetails;
import com.pojo.User;
/**
 * Servlet implementation class ProjectServlet
 */

public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(ProjectServlet.class);
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//			int userid = Integer.parseInt(request.getParameter("uid"));
			String projectCode = request.getParameter("pcode");
			String startDate = request.getParameter("pstart");
			String endDate = request.getParameter("pend");
			String projectType = request.getParameter("ptype");
			
			
//			Date start = Date.valueOf(startDate);
//			Date end = Date.valueOf(endDate);
			
//			User u = new User(userid);
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");
			
			ProjectDetails p = new ProjectDetails();
			p.setPcode(projectCode);
			p.setStartDate(startDate);
			p.setEndDate(endDate);
			p.setPtype(projectType);
			p.setUser(u);
			
			Set<ProjectDetails> projectSet = new HashSet<ProjectDetails>();
			projectSet.add(p);
			
			u.setProjectdetails(projectSet);
			
			ProjectDao dao = new ProjectDao();
		    dao.inProject(p,u);
		    logger.info("User " + u.getUsername() + " saved project details successfully.");
		    FilePick f = new FilePick();
		    f.start();
		    	String message = "Updated Successfully";
		    	request.setAttribute("message", message);
		    	response.sendRedirect("FileUpload.jsp");
		    }	
}

