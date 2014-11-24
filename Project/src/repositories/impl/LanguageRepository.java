package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.ILanguageRepository;

public class LanguageRepository implements ILanguageRepository {
	
private Connection connection;
	
	private String insertSql=
			"INSERT INTO languages(name,level) VALUES(?,?)";
	private String selectByIdSql=
			"SELECT * FROM languages WHERE id=?";
	private String updateSql=
			"UPDATE languages SET name=?, level=? WHERE id=?";
	private String deleteSql=
			"DELETE FROM languages WHERE id=?";
	private String selectAllSql=
			"SELECT * FROM languages";

	private PreparedStatement insert;
	private PreparedStatement selectById;
	private PreparedStatement update;
	private PreparedStatement delete;
	private PreparedStatement selectAll;

	public LanguageRepository(Connection connection) {
		
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
	public void add(Language entity) {
		
		try {
				insert.setString(1, entity.getName());
				insert.setString(2, entity.getLevel());
				insert.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void update(Language entity) {
		
		try {
				update.setString(1, entity.getName());
				update.setString(2, entity.getLevel());
				update.setInt(3, entity.getId());
				update.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public void delete(Language entity) {
		
		try {
				delete.setInt(1, entity.getId());
				delete.executeUpdate();
		} catch (SQLException e) {

				e.printStackTrace();
		}
	}

	@Override
	public Language get(int id) {
		Language result = null;

		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				result = new Language();
				result.setId(rs.getInt("id"));
				result.setName(rs.getString("name"));
				result.setLevel(rs.getString("level"));
				return result;
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Language> getAll() {

		List<Language> result = new ArrayList<Language>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				Language t = new Language();
				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setLevel(rs.getString("level"));
				result.add(t);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return result;
	}

	@Override
	public Language ofTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language ofTeacher(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language ofTeacher(String teacherFirstName, String teacherLastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> ofStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> ofStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> ofStudent(String studentFirstName,
			String studentLastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
