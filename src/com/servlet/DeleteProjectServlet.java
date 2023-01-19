package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DeleteProjectDao;

/**
 * Servlet implementation class DeleteProjectServlet
 */
public class DeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pcode = request.getParameter("pcode");
		String fileName = request.getParameter("fname");
		
		//Deleting the project Details
		DeleteProjectDao dao = new DeleteProjectDao();
		boolean st = dao.deleteProject(pcode);
		
		File file = new File("C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\" + fileName);
	    
	    boolean st1 = file.delete();
	    System.out.println(file.getName() +"deleted.");
	    
	    if(st && st1){
	    	response.sendRedirect("UserDashboard.jsp");
	    }
		
		
	}


}
