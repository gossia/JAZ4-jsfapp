package web.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DummyDb;
import web.WebContextNames;
import domain.Privilege;
import domain.User;

@WebServlet("Privilege")
public class PrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PrivilegeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();
		DummyDb db = (DummyDb)ctx.getAttribute(WebContextNames.listOfUsers);
		
		User u = null;
		for(User user : db.users) {
			if(user.getUserName().equals(request.getParameter("username")))
				u = user;
		}
		
		if(u != null)
		{
			if(u.getPrivilege().equals(Privilege.REGULAR))
			{
				u.setPrivilege(Privilege.PREMIUM);
				request.getRequestDispatcher("listOfUsers.jsp").forward(request, response);
				//return;
			}
			else if(u.getPrivilege().equals(Privilege.PREMIUM))
			{
				u.setPrivilege(Privilege.REGULAR);
				request.getRequestDispatcher("listOfUsers.jsp").forward(request, response);
				//return;
			}
			else
			{
				request.setAttribute("badUser", "This user is neither a REGULAR nor a PREMIUM user!");
				request.getRequestDispatcher("addDelPrivilegesForm.jsp").forward(request, response);
				//return;
			}
		}
		else
		{
			request.setAttribute("noSuchUser", "No such user!");
			request.getRequestDispatcher("addDelPrivilegesForm.jsp").forward(request, response);
			//return;
		}
		
	}
}
