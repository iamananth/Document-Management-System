package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.pojo.User;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.valueOf(request.getParameter("userid"));
		String password = request.getParameter("password");
		
		
		
		LoginDao dao = new LoginDao();
		User user = dao.getUser(userid, password);
		
		if (user != null) {
			  HttpSession session = request.getSession();
			  session.setAttribute("user", user);
			  response.sendRedirect("UserDashboard.jsp");
			} else {
			  request.setAttribute("errorMessage", "Invalid username or password");
			  request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
			}
	}

}
