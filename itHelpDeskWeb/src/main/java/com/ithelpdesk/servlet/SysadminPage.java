package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SysadminPage")
public class SysadminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("aname");
		
		String pass=request.getParameter("apass");
		
		PrintWriter out=response.getWriter();
		
		if(name != null && pass != null  && !name.trim().equals("") && !pass.trim().equals("")) {
			if("sysadmin123".equals(name) && "sysadmin@123".equals(pass)) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('!!! User signed sucessfully !!!');");
				out.println("location='SignInPage.jsp';");
				out.println("</script>");
				
				HttpSession httpSession=request.getSession();
				
				httpSession.setAttribute("name", "admin");
				
				response.sendRedirect("AdminSignUp.jsp");

				
			}
			else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('!!! Only admin users are allowed !!!');");
				out.println("location='SignInPage.jsp';");
				out.println("</script>");
			}
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('!!! name and pass will not be empty !!!');");
			out.println("location='SignInPage.jsp';");
			out.println("</script>");
		}
		
	}

}
