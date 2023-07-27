package com.luv.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.luv.entities.User;

public class AdminManageRecord extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		PrintWriter out=resp.getWriter();
		String manage=req.getParameter("manage");
		String email=req.getParameter("email");
	
		  Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		  SessionFactory sf=con.buildSessionFactory();
		  Session sess=sf.openSession();
		  Transaction tx=sess.beginTransaction();
	         Query q=sess.createQuery("from User Where uemail="+email+"");
	        
	         List l=q.list();
	         Iterator itr=l.iterator();
	         String name="";
	 		String contact="";
	 		String password="";
	 		String profession="";
	 		String address="";
	 		String city="";
	 		String country="";
	 		String role="";
	 		String uemail="";
	         while(itr.hasNext())
	         {
	        	 User ob1=(User)itr.next();
	 			name=ob1.getUname();
	 			contact=ob1.getUcontact();
	 			password=ob1.getUpassword();
	 			profession=ob1.getUprofession();
	 			address=ob1.getUaddress();
	 			city=ob1.getUcity();
	 			country=ob1.getUcountry();
	 			role=ob1.getRole();
	 			uemail=ob1.getUemail();
	        	
	         }
	         tx.commit();
	         
	         out.println(manage);
	         if (manage.equals("Active"))
	 		{
	 			out.print(email+manage);
	 			User ob=new User();
	 			ob.setUname(name);
	 			ob.setUcontact(contact);
	 			ob.setUpassword(password);
	 			ob.setUprofession(profession);
	 			ob.setUaddress(address);
	 			ob.setUcity(city);
	 			ob.setUcountry(country);
	 			ob.setRole(role);
	 			ob.setUemail(uemail);
	 			ob.setStatus("true");
	 		Configuration conn=new Configuration().configure().addAnnotatedClass(User.class);
	 			SessionFactory sff=conn.buildSessionFactory();
	 			Session sess1=sff.openSession();
	 			Transaction tx1=sess1.beginTransaction();
	 			sess1.update(ob);
	 			tx1.commit();
	 			out.println("domne");
	 		}
	         else 
	 		{
	 			out.print(email+manage);
	 			User ob2=new User();
	 			ob2.setUname(name);
	 			ob2.setUcontact(contact);
	 			ob2.setUpassword(password);
	 			ob2.setUprofession(profession);
	 			ob2.setUaddress(address);
	 			ob2.setUcity(city);
	 			ob2.setUcountry(country);
	 			ob2.setRole(role);
	 			ob2.setUemail(uemail);
	 			ob2.setStatus("false");
	 			Configuration conn2=new Configuration().configure().addAnnotatedClass(User.class);
	 			SessionFactory sff2=conn2.buildSessionFactory();
	 			Session sess2=sff2.openSession();
	 			Transaction tx2=sess2.beginTransaction();
	 			sess2.update(ob2);
	 			tx2.commit();
	 			out.println("ssss");
	 			
	 		}  
	         resp.sendRedirect("adminmanage");
	}
}
