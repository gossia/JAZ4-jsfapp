package repositories.impl;

import java.sql.*;

import domain.Student;

public class StudentBuilder implements IEntityBuilder<Student> {

	@Override
	public Student build(ResultSet rs) throws SQLException {
		
		Student student = new Student();
		student.setId(rs.getInt("id"));
		student.setFirstName(rs.getString("firstName"));
		student.setLastName(rs.getString("lastName"));
		student.setPesel(rs.getString("pesel"));
		return student;
	}

}
