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
 * Servlet implementation class AllArchived
 */
public class AllArchived extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		ViewDetailsDao dao = new ViewDetailsDao();
/*		logger.info("User " + u.getUsername() + " viewed ongoing project details.");*/
		List<ProjectDetails> archived = dao.AllArchived();
		/*List<ProjectDetails> details = dao.getProjectDetails(userid);*/
		request.setAttribute("archived",archived);
        request.getRequestDispatcher("AdminArchivedView.jsp").forward(request, response);
	}



}
