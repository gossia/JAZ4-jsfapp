package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IStudentRepository;


public class StudentRepository implements IStudentRepository{
	
	private Connection connection;
	
	private String insertSql=
			"INSERT INTO students(firstName,lastName,pesel) VALUES(?,?,?)";
	private String selectByIdSql=
			"SELECT * FROM students WHERE id=?";
	private String updateSql=
			"UPDATE students SET firstName=?, lastName=?, pesel=? WHERE id=?";
	private String deleteSql=
			"DELETE FROM students WHERE id=?";
	private String selectAllSql=
			"SELECT * FROM students";

	private PreparedStatement insert;
	private PreparedStatement selectById;
	private PreparedStatement update;
	private PreparedStatement delete;
	private PreparedStatement selectAll;

	public StudentRepository(Connection connection) {
		
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
	public void add(Student entity) {
		
		try {
				insert.setString(1, entity.getFirstName());
				insert.setString(2, entity.getLastName());
				insert.setString(3, entity.getPesel());
				insert.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void update(Student entity) {
		
		try {
				update.setString(1, entity.getFirstName());
				update.setString(2, entity.getLastName());
				update.setString(3, entity.getPesel());
				update.setInt(4, entity.getId());
				update.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void delete(Student entity) {
		
		try {
				delete.setInt(1, entity.getId());
				delete.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public Student get(int id) {
		Student result = null;

		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				result = new Student();
				result.setId(rs.getInt("id"));
				result.setFirstName(rs.getString("firstName"));
				result.setLastName(rs.getString("lastName"));
				result.setPesel(rs.getString("pesel"));
				return result;
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> getAll() {

		List<Student> result = new ArrayList<Student>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setFirstName(rs.getString("firstName"));
				s.setLastName(rs.getString("lastName"));
				s.setPesel(rs.getString("pesel"));
				result.add(s);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> byLanguage(Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> byLanguage(int languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> byLanguage(String languageName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student byAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student byAddress(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student byAddress(String street, String houseNumber,
			String localNumber, String postalCode, String city, String country) {
		// TODO Auto-generated method stub
		return null;
	}

}

