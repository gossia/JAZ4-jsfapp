package domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


public class UserBuilder implements IEntityBuilder<User>{

	public User build(HttpServletRequest request) throws ServletException, IOException {
		
		User u = new User();
		u.setUserName(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setEmail(request.getParameter("email"));
		
		if(request.getParameter("username").equals("admin")&&request.getParameter("password").equals("admin"))
			u.setPrivilege(Privilege.ADMIN);
		else	
			u.setPrivilege(Privilege.REGULAR);
		
		return u;
	}

}
