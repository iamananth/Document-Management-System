package com.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuidGen
 */
public class GuidGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UUID guid = UUID.randomUUID();
		HttpSession session = request.getSession();
		session.setAttribute("GUID", guid);
		response.sendRedirect("ProjectEntry.jsp");
	}

}
