package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.ILanguageRepository;

public class LanguageRepository extends Repository<Language> {
	
	public LanguageRepository(Connection connection, IEntityBuilder<Language> builder) {
		super(connection,builder);
	}

	@Override
	protected String getInsertQuery() {
		return "INSERT INTO languages(name,level) VALUES(?,?)";
	}
	
	@Override
	protected String getUpdateQuery() {
		return "UPDATE languages SET name=?, level=? WHERE id=?";
	}
	
	@Override
	protected String getTableName() {
		return "languages";
	}

	@Override
	protected void setUpInsertQuery(Language entity) throws SQLException {
		
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getLevel());
	}

	@Override
	protected void setUpUpdateQuery(Language entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setString(2, entity.getLevel());
		update.setInt(3, entity.getId());
	}

}
