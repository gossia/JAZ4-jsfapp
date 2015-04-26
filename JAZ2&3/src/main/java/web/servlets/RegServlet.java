package web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.DummyDb;
import domain.UserBuilder;
import web.WebContextNames;
import web.Validation;

@WebServlet("Reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		ServletContext ctx = config.getServletContext();
		ctx.setAttribute(WebContextNames.listOfUsers, new DummyDb());
		ctx.setAttribute(WebContextNames.listOfAddresses, new DummyDb());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();

		DummyDb db = (DummyDb)ctx.getAttribute(WebContextNames.listOfUsers);
	
		Validation validation = new Validation(request);
		if(!validation.filledIn() || !validation.passwordConfirm() || validation.userExists())
		{
			request.getRequestDispatcher("newUserRegForm.jsp").forward(request, response);
		}
		else
		{
			db.users.add(new UserBuilder().build(request));
			request.getRequestDispatcher("registered.jsp").forward(request, response);
		}
	}

}
