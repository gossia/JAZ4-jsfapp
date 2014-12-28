package repositories.impl;

import java.sql.*;

import domain.*;
import unitofwork.IUnitOfWork;

public class LanguageRepository extends Repository<Language> {
	
	public LanguageRepository(Connection connection, IEntityBuilder<Language> builder, IUnitOfWork uow) {
		super(connection,builder,uow);
	}

	@Override
	protected void setUpInsertQuery(Language entity) throws SQLException {
		insert.setString(1, entity.getName());
		insert.setString(2, entity.getLevel());
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
	protected void setUpUpdateQuery(Language entity) throws SQLException {
		update.setString(1, entity.getName());
		update.setString(2, entity.getLevel());
		update.setInt(3, entity.getId());
	}

}
