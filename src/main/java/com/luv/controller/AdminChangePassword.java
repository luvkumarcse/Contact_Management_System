package com.luv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv.entities.User;


public class AdminChangePassword extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		PrintWriter out=resp.getWriter();
		String currentpassword=req.getParameter("upassword");
		String newpassword=req.getParameter("newpass");
		String confirmpassword=req.getParameter("confirmpassw");
		out.print(currentpassword+newpassword+confirmpassword);
		HttpSession session=req.getSession();
		String uemail=session.getAttribute("uemail").toString();
		
		if(newpassword.equals(confirmpassword))
		{
			
			 	Configuration conn=new Configuration().configure().addAnnotatedClass(User.class);
		       	SessionFactory sf1=conn.buildSessionFactory();
		       	Session sess1=sf1.openSession();
		       	Transaction tx1=sess1.beginTransaction();
		       	Query query1=sess1.createQuery("from User where uemail='"+uemail+"' and upassword='"+currentpassword+"'");
		       	List lst1=query1.list();
		       	Iterator itr1=lst1.iterator();
		       	String name="";
		       	String contact="";
		       	String profession="";
		       	String address="";
		       	String city="";
		       	String country="";
		       	String role="";
		       	String status="";
	            int c=0;
		       	while(itr1.hasNext())
		       	{
		       		User ob1=(User)itr1.next();
		       		name=ob1.getUname();
		       		contact=ob1.getUcontact();
		       		profession=ob1.getUprofession();
		       		address=ob1.getUaddress();
		       		city=ob1.getUcity();
		       		country=ob1.getUcountry();
		       		role=ob1.getRole();
		       		status=ob1.getStatus();
		       		c++;
		       	}
		       	//out.println(c);
		       	if(c==1)
		       	{
		       		User u=new User();
		       		u.setUpassword(confirmpassword);
		       		u.setUemail(uemail);
		       		u.setUname(name);
		       		u.setUcontact(contact);
		       		u.setUprofession(profession);
		       		u.setUaddress(address);
		       		u.setUcity(city);
		       		u.setUcountry(country);
		       		u.setRole(role);
		       		u.setStatus(status);
		       		
		       		Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		       		SessionFactory sf=con.buildSessionFactory();
		       		Session sess=sf.openSession();
		       		Transaction tx=sess.beginTransaction();
		       		sess.update(u);
		       		tx.commit();
		       		out.println("done");
		       		resp.sendRedirect("changepassword");
		       		
		       	}
		       	
		       	tx1.commit(); 
		       	
		}
		else
		{
		out.println("Password incorrect ");	
		
		}
		
	}

	
}
