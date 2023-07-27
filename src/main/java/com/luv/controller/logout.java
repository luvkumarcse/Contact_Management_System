package com.luv.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
public class logout extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			HttpSession session=req.getSession();
			session.removeAttribute("uemail");
			session.removeAttribute("sname");
			session.removeAttribute("uid");
			resp.sendRedirect("login");
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
	}

}
