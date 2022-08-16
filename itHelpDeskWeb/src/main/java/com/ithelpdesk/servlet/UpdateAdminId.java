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
 * Servlet implementation class UpdateAdminId
 */
@WebServlet("/UpdateAdminId")
public class UpdateAdminId extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();
		
		PrintWriter out=response.getWriter();

		if (httpSession.getAttribute("UserId") != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			int ticketNo=GetAdminUsers.ticketNo;
			
			int adminId=Integer.parseInt(request.getParameter("adminId"));

			try {
			
				new Userdetails().updateAdminId(ticketNo,adminId);
				
				out.println("<script>$('#'+ticketId).remove();</script>");
				

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		
		
		
	}

}
