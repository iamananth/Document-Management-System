package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.UserDao;
import com.pojo.User;

/**
 * Servlet implementation class EditUser
 */
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(EditUser.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		UserDao dao = new UserDao();
		List<User> details = dao.getUserDetails(id);
		logger.info("User " + u.getUsername() + "edited user details successfully.");
		
		request.setAttribute("details",details);
        request.getRequestDispatcher("EditUserView.jsp").forward(request, response);
	}

}
