package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IStudentRepository;


public class StudentRepository extends Repository<Student> {
	
	public StudentRepository(Connection connection, IEntityBuilder<Student> builder) {
		super(connection,builder);
	}
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO students(firstName,lastName,pesel) VALUES(?,?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE students SET firstName=?, lastName=?, pesel=? WHERE id=?";
	}

	@Override
	protected String getTableName() {
		return "students";
	}
	
	@Override
	protected void setUpInsertQuery(Student entity) throws SQLException {
		
		insert.setString(1, entity.getFirstName());
		insert.setString(2, entity.getLastName());
		insert.setString(3, entity.getPesel());
	}
	
	@Override
	protected void setUpUpdateQuery(Student entity) throws SQLException {
		
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setString(3, entity.getPesel());
		update.setInt(4, entity.getId());
	}

}

