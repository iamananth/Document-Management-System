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

public class UserDetails extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(UserDetails.class);

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("user");
		
			UserDao dao = new UserDao();
			List<User> users = dao.getUsersFromDatabase();
			logger.info("User " + u.getUsername() + " viewed user details.");
			req.setAttribute("users", users);
            req.getRequestDispatcher("UserDetailsList.jsp").forward(req, res); 
       
	}

}
