package com.servlet;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;
import com.pojo.User;

/**
 * Servlet implementation class URegister
 */
public class URegister extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String dept = request.getParameter("dept");
        String ph = request.getParameter("ph");
        
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
        u.setUsername(uname);
        u.setPassword(hashedPassword);
        u.setDepartment(dept);
        u.setPhone_number(ph);
        
        RegisterDao dao = new RegisterDao();
        dao.register(u);
        RequestDispatcher rs = request.getRequestDispatcher("AdminDashboard.jsp");
        rs.forward(request, response);
	}

}
