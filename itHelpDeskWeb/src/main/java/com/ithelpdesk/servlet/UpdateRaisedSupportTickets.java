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

@WebServlet("/UpdateRaisedSupportTickets")
public class UpdateRaisedSupportTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected static int ticketNo=0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Userdetails userdetails = new Userdetails();

		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("UserId") != null && request.getParameter("ticketNo") != null) {
			
			ticketNo=Integer.parseInt(request.getParameter("ticketNo")) ;
			
//			System.out.println(ticketNo);
			
			int userId = Integer.parseInt(httpSession.getAttribute("UserId").toString());
			
			HashMap<Integer, TicketDetails> userTickets = userdetails.getUserTickets(userId,false);
			
//			for(Entry<Integer, TicketDetails> entry : userTickets.entrySet()) {
//				System.out.println(entry.getKey());
//				System.out.println(entry.getValue().getSubject());
//				System.out.println(entry.getValue().getDiscription());
//			}
			
			PrintWriter out=response.getWriter();
			String subject=userTickets.get(ticketNo).getSubject();
			String discription=userTickets.get(ticketNo).getDiscription();
			
			response.setContentType("text/html");
			

			out.println("<div id=\"ticket_Updater_outer_box\">\n"
					+ "						<DIV id=\"ticket_Updator_Heading\">Ticket Updater</DIV>\n"
					+ "						<table id=\"ticketUpdaterForm\">\n"
					+ "							<form>\n"
					+ "\n"
					+ "								<tr>\n"
					+ "									<td><label for=\"updatesubject\">Subject : </label></td>\n"
					+ "									<td><input type=\"text\" id=\"updatesubject\" name=\"subject\"\n"
					+ "										value='" +subject+ "' required=\"required\" /></td>\n"
					+ "								</tr>\n"
					+ "\n"
					+ "								<tr>\n"
					+ "									<td><label for=\"updatediscription\"> Discription : </label></td>\n"
					+ "									<td><textarea type=\"text\" id=\"updatediscription\"\n"
					+ "									name=\"discription\"\n"
					+ "									required=\"required\"></textarea></td>\n"
					+ "								</tr>\n"
					+ "\n"
					+ "\n"
					+ "								<tr>\n"
					+ "									<td colspan=\"2\"><input type=\"button\" value=\"Update\"\n"
					+ "										id=\"button_Update\" ></td>\n"
					+ "\n"
					+ "								</tr>\n"
					+ "\n"
					+ "							</form>\n"
					+ "						</table>\n"
					+ "\n"
					+ "					</div>");
			
	
			out.println("<script>  "
					+ "document.getElementById('updatediscription').value='"+discription+"' ;"
					
					+ " $(document).ready(function() {\n"
					+ "\n"
					+ "			$('#button_Update').click(function() {\n"
					+ "\n"
					+ "				var subject = document.getElementById(\"updatesubject\").value;\n"
					+ "				var discription = document.getElementById(\"updatediscription\").value;\n"
					+ "\n"
					+ "				var object = {\n"
					+ "								type : 'POST',\n"
					+ "								url : 'UserTicketUpdadter',\n"
					+ "								data : {\n"
					+ "\n"
					+ "										subject : subject,\n"
					+ "										discription : discription\n"
					+ "\n"
					+ "										},\n"
					+ "										error : function() {\n"
					+ "												window.location = \"Userlogin.jsp\";\n"
					+ "										}\n"
					+ "\n"
					+ "								};\n"
					+ "\n"
					+ "				$.ajax(object).done(function(response) \n"
					+ "						{alert(\"Updated Sucessfully\")\n"
					+ "						$('#Ticket_Raiser_form').remove();		"
					+ "						});\n"
					+ "\n"
					+ "				});\n"
					+ "\n"
					+ "		});\n"
					+ "	</script>	");
	
			
		
		}


	}

}
