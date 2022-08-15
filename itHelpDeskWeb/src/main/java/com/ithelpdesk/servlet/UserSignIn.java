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

import com.ithelpdesk.javaclasses.UserLoginClass;


@WebServlet("/UserSignIn")
public class UserSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		
		PrintWriter out=response.getWriter();
		
		if (name != null && pass != null  && !name.trim().equals("") && !pass.trim().equals("")) {
			
			try {
				UserLoginClass loginClass=new UserLoginClass();
				
				int userId=loginClass.getUserDetails(name, pass);
				
				if(userId > 0) {
					if(loginClass.userIsAdmin(userId)) {
						
						HttpSession httpSession=request.getSession();
						httpSession.setAttribute("name", name);
						httpSession.setAttribute("UserId", userId);
						response.sendRedirect("AdminHomePage.jsp");
						
						
					}
					else {
						
						HttpSession httpSession=request.getSession();
						httpSession.setAttribute("name", name);
						httpSession.setAttribute("UserId", userId);
						response.sendRedirect("UserHomePage.jsp");
					}
				}
				else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('!!! User unnavailabe !!!');");
					out.println("location='Userlogin.jsp';");
					out.println("</script>");
				}

			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}

		} else {

			out.println("<script type=\"text/javascript\">");
			out.println("alert('!!! Name and password feild should not be empty !!!');");
			out.println("location='Userlogin.jsp';");
			out.println("</script>");

		}
		
		
		
	}

}
