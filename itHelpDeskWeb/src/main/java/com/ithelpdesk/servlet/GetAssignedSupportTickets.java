package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * Servlet implementation class GetAssignedSupportTickets
 */
@WebServlet("/GetAssignedSupportTickets")
public class GetAssignedSupportTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			try {
				HashMap<Integer, TicketDetails> myAssigendTickets = userdetails.getUserTickets(userId, true);

				if (myAssigendTickets.size() > 1) {

					out.print("<table border='1' width='100%' color = 'snow'");
					out.print(
							"<tr ><th>Ticket No</th><th>User Name</th><th>Subject</th><th>Discription</th><th>Status</th><th>Time of Creation</th>");

					// update

					for (Entry<Integer, TicketDetails> entry : myAssigendTickets.entrySet()) {
						TicketDetails details = entry.getValue();

						out.print("<tr id=" + entry.getKey() + " value=" + entry.getKey() + " style='cursor: pointer;"
								+ "text-align: center;' onclick='getIdFunction(this.id)'><td>" + entry.getKey()
								+ "</td><td>" + userdetails.getAdminName(details.getAdminName()) + "</td><td>"
								+ details.getSubject() + "</td><td>" + details.getDiscription() + "</td><td>"
								+ details.getTicket_Status() + "</td><td>" + details.getTimeOfCreation()
								+ "</td><td> <button onclick='AdminUpdateFunction(" + entry.getKey()
								+ ")'>Change Admin</button><td> <button onclick='ticketCloseFunction(" + entry.getKey()
								+ ")'>Close Ticket</button>");

					}
					out.print("</table>");

				} else {
					out.println("<script>alert('No Tickets Available')</script>");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
