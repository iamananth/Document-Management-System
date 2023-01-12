package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.pojo.User;

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
		
		User u = new User();
		u.setUsername(name);
		u.setDepartment(dept);
		u.setPhone_number(ph);
		u.setPassword(pass);
		
		RegisterDao dao = new RegisterDao();
//		boolean st = dao.insert(name, pass, dept, ph);
		
		int i = dao.register(u);
		
//		if(st){
//			response.sendRedirect("UserLogin.jsp");
//		}
		
		if(i > 0){
			response.sendRedirect("UserLogin.jsp");
		}
	}

}
