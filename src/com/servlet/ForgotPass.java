package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ForgotPassDao;

/**
 * Servlet implementation class ForgotPass
 */
public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userid");
		String newPass = request.getParameter("password");
		
		ForgotPassDao dao = new ForgotPassDao();
		boolean st = dao.changePass(userId, newPass);
		
		if(st){
			request.setAttribute("SuccessPass", "Password Changed, Login Again");
			request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
		}
	}

}
