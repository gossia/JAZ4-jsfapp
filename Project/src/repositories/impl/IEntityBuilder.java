package repositories.impl;

import java.sql.*;
import domain.Entity;

public interface IEntityBuilder<TEntity extends Entity> {
	
	public TEntity build(ResultSet rs) throws SQLException;

}
