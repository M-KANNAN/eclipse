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

import com.ithelpdesk.javaclasses.UserSignUpClass;


@WebServlet("/AdminUserSignUp")
public class AdminUserSignUp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();

		String name = request.getParameter("aname");
		String pass = request.getParameter("apass");

		
		HttpSession httpSession=request.getSession();
		
		if(httpSession.getAttribute("logout") != null) {
			
			

			if (name != null && pass != null) {

				try {
					if (new UserSignUpClass().getValidatedUser(name, pass, true)) {

						out.println("<script type=\"text/javascript\">");
						out.println("alert('!!! User signed sucessfully !!!');");
						out.println("location='AdminSignUp.jsp';");
						out.println("</script>");

					} else {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('!!! User Name Unavailable !!!');");
						out.println("location='AdminSignUp.jsp';");
						out.println("</script>");
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

			} else {

				out.println("<script type=\"text/javascript\">");
				out.println("alert('!!! Name and password feild should not be empty !!!');");
				out.println("location='SignInPage.jsp';");
				out.println("</script>");

			}

			
		}
		else {
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('!!! Logout !!!');");
			out.println("location='SignInPage.jsp';");
			out.println("</script>");
		}
		
	}

}
