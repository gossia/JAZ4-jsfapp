package web.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.DummyDb;
import web.WebContextNames;
import domain.User;

@WebServlet("Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
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
		
		if(u!=null && u.getPassword().equals(request.getParameter("password")))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", u.getUserName());
			session.setAttribute("password", u.getPassword());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("privilege", u.getPrivilege());
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		}
		else
		{
				request.setAttribute("badUserOrPass", "You have entered an incorrect username or password!");
				request.getRequestDispatcher("loginForm.jsp").forward(request, response);
		}
		
	}
}
