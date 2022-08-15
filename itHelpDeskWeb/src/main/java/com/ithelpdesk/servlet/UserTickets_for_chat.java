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
 * Servlet implementation class UserTickets_for_chat
 */
@WebServlet("/UserTickets_for_chat")
public class UserTickets_for_chat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null) {
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());

			try {
				ArrayList<Integer> ticketList = userdetails.getTicketForChat(userId);

				response.setContentType("text/HTML");

				out.println("<label for='ticket_Chat'>Choose a Ticket for chat :</label>");

				out.println(
						"<select name='ticket' id='ticket_Chat' style=width:' 60px;' onchange='ticketChatFunction(this.value)' >");

				for (Integer integer : ticketList) {

					out.println(" <option value=" + integer + ">" + integer + "</option>");

				}
				out.println("</select>");

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

}
