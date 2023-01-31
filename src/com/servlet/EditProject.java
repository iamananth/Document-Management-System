package com.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.EditDao;
import com.dao.ProjectDao;
import com.pojo.ProjectDetails;
import com.pojo.User;

/**
 * Servlet implementation class EditProject
 */
public class EditProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(ProjectServlet.class);
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pcode = request.getParameter("pcode");
		
		EditDao dao = new EditDao();
		List<ProjectDetails> details = dao.getProjectDetails(pcode);
		request.setAttribute("details",details);
        request.getRequestDispatcher("EditProject.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String projectCode = request.getParameter("pcode");
		String startDate = request.getParameter("pstart");
		String endDate = request.getParameter("pend");
		String projectType = request.getParameter("ptype");
		
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
		
		EditDao dao = new EditDao();
	    dao.editProject(p,u);
	    logger.info("User " + u.getUsername() + " edited project details of project code "+projectCode);
	    	String message = "Updated Successfully";
	    	request.setAttribute("message", message);
	    	response.sendRedirect("FileUpload.jsp");
		
	}

}
