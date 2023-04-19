package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.ForgotPassDao;
import com.pojo.User;

/**
 * Servlet implementation class ForgotPass
 */
public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(ForgotPass.class);
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userid");
		String newPass = request.getParameter("password");
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		ForgotPassDao dao = new ForgotPassDao();
		boolean st = dao.changePass(userId, newPass);
		
		if(st){
			logger.info("User " + u.getUsername() + " password changed successfully.");
			request.setAttribute("SuccessPass", "Password Changed, Login Again");
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
		}
	}

}
