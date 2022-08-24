package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

/**
 * Servlet implementation class GetArchivedTickets
 */
@WebServlet("/GetArchivedTickets")
public class GetArchivedTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null && httpSession.getAttribute("UserId").toString() != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			HashMap<Integer, TicketDetails> userTickets = userdetails.getUserTickets(userId, true);

			PrintWriter out = response.getWriter();

			if (userTickets.size() > 0) {

				out.print("<table border='1' width='100%' color = 'snow'");
				out.print(
						"<tr ><th>Ticket No</th><th>Techician Name</th><th>Subject</th><th>Discription</th><th>Status</th><th>Time of Creation</th>");

				// update

				for (Entry<Integer, TicketDetails> entry : userTickets.entrySet()) {
					TicketDetails details = entry.getValue();

					
					if ("archived".equals(details.getTicket_Status())) {
						
						out.print("<tr id=" + entry.getKey() + " value=" + entry.getKey() + " style='cursor: pointer;"
								+ "text-align: center;'><td>" + entry.getKey() + "</td><td>"
								+ userdetails.getAdminName(details.getAdminName()) + "</td><td>" + details.getSubject()
								+ "</td><td>" + details.getDiscription() + "</td><td>" + details.getTicket_Status()
								+ "</td><td>" + details.getTimeOfCreation() + "</td>"
								+ "<td> <button onclick='ticketArchiveFunction(" + entry.getKey()
								+ ")'>Trash Ticket </button></td></tr>");

					}
					
				}
				out.print("</table>");

			} else {
				out.println("<script>alert('No Tickets Available')</script>");
			}

		}
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null  && request.getParameter("ticketId") != null) {
			int ticketId=Integer.parseInt(request.getParameter("ticketId"));
			
			 try {
				new Userdetails().supportRequestStatusChanger(ticketId , 3);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

		
		
		
	}

}
