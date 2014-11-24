package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.*;
import repositories.ITeacherRepository;

public class TeacherRepository implements ITeacherRepository {
	
	private Connection connection;
	
	private String insertSql=
			"INSERT INTO teachers(firstName,lastName) VALUES(?,?)";
	private String selectByIdSql=
			"SELECT * FROM teachers WHERE id=?";
	private String updateSql=
			"UPDATE teachers SET firstName=?, lastName=? WHERE id=?";
	private String deleteSql=
			"DELETE FROM teachers WHERE id=?";
	private String selectAllSql=
			"SELECT * FROM teachers";

	private PreparedStatement insert;
	private PreparedStatement selectById;
	private PreparedStatement update;
	private PreparedStatement delete;
	private PreparedStatement selectAll;

	public TeacherRepository(Connection connection) {
		
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
	public void add(Teacher entity) {
		
		try {
				insert.setString(1, entity.getFirstName());
				insert.setString(2, entity.getLastName());
				insert.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void update(Teacher entity) {
		
		try {
				update.setString(1, entity.getFirstName());
				update.setString(2, entity.getLastName());
				update.setInt(3, entity.getId());
				update.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void delete(Teacher entity) {
		
		try {
				delete.setInt(1, entity.getId());
				delete.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public Teacher get(int id) {
		Teacher result = null;

		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				result = new Teacher();
				result.setId(rs.getInt("id"));
				result.setFirstName(rs.getString("firstName"));
				result.setLastName(rs.getString("lastName"));
				return result;
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Teacher> getAll() {

		List<Teacher> result = new ArrayList<Teacher>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				Teacher t = new Teacher();
				t.setId(rs.getInt("id"));
				t.setFirstName(rs.getString("firstName"));
				t.setLastName(rs.getString("lastName"));
				result.add(t);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public List<Teacher> ofLanguage(Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> ofLanguage(int languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> ofLanguage(String languageName) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}

