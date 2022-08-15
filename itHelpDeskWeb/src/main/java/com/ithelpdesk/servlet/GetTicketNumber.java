package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithelpdesk.javaclasses.TicketDetails;
import com.ithelpdesk.javaclasses.Userdetails;


@WebServlet("/GetTicketNumber")
public class GetTicketNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			HashMap<Integer, TicketDetails> userTickets = userdetails.getUserTickets(userId,false);

			response.setContentType("text/HTML");

			out.println("<label for='ticket_Select'>Choose a Ticket :</label>");

			out.println(
					"<select name='ticket' id='ticket_Select' style=width:' 60px;' >");

			for (Entry<Integer, TicketDetails> entry : userTickets.entrySet()) {

				TicketDetails details = entry.getValue();

				if ("inprogress".equals(details.getTicket_Status()) || "open".equals(details.getTicket_Status())) {
					out.println(" <option value=" + entry.getKey() + ">" + entry.getKey() + "</option>");
				}

			}
			out.println("</select>");
			
			out.println("<button onclick='ticketUpdateFunction()'>upadate</button>");
		}
		
	}

}
