package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;



import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.LoginDao;
import com.pojo.User;

/**
 * Servlet implementation class UserLogin
 */
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final Logger logger = Logger.getLogger(UserLogin.class);
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.valueOf(request.getParameter("userid"));
		String password = request.getParameter("password");
		
		
		LoginDao dao = new LoginDao();
		User user = dao.login(userid, password);
		
		if (user != null) {
			if(userid == 144){
				  HttpSession session = request.getSession();
				  session.setAttribute("user", user);
				  String pattern = "E, dd MMM yyyy HH:mm:ss z";
				  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				  String date = simpleDateFormat.format(new Date());
				  session.setAttribute("loginTime", date);
				  logger.info("User " + user.getUsername() + " logged in successfully.");
				  response.sendRedirect("AdminDashboard.jsp");
			}else{
				  HttpSession session = request.getSession();
				  session.setAttribute("user", user);
				  String pattern = "E, dd MMM yyyy HH:mm:ss z";
				  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				  String date = simpleDateFormat.format(new Date());
				  session.setAttribute("loginTime", date);
				  logger.info("User " + user.getUsername() + " logged in successfully.");
				  response.sendRedirect("UserDashboard.jsp");
			}
		}
		if(user == null){
			request.setAttribute("errorMessage", "Invalid user id or password.");
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}
	}

}
