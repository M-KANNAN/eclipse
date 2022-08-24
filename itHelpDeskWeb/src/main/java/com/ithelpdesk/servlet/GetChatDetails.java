package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ithelpdesk.javaclasses.ChatDetailsForTicket;
import com.ithelpdesk.javaclasses.ChatPojo;

/**
 * Servlet implementation class GetChatDetails
 */
@WebServlet("/GetChatDetails")
public class GetChatDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected static int ticketId = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession httpSession = request.getSession();

		String uID = httpSession.getAttribute("UserId").toString();

		String tID = request.getParameter("ticketNo");

		if (uID != null && tID != null) {

			int userId = Integer.parseInt(uID);

			ticketId = Integer.parseInt(tID);

			try {

				HashMap<Integer, ArrayList<ChatPojo>> chatdetails = new ChatDetailsForTicket()
						.chatDetailsForTicket(userId, ticketId);

				out.print("<table border='1' width='100%' color = 'snow'  text-align ='center';");

				ArrayList<ChatPojo> chatPojoArrayList = chatdetails.get(ticketId);

				out.println("<tr colspan='3'>  <label for=\"message_sender\">Type a reply here</label>\n"
						+ "  <textarea id=\"message_sender\" name=\"message_box\" rows=\"4\" cols=\"50\" ></textarea>\n"
						+ "  <input type=\"button\" value=\"Send\" onclick=\"messageFunction()\"> <br><tr>");
				
				if (chatPojoArrayList != null) {
					
					out.print("<tr ><br><th>Sender</th><th>Reciver</th><th>Message</th></tr>");
					out.println("<tr colspan='3' color = 'snow' ><p>Messages till now : </p></tr>");

					for (ChatPojo chatPojo : chatPojoArrayList) {

//						System.out.println(chatPojo.getTextMessage());

						out.print("<tr style = 'text-align : center;'> <td>" + chatPojo.getSenderName() + "</td><td>"
								+ chatPojo.getReciverName() + "</td><td>" + chatPojo.getTextMessage() + "</td>");

//						System.out.println(chatPojo.getTextMessage());
					}

				}
				else {
					out.println("<tr colspan='3' style='color : snow ; text-align: center;'  text-align ='center';><h1> Start a conversation for this ticket </h1></tr>");
					System.out.println("No conversation till now");
				}

				out.println("</table>");

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			out.println("<script>alert('No UserId and TicketId')</script>");
		}

	}

}
