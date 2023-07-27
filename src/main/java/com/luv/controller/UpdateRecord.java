package com.luv.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateRecord
 */
public class UpdateRecord extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String uid=req.getParameter("uid");
		PrintWriter pw=resp.getWriter();
		HttpSession session=req.getSession();
		session.setAttribute("uid", uid);
		resp.sendRedirect("http://localhost:8001/Contact_Management_System/editform");
	}
}
