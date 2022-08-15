package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithelpdesk.javaclasses.UserTicketUpdater;
import com.ithelpdesk.javaclasses.ValidatorClass;

@WebServlet("/UserTicketUpdadter")
public class UserTicketUpdadter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(UpdateRaisedSupportTickets.ticketNo);
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		

		String subject = request.getParameter("subject");

		String discription = request.getParameter("discription");

		ValidatorClass validatorClass = new ValidatorClass();

		if (subject != null && discription != null) {
			if (validatorClass.subjectDiscriptionValidator(subject, 1)
					&& validatorClass.subjectDiscriptionValidator(discription, 2)) {

				try {
					new UserTicketUpdater().userTicketUpdater(subject, discription,
							UpdateRaisedSupportTickets.ticketNo);
				} catch (SQLException e) {

					e.printStackTrace();
				}
				
//				out.println("<script type=\"text/javascript\">");
//				out.println("alert('!!! Updated Sucessfully !!!');");
//				//out.println("location='UserHomePage.jsp';");
//				out.println("</script>");
			}
			else {
//				out.println("<script type=\"text/javascript\">");
//				out.println("alert('!!! Subject and Discription is not in proper format !!!');");
//				//out.println("location='UserHomePage.jsp';");
//				out.println("</script>");
			}

		}
		else {
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('!!! Subject and Discription will not be empty !!!');");
//			//out.println("location='UserHomePage.jsp';");
//			out.println("</script>");
		}

	}

}
