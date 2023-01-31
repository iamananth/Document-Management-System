package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.UserDao;
import com.pojo.User;

/**
 * Servlet implementation class DeleteUser
 */
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(DeleteUser.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(request.getParameter("id1"));
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		UserDao dao = new UserDao();
		boolean st = dao.deleteUser(id);
		logger.info("User " + u.getUsername() + " deleted user with user id "+id+".");
		
		if(st){
			response.sendRedirect("AdminDashboard.jsp");
		}
	}

}
