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

import com.ithelpdesk.javaclasses.ChatDetailsForTicket;

/**
 * Servlet implementation class ChattingImplementation
 */
@WebServlet("/ChattingImplementation")
public class ChattingImplementation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter out=response.getWriter();
		
		HttpSession httpSession = request.getSession();
		
			String uID=httpSession.getAttribute("UserId").toString();
	
			String tID=request.getParameter("ticketNo");
			

		if (uID != null && tID != null) {
			
			int userId = Integer.parseInt(uID);
			
			int ticketId=Integer.parseInt(tID);
			
			try {
				if(new ChatDetailsForTicket().chatAvailableChecker(ticketId)) {
					
					out.println("<script>   "
							//+ "var text = \"For chat press OK!\";\n"
							//+ "			if (confirm(text) == true) {\n"
							+ "                ticketChatFunction("+ticketId+");\n"
							//+ "			}\n"
							+ "			 </script>");
					
				}
				else {
					out.println("<script>alert('!!!Chat Unavailabe !!!') ;</script>");
				}
			} catch (SQLException e) {
				
				
				e.printStackTrace();
			}
		}	
		
	}

}
