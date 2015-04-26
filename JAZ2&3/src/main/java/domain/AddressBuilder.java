package domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AddressBuilder implements IEntityBuilder<Address>{

	public Address build(HttpServletRequest request) throws ServletException, IOException {
		
		Address a = new Address();
		a.setType(request.getParameter("typeofaddress"));
		a.setVoivodeship(request.getParameter("voivodeship"));
		a.setCity(request.getParameter("city"));
		a.setPostalCode(request.getParameter("postalcode"));
		a.setStreet(request.getParameter("street"));
		a.setHouseNumber(request.getParameter("housenumber"));
		a.setUser(request.getParameter("user"));
		return a;
	}

}
