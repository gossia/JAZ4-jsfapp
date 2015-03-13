package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.servletjspdemo.domain.Person;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public FirstServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String organisation = request.getParameter("organisation");
		String email = request.getParameter("email");
		String email_confirm = request.getParameter("email_confirm");
		String source = request.getParameter("source");
		String otherSource = request.getParameter("otherSource");
		String job = request.getParameter("job");
		
		int limit = 5;
		int participants = 0;
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		if(context.getAttribute("participants")==null){
			context.setAttribute("participants",0);
		}
		else{
		participants = (Integer) context.getAttribute("participants");
		}
		
		
		if (session.getAttribute("firstName") != null && !session.getAttribute("firstName").equals("")
				&& session.getAttribute("lastName") != null && !session.getAttribute("lastName").equals("")){
		
			if (session.getAttribute("firstName").equals(firstName) && session.getAttribute("lastName").equals(lastName)){
				response.sendRedirect("alreadySent.jsp");
				return;
			}
		}
		
		if(participants == limit){
			response.sendRedirect("maxReached.jsp");
			return;
		}
		
		if(firstName != null && !lastName.equals("") && lastName != null && !lastName.equals(""))
		{
				Person p = new Person();
				p.setFirstName(firstName);
				p.setLastName(lastName);
				p.setOrganisation(organisation);
				p.setEmail(email);
				p.setEmail_confirm(email_confirm);
				p.setSource(source);
				p.setOtherSource(otherSource);
				p.setJob(job);
				
		        participants++;
		        context.setAttribute("participants",participants);
		        
		        session.setAttribute("firstName", firstName);
				session.setAttribute("lastName", lastName);
		        
				response.sendRedirect("congratulation.jsp");
		}
		else{
			 PrintWriter out = response.getWriter();
             out.println("Fill in the form!");
		}
		
	}
}


