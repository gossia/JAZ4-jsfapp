package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import repository.DummyDb;
import domain.User;


public class Validation {
	
	private HttpServletRequest request;

	public Validation(HttpServletRequest request){
		this.request = request;
	}
	
	public boolean filledIn() {
		if(request.getParameter("username").isEmpty() || request.getParameter("password").isEmpty() 
			|| request.getParameter("password_confirm").isEmpty() || request.getParameter("email").isEmpty())
		{
			request.setAttribute("fillAll", "Please fill in all fields!");
			return false;
		}
		else
			return true;
	}
	
	public boolean passwordConfirm() {
		if(request.getParameter("password").equals(request.getParameter("password_confirm")))
			return true;	
		else{
			request.setAttribute("retypePassword", "The passwords do not match!");
			return false;
			}
	}
	
	public boolean userExists() {
		ServletContext ctx = request.getServletContext();
		DummyDb db = (DummyDb)ctx.getAttribute(WebContextNames.listOfUsers);
		
		for(User user : db.users) {
			if(request.getParameter("username").equals(user.getUserName()))
			{
				request.setAttribute("usernameExists", "This username already exists. Please choose another one!");
				return true;
			}
			else
				return false;
		}
		return false;		
	}
	
}
