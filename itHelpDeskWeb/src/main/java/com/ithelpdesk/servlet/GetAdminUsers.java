package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithelpdesk.javaclasses.Userdetails;


@WebServlet("/GetAdminUsers")
public class GetAdminUsers extends HttpServlet {
	
	protected static int ticketNo;
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null) {
			
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			ticketNo=Integer.parseInt(request.getParameter("ticketId"));

			try {
				ArrayList<Integer> ticketList = userdetails.getAdminUser(userId);

				response.setContentType("text/HTML");

				out.println("<label for='admin_Details'>Choose a Admin :</label>");

				out.println("<select name='admin_Details' id='available_Admin' style=width:' 60px;' >");

				for (Integer integer : ticketList) {

					out.println(" <option value=" + integer + ">" + integer + "</option>");

				}
				out.println("</select>");

				out.println("<button onclick='selectAdmin()'>Register</button>");

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}
	
	
		
	

}
