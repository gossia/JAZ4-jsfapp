package repositories.impl;

import java.sql.*;

import domain.Address;
import domain.Student;

public class AddressBuilder implements IEntityBuilder<Address> {
	
	@Override
	public Address build(ResultSet rs) throws SQLException {
		
		Address address = new Address();
		address.setId(rs.getInt("id"));
		address.setCountry(rs.getString("country"));
		address.setCity(rs.getString("city"));
		address.setPostalCode(rs.getString("postalCode"));
		address.setStreet(rs.getString("street"));
		address.setHouseNumber(rs.getString("houseNumber"));
		address.setLocalNumber(rs.getString("localNumber"));
		return address;
	}

}
