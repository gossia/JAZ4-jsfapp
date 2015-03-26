package com.example.servletjspdemo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class Validation {
	
	private HttpServletRequest request;

	public Validation(HttpServletRequest request){
		this.request = request;
	}
	
	
	public boolean filledIn() {
		if(request.getParameter("firstName").isEmpty() || request.getParameter("lastName").isEmpty() 
			|| request.getParameter("organisation").isEmpty() || request.getParameter("email").isEmpty() 
			|| request.getParameter("email_confirm").isEmpty() || request.getParameter("source").isEmpty() 
			|| request.getParameter("job").isEmpty())
		{
			request.setAttribute("fillAll", "Please fill in all fields!");
			return false;
		}
		else
			return true;
	}
	
	
	public boolean emailConfirm() {
		if(request.getParameter("email").equals(request.getParameter("email_confirm")))
			return true;	
		else{
			request.setAttribute("retypeEmail", "The email addresses do not match!");
			return false;
			}
	}

	
	public boolean maxReached() {
		int participants = (Integer) request.getServletContext().getAttribute("participants");
		int limit = (Integer) request.getServletContext().getAttribute("limit");
		
		if(participants >= limit){
			return true;
		}
		else
			return false;	
	}
	
	
	public boolean alreadySent() {
		HttpSession session = request.getSession();
		String thisSessionName = session.getAttribute("firstName") +" "+ session.getAttribute("lastName");
		
		if (thisSessionName.equals(request.getParameter("firstName")+" "+request.getParameter("lastName"))){
			request.setAttribute("alreadySent", "You are already registered. You cannot register twice.");
			return true;
		}
		else
			return false;
	}
	
}
	

	
	

