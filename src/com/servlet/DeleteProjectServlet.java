package com.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.DeleteProjectDao;
import com.pojo.User;

/**
 * Servlet implementation class DeleteProjectServlet
 */
public class DeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger logger = Logger.getLogger(DeleteProjectServlet.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pcode = request.getParameter("pcode");
		String fileName = request.getParameter("fname");
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		//Deleting the project Details
		DeleteProjectDao dao = new DeleteProjectDao();
		boolean st = dao.deleteProject(pcode);
		
		File file = new File("C:\\Users\\anant\\workspace\\DMS Project\\WebContent\\projectfiles\\" + fileName);
	    
		//Deleting the file from the server
	    boolean st1 = file.delete();
	    logger.info("User " + u.getUsername() + "deleted project details of project code "+pcode);
	    System.out.println(file.getName() +"deleted.");
	    
	    if(st && st1){
	    	response.sendRedirect("UserDashboard.jsp");
	    }
		
		
	}


}
