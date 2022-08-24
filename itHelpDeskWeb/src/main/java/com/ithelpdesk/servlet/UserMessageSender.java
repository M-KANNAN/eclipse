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

import com.ithelpdesk.javaclasses.UserMessager;

/**
 * Servlet implementation class UserMessageSender
 */
@WebServlet("/UserMessageSender")
public class UserMessageSender extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		
		HttpSession httpSession = request.getSession();
		
			String uID=httpSession.getAttribute("UserId").toString();
	
			String message=request.getParameter("message");
		

		if (uID != null && GetChatDetails.ticketId > 0 && message != null && !"".equals(message.trim()) && message.length() > 2) {
			
			int userId = Integer.parseInt(uID);
			
			int ticketId=GetChatDetails.ticketId ;
			try {
				new UserMessager().userMessager(userId,ticketId,message);
				
				out.println("<script> alert('Message sended successfully')</script>");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}
		else {
			out.println("<script> alert('Message cannot be send')</script>");
			
		}
		
	}

}
