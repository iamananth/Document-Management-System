package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.pojo.User;

public class UserDetails extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			UserDao dao = new UserDao();
			List<User> users = dao.getUsersFromDatabase();
			req.setAttribute("users", users);
            req.getRequestDispatcher("UserDetailsList.jsp").forward(req, res); 
       
	}

}
