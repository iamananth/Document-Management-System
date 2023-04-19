package com.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.dao.RegisterDao;
import com.pojo.User;

/**
 * Servlet implementation class UserRegister
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(UserRegister.class);
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String dept = request.getParameter("dept");
		String ph = request.getParameter("ph");
		String pass = request.getParameter("password");
		
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hash = md.digest(pass.getBytes());
		String hashedPassword = new String(hash, "UTF-8");
		
		logger.info(name + "tried to register.");
		
		User u = new User();
		u.setUsername(name);
		u.setDepartment(dept);
		u.setPhone_number(ph);
		u.setPassword(hashedPassword);
		
		RegisterDao dao = new RegisterDao();		
		dao.register(u);
		logger.info("User " + u.getUsername() + "registered successfully.");
		response.sendRedirect("UserLogin.jsp");
		
	}

}
