package com.servlet;

import java.io.*;

import javax.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegisterDao;

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
        
        RegisterDao dao = new RegisterDao();
        boolean st = dao.insert(uname, pass, dept, ph);
        
        if(st){
        	RequestDispatcher rs = request.getRequestDispatcher("UserManage.jsp");
            rs.forward(request, response);
        }
	}

}
