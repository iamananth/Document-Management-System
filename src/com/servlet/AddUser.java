package com.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.pojo.User;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String dept = request.getParameter("dept");
		String ph = request.getParameter("ph");
		String pass = request.getParameter("pass");
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hash = md.digest(pass.getBytes());
		String hashedPassword = new String(hash, "UTF-8");
		
		User u = new User();
		u.setUsername(name);
		u.setDepartment(dept);
		u.setPhone_number(ph);
		u.setPassword(hashedPassword);
		
		RegisterDao dao = new RegisterDao();		
		dao.register(u);
		response.sendRedirect("AdminDashboard.jsp");
	}

}
