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

/**
 * Servlet implementation class PickSupportRequest
 */
@WebServlet("/PickSupportRequest")
public class PickSupportRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			ArrayList<Integer> userTickets;
			try {
				userTickets = userdetails.pickUserTickets(userId);
			

				response.setContentType("text/HTML");
				
				if(userTickets.size() > 1) {
					
					out.println("<label for='ticket_Picker'>Choose a Ticket :</label>");

					out.println(
							"<select name='ticket' id='ticket_Picker' style=width:' 60px;'  >");

					for (Integer integer : userTickets) {

						out.println(" <option value=" + integer + ">" + integer + "</option>");

					}
					out.println("</select>");
					
					out.println("<button onclick='ticketPickButton()'>Pick a ticket</button>");
				}
				else {
					out.println("<script>alert('No Ticket Availabe ');</script>");
				}
				

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		if (httpSession.getAttribute("UserId") != null  && req.getParameter("ticketId") != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());
			int ticketId=Integer.parseInt(req.getParameter("ticketId"));
			
			try {
				new Userdetails().adminTicketPicker(userId,ticketId);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

	}

}
