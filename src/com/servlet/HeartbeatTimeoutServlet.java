package com.servlet;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HeartbeatTimeoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // update the session's last accessed time
        session.setAttribute("heartbeat", System.currentTimeMillis());
    }
}

