package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ViewDetailsDao;
import com.pojo.ProjectDetails;
import com.pojo.User;

/**
 * Servlet implementation class ViewProjectUser
 */
public class ViewProjectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		int userid = u.getId();
		ViewDetailsDao dao = new ViewDetailsDao();
		List<ProjectDetails> details = dao.getProjectDetails(userid);
		if(userid == 144){
			request.setAttribute("details",details);
	        request.getRequestDispatcher("AdminViewProject.jsp").forward(request, response);
		}else{
			request.setAttribute("details",details);
	        request.getRequestDispatcher("ViewProjectDetails.jsp").forward(request, response);
		}
		
	}



}
