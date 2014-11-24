package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IAddressRepository;

public class AddressRepository implements IAddressRepository{
	
private Connection connection;
	
	private String insertSql=
			"INSERT INTO addresses(country,city,postalCode,street,houseNumber,localNumber)"
			+ "VALUES(?,?,?,?,?,?)";
	private String selectByIdSql=
			"SELECT * FROM addresses WHERE id=?";
	private String updateSql=
			"UPDATE addresses SET country=?, city=?, postalCode=?, street=?, houseNumber=?, "
			+ "localNumber=? WHERE id=?";
	private String deleteSql=
			"DELETE FROM addresses WHERE id=?";
	private String selectAllSql=
			"SELECT * FROM addresses";

	private PreparedStatement insert;
	private PreparedStatement selectById;
	private PreparedStatement update;
	private PreparedStatement delete;
	private PreparedStatement selectAll;

	public AddressRepository(Connection connection) {
		
		this.connection = connection;
		try
		{
			insert = connection.prepareStatement(insertSql);
			selectById=connection.prepareStatement(selectByIdSql);
			update=connection.prepareStatement(updateSql);
			delete=connection.prepareStatement(deleteSql);
			selectAll=connection.prepareStatement(selectAllSql);
		
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public void add(Address entity) {
		
		try {
				insert.setString(1, entity.getCountry());
				insert.setString(2, entity.getCity());
				insert.setString(3, entity.getPostalCode());
				insert.setString(4, entity.getStreet());
				insert.setString(5, entity.getHouseNumber());
				insert.setString(6, entity.getLocalNumber());
				insert.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void update(Address entity) {
		
		try {
				update.setString(1, entity.getCountry());
				update.setString(2, entity.getCity());
				update.setString(3, entity.getPostalCode());
				update.setString(4, entity.getStreet());
				update.setString(5, entity.getHouseNumber());
				update.setString(6, entity.getLocalNumber());
				update.setInt(7, entity.getId());
				update.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void delete(Address entity) {
		
		try {
				delete.setInt(1, entity.getId());
				delete.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public Address get(int id) {
		Address result = null;

		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				result = new Address();
				result.setId(rs.getInt("id"));
				result.setCountry(rs.getString("country"));
				result.setCity(rs.getString("city"));
				result.setPostalCode(rs.getString("postalCode"));
				result.setStreet(rs.getString("street"));
				result.setHouseNumber(rs.getString("houseNumber"));
				result.setLocalNumber(rs.getString("localNumber"));
				return result;
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Address> getAll() {

		List<Address> result = new ArrayList<Address>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				Address a = new Address();
				a.setId(rs.getInt("id"));
				a.setCountry(rs.getString("country"));
				a.setCity(rs.getString("city"));
				a.setPostalCode(rs.getString("postalCode"));
				a.setStreet(rs.getString("street"));
				a.setHouseNumber(rs.getString("houseNumber"));
				a.setLocalNumber(rs.getString("localNumber"));
				result.add(a);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Address> ofStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> ofStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> ofStudent(String studentFirstName,
			String studentLastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
