package com.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.ProjectDao;
import com.pojo.User;

/**
 * Servlet implementation class UpdateProject
 */
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(UpdateProject.class);
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uuid = request.getParameter("guid");
		UUID guid = UUID.fromString(uuid);
		String projectCode = request.getParameter("pcode");
		String startDate = request.getParameter("pstart");
		String endDate = request.getParameter("pend");
		String projectType = request.getParameter("ptype");
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		int user_id = u.getId();
		ProjectDao dao = new ProjectDao();
	    dao.upProject(projectCode,startDate,endDate,projectType,guid);
	    logger.info("User " + u.getUsername() + " updated project details of project code "+ projectCode);
	    if(user_id == 144){
	    	response.sendRedirect("AdminDashboard.jsp");
	    }
	    else{
	    	response.sendRedirect("UserDashboard.jsp");
	    }
	}

}
