package com.ajaxlearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		PrintWriter printWriter=resp.getWriter();
		printWriter.println(name);
		
		
	}

}
