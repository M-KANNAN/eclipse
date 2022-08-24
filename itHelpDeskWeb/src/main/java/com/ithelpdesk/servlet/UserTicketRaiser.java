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

import com.ithelpdesk.javaclasses.TicketRaiser;
import com.ithelpdesk.javaclasses.ValidatorClass;

/**
 * Servlet implementation class UserTicketRaiser
 */
@WebServlet("/UserTicketRaiser")
public class UserTicketRaiser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter  out=response.getWriter();
		
		String subject=request.getParameter("subject");
		
		
		String discription=request.getParameter("discription");
		
//		out.println("<script type=\"text/javascript\">");
//		out.println("alert('!!! "+subject+" !!!');");
//		out.println("alert('!!! "+discription+" !!!');");
//		out.println("</script>");
//		
		
		
		if(subject != null && discription != null && ! "".equals(subject.trim()) && ! "".equals(discription.trim())) {
			
//			out.println("<script type=\"text/javascript\">");
//			out.println("alert('!!! entered !!!');");
//			out.println("location='UserHomePage.jsp#';");
//			out.println("</script>");
			
			ValidatorClass validatorClass=new ValidatorClass();
			
			if(validatorClass.subjectDiscriptionValidator(subject, 1) && validatorClass.subjectDiscriptionValidator(discription, 2)) {
				
				HttpSession httpSession=request.getSession();
				
				int userId=Integer.parseInt(httpSession.getAttribute("UserId").toString());
				
				TicketRaiser raiser=new TicketRaiser();
				
				try {
					int ticketId=raiser.userSupportTicketRaiser(subject,discription,userId);
					
					out.println("<script type=\"text/javascript\">");
					out.println("alert('!!! Ticket ID : "+ticketId+" raised Sucessfully !!!');");
					out.println("location='UserHomePage.jsp#';");
					out.println("</script>");
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
			}
			
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('!!! cant be empty !!!');");
			out.println("location='UserHomePage.jsp#';");
			out.println("</script>");
		}
		
		
	}

}
