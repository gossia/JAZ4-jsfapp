package com.example.servletjspdemo.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


public class PersonBuilder implements IEntityBuilder<Person>{

	public Person build(HttpServletRequest request) throws ServletException, IOException {
		
		Person p = new Person();
		p.setFirstName(request.getParameter("firstName"));
		p.setLastName(request.getParameter("lastName"));
		p.setOrganisation(request.getParameter("organisation"));
		p.setEmail(request.getParameter("email"));
		p.setSource(request.getParameter("source"));
		p.setOtherSource(request.getParameter("otherSource"));
		p.setJob(request.getParameter("job"));
		
		return p;
	}

}
