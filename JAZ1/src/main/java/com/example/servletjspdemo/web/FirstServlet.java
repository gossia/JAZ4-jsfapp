package com.example.servletjspdemo.web;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjspdemo.domain.Person;
import com.example.servletjspdemo.service.StorageService;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public FirstServlet() {
        super();
    }
    
    private final int limit = 5;
	
	public void init() throws ServletException {
		getServletContext().setAttribute("limit", this.limit);
		getServletContext().setAttribute("participants", 0);
		getServletContext().setAttribute("persons", new ArrayList<Person>());
		super.init();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Validation validation = new Validation(request);
		
		if(validation.maxReached()){
			request.getRequestDispatcher("maxReached.jsp").forward(request, response);
			return;
		}
		
		else{
			if(validation.alreadySent() || !validation.filledIn() || !validation.emailConfirm()){
				request.getRequestDispatcher("getPersonData.jsp").forward(request, response);
				return;
			}
			else{
				new StorageService(request).addPerson();
				request.getRequestDispatcher("congratulation.jsp").forward(request, response);
				return;
			}
		}

	}
}



