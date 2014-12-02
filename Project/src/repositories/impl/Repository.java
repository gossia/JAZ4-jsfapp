package repositories.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import repositories.IRepository;
import domain.*;

public abstract class Repository<TEntity extends Entity> implements IRepository<TEntity> {
	
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement update;
	protected PreparedStatement selectAll;
	protected PreparedStatement delete;
	protected Connection connection;
	protected IEntityBuilder<TEntity> builder;
	
	private String selectByIdSql=
			"SELECT * FROM "+getTableName()+" WHERE id=?";
	private String deleteSql=
			"DELETE FROM "+getTableName()+" WHERE id=?";
	private String selectAllSql=
			"SELECT * FROM "+ getTableName();
	
	protected Repository(Connection connection, IEntityBuilder<TEntity> builder) {
		
		this.builder=builder;
		this.connection = connection;
		try
		{
			insert = connection.prepareStatement(getInsertQuery());
			selectById=connection.prepareStatement(selectByIdSql);
			update=connection.prepareStatement(getUpdateQuery());
			delete=connection.prepareStatement(deleteSql);
			selectAll=connection.prepareStatement(selectAllSql);
		
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	@Override
	public void add(TEntity entity) {
		
		try {
			setUpInsertQuery(entity);
			insert.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}

	@Override
	public void update(TEntity entity) {
		
		try {
			setUpUpdateQuery(entity);
			update.executeUpdate();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}

	@Override
	public TEntity get(int id) {

		try {
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next())
			{
				return builder.build(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TEntity> getAll() {

		List<TEntity> result = new ArrayList<TEntity>();
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				result.add(builder.build(rs));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public void delete(TEntity entity) {
		
		try {
			delete.setInt(1, entity.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract String getInsertQuery();
	protected abstract String getUpdateQuery();
	protected abstract String getTableName();
	protected abstract void setUpUpdateQuery(TEntity entity) throws SQLException;
	protected abstract void setUpInsertQuery(TEntity entity) throws SQLException;
	
}

	

