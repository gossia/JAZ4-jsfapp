package com.example.servletjspdemo.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.example.servletjspdemo.domain.Person;
import com.example.servletjspdemo.domain.PersonBuilder;

public class StorageService {
	
	private HttpServletRequest request;
	private ArrayList<Person> persons;
	private int numberOfParticipants;
	
	@SuppressWarnings("unchecked")
	public StorageService(HttpServletRequest request) {
		this.request = request;
		persons = (ArrayList<Person>) request.getServletContext().getAttribute("persons");
		numberOfParticipants = (Integer)request.getServletContext().getAttribute("participants");
	}

	public void addPerson() throws ServletException, IOException {
		
		persons.add(new PersonBuilder().build(request));
		numberOfParticipants++;
		
		request.getSession().setAttribute("firstName", request.getParameter("firstName"));
		request.getSession().setAttribute("lastName", request.getParameter("lastName"));
		request.getServletContext().setAttribute("participants", numberOfParticipants);
		request.getServletContext().setAttribute("persons", persons);
			
	}
	
}
