package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.ITeacherRepository;

public class TeacherRepository extends Repository<Teacher> {
	
	public TeacherRepository(Connection connection, IEntityBuilder<Teacher> builder) {
		super(connection,builder);
	}

	@Override
	protected String getInsertQuery() {
		return "INSERT INTO teachers(firstName,lastName) VALUES(?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE teachers SET firstName=?, lastName=? WHERE id=?";
	}

	@Override
	protected String getTableName() {
		return "teachers";
	}
	
	@Override
	protected void setUpInsertQuery(Teacher entity) throws SQLException {
		
		insert.setString(1, entity.getFirstName());
		insert.setString(2, entity.getLastName());
	}

	@Override
	protected void setUpUpdateQuery(Teacher entity) throws SQLException {
		update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setInt(3, entity.getId());
	}

}

