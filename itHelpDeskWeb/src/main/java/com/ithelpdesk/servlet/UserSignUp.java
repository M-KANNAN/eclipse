package com.ithelpdesk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithelpdesk.javaclasses.UserSignUpClass;

@WebServlet(name = "UserSignUpServlet", urlPatterns = { "/UserSignUpServlet" })
public class UserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");

		if (name != null && pass != null  && !name.trim().equals("") && !pass.trim().equals("")) {

			try {
				if (new UserSignUpClass().getValidatedUser(name, pass, false)) {

					out.println("<script type=\"text/javascript\">");
					out.println("alert('!!! User signed sucessfully !!!');");
					out.println("location='SignInPage.jsp';");
					out.println("</script>");

				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('!!! User Name Unavailable !!!');");
					out.println("location='SignInPage.jsp';");
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

}
