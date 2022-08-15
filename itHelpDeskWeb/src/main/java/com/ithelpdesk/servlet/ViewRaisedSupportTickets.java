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

/**
 * Servlet implementation class ViewRaisedSupportTickets
 */
@WebServlet("/ViewRaisedSupportTickets")
public class ViewRaisedSupportTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			HashMap<Integer, TicketDetails> userTickets = userdetails.getUserTickets(userId,false);

			PrintWriter out = response.getWriter();
			
			if(userTickets.size() > 1) {
				
				out.print("<table border='1' width='100%' color = 'snow'");
				out.print(
						"<tr ><th>Ticket No</th><th>Admin Name</th><th>Subject</th><th>Discription</th><th>Status</th><th>Time of Creation</th>");

				// update

				for (Entry<Integer, TicketDetails> entry : userTickets.entrySet()) {
					TicketDetails details = entry.getValue();

					out.print("<tr id=" + entry.getKey() + " value=" + entry.getKey() + " style='cursor: pointer;"
							+ "text-align: center;' onclick='getIdFunction(this.id)'><td>" + entry.getKey() + "</td><td>"
							+userdetails.getAdminName(details.getAdminName()) + "</td><td>" + details.getSubject() + "</td><td>"
							+ details.getDiscription() + "</td><td>" + details.getTicket_Status() + "</td><td>"
							+ details.getTimeOfCreation() + "</td>");

				}
				out.print("</table>");
				
			}
			else {
				out.println("<script>alert('No Tickets Available')</script>");
			}

		
		}

	}

}
