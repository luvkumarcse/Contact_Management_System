package com.luv.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchUser extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		HttpSession session=req.getSession();
		session.setAttribute("sname", name);
		resp.sendRedirect("searchuser-result");
		
		
	}
	

}
