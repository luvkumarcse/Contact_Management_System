package com.luv.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luv.entities.AddContact;
import com.luv.entities.User;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginuser(Model m)
	{
		User ob=new User();
		m.addAttribute("login", ob);
		return "login";
	}
	@RequestMapping("/register")
	public String registeruser(Model m)
	{
		User ob=new User();
		m.addAttribute("register", ob);
		return "register";
	}
	@RequestMapping(value="/registerform",method=RequestMethod.POST)
	public String registerform(@ModelAttribute("register")User ob,Model m)
	{
		User u=new User();
		u.setUname(ob.getUname());
		u.setUemail(ob.getUemail());
		u.setUcontact(ob.getUcontact());
		u.setUpassword(ob.getUpassword());
		u.setUprofession(ob.getUprofession());
		u.setUaddress(ob.getUaddress());
		u.setUcity(ob.getUcity());
		u.setUcountry(ob.getUcountry());
		u.setRole("user");
		u.setStatus("true");
		
		Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf=con.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(u);
		tx.commit();
		
		System.out.println("register successfully");
		
		return "register";
	}
	@RequestMapping(value="/loginform",method=RequestMethod.POST)
	public String loginform(@ModelAttribute("login")User ob,Model m)
	{
	System.out.println(ob);
	User u=new User();
	u.setUemail(ob.getUemail());
	u.setUpassword(ob.getUpassword());
	
	Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
	SessionFactory sf=con.buildSessionFactory();
	Session session=sf.openSession();
	Transaction tx=session.beginTransaction();
	Query query= session.createQuery("from User where uemail='"+ob.getUemail()+"' and upassword='"+ob.getUpassword()+"'");
	List lst=query.list();
	Iterator itr=lst.iterator();
	int c=0;
	String role="";
	String status="";
	
	while(itr.hasNext())
	{
		User ob1=(User)itr.next();
		role=ob1.getRole();
		status=ob1.getStatus();
		System.out.println(role+status);
		c++;
	}
	//System.out.println(c);
	if(c==1)
	{
		m.addAttribute("uemail", ob.getUemail());
		  try {
		if(role.equals("user") && status.equals("true"))
		{
			return "home";
				
		}
		if(role.equals("admin") && status.equals("true")) 
		{
			return "admin";	
		}
		else
			return "login";
		  
		  }
		  catch(Exception e)
		  {
			  
		  }
		
		return "home";

	
	}
	return "login";	
	}
	@RequestMapping("/profile")
	public String profile()
	{
		return "profile";
	}
	@RequestMapping("/addcontact")
	public String addcontact(Model m)
	{
		AddContact ob=new AddContact();
		m.addAttribute("addcontact", ob);
		return "addcontact";
	}
	@RequestMapping(value="/addcontactform", method=RequestMethod.POST)
	public String addcontactform(@ModelAttribute("addcontact")AddContact ob, Model m)
	{
		System.out.println(ob);
		AddContact ad=new AddContact();
		ad.setName(ob.getName());
		ad.setEmail(ob.getEmail());
		ad.setContact(ob.getContact());
		ad.setProfession(ob.getProfession());
		ad.setOrganisation(ob.getOrganisation());
		ad.setAddress(ob.getAddress());
		ad.setCity(ob.getCity());
		ad.setUemail(ob.getUemail());
		
		Configuration con=new Configuration().configure().addAnnotatedClass(AddContact.class);
		SessionFactory sf=con.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(ad);
		tx.commit();
		
		return "addcontact";
	}
	@RequestMapping("/completerecord")
	public String completerecord()
	{
		return "completerecord";
	}
	@RequestMapping(value="/deleteform",method=RequestMethod.POST)
	public String deleteform(@ModelAttribute("delete")AddContact ob, Model m)
	{
		System.out.println(ob);
		AddContact aa=new AddContact();
		aa.setId(ob.getId());
		//System.out.println("id is"+ob.getId());

		Configuration con=new Configuration().configure().addAnnotatedClass(AddContact.class);
		SessionFactory sf=con.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		sess.delete(aa);
		tx.commit();
		return "completerecord";
	}
	
	@RequestMapping("/editform")
	public String editform()
	{
		return "updaterecord";
	}
	@RequestMapping(value="/updaterecordform", method=RequestMethod.POST)
	public String updaterecordform(@ModelAttribute("updaterecord")AddContact ob, Model m)
	{
		System.out.println(ob);
        AddContact add=new AddContact();
		add.setId(ob.getId());
		add.setName(ob.getName());
		add.setEmail(ob.getEmail());
		add.setContact(ob.getContact());
		add.setProfession(ob.getProfession());
		add.setOrganisation(ob.getOrganisation());
		add.setAddress(ob.getAddress());
		add.setCity(ob.getCity());
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(AddContact.class);
		SessionFactory sf=con.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		sess.update(add);
		tx.commit();
		
       return "updaterecord";
	
	}
	@RequestMapping("/search-record")
	public String searchrecord()
	{
		
		return "search-record";
	}
	@RequestMapping("/searchresult")
	public String searchresult()
	{
		
		return "searchresult";
	}
	@RequestMapping("/changepassword")
	public String changepassword()
	{
		
		return "changepassword";
	}

	/*
	 * @RequestMapping(value="/changepasswordresult", method=RequestMethod.POST)
	 * public String changepasswordresult(@ModelAttribute("changepassword")User ob,
	 * Model m) { System.out.println(ob);
	 * 
	 * 
	 * return "changepassword"; }
	 */
	@RequestMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	@RequestMapping("/adminprofile")
	public String adminprofile()
	{
		return "adminprofile";
	}
	@RequestMapping("/updateadminprofile")
	public String updateadminprofile()
	{
		return "updateadminprofile";
	}
	
	@RequestMapping(value="/updateadminprofileresult", method=RequestMethod.POST)
	public String updateadminprofileresult(@ModelAttribute("adminupdate")User ob, Model m)
	{
		System.out.println(ob);
		
		User add=new User();
		add.setUname(ob.getUname());
		add.setUemail(ob.getUemail());
		add.setUcontact(ob.getUcontact());
		add.setUpassword(ob.getUpassword());
		add.setUprofession(ob.getUprofession());
		add.setUaddress(ob.getUaddress());
		add.setUcity(ob.getUcity());
		add.setUcountry(ob.getUcountry());
		add.setRole(ob.getRole());
		add.setStatus(ob.getStatus());
		
		
		Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf=con.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		sess.update(add);
		tx.commit();
        
       return "updateadminprofile";
	
	}
	@RequestMapping("/adminchangepassword")
	public String adminchangepassword()
	{
		
		return "adminchangepassword";
	}
	@RequestMapping("/useraccount")
	public String useraccount(Model m)
	{
		User ob=new User();
		m.addAttribute("useraccount",ob);
		
		return "useraccount";
	}
	@RequestMapping(value="/useraccountresult",method=RequestMethod.POST)
	public String useraccountresult(@ModelAttribute("useraccount")User ob,Model m)
	{
		User u=new User();
		u.setUname(ob.getUname());
		u.setUemail(ob.getUemail());
		u.setUcontact(ob.getUcontact());
		u.setUpassword(ob.getUpassword());
		u.setUprofession(ob.getUprofession());
		u.setUaddress(ob.getUaddress());
		u.setUcity(ob.getUcity());
		u.setUcountry(ob.getUcountry());
		u.setRole("user");
		u.setStatus("true");
		
		Configuration con=new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf=con.buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		sess.save(u);
		tx.commit();
		
		System.out.println("register successfully");
		
		return "useraccount";
	}
	
	@RequestMapping("/adminmanage")
	public String adminmanage()
	{
		
		return "adminmanage";
	}
	@RequestMapping("/searchuser")
	public String searchuser()
	{
		
		return "searchuser";
	}
	@RequestMapping("/searchuser-result")
	public String searchuserresult()
	{
		
		return "searchuser-result";
	}
	
}
