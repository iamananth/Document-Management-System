package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.ViewDetailsDao;
import com.pojo.ProjectDetails;
import com.pojo.User;

/**
 * Servlet implementation class ArchivedProject
 */
public class ArchivedProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(ArchivedProject.class);
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		int userid = u.getId();
		ViewDetailsDao dao = new ViewDetailsDao();
		logger.info("User " + u.getUsername() + " viewed archived project details.");
		List<ProjectDetails> details = dao.getArchived(userid);
		request.setAttribute("details",details);
        request.getRequestDispatcher("ArchivedView.jsp").forward(request, response);
	}

	

}
