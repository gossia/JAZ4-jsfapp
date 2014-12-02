package repositories.impl;

import java.sql.*;

import domain.Student;
import domain.Teacher;

public class TeacherBuilder implements IEntityBuilder<Teacher> {

	@Override
	public Teacher build(ResultSet rs) throws SQLException {
		
		Teacher teacher = new Teacher();
		teacher.setId(rs.getInt("id"));
		teacher.setFirstName(rs.getString("firstName"));
		teacher.setLastName(rs.getString("lastName"));
		return teacher;
	}

}
