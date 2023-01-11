package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String dept = request.getParameter("dept");
		String ph = request.getParameter("ph");
		String pass = request.getParameter("password");
		
		RegisterDao dao = new RegisterDao();
		boolean st = dao.insert(name, pass, dept, ph);
		
		if(st){
			response.sendRedirect("UserLogin.jsp");
		}
	}

}
