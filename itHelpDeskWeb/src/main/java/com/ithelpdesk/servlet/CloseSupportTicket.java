package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithelpdesk.javaclasses.Userdetails;

/**
 * Servlet implementation class CloseSupportTicket
 */
@WebServlet("/CloseSupportTicket")
public class CloseSupportTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null) {
			int ticketId=Integer.parseInt(request.getParameter("ticketId"));
			
			 try {
				new Userdetails().closeSupportRequest(ticketId);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
