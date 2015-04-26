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
import domain.Address;
import domain.AddressBuilder;

@WebServlet("Address")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddressServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();
		DummyDb db = (DummyDb)ctx.getAttribute(WebContextNames.listOfAddresses);
		
		//remove
		Address a = null;
		for(Address address : db.addresses) {
			if(address.getUser().equals(request.getParameter("user")) && address.getType().equals(request.getParameter("typeofaddress")))
				a = address;
		}
		db.addresses.remove(a);
		
		//add
		if(request.getParameter("voivodeship")!=null)
		{
			db.addresses.add(new AddressBuilder().build(request));
		}
		
		request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		//return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
