package repositories.impl;

import java.sql.*;

import domain.*;
import unitofwork.IUnitOfWork;

public class AddressRepository extends Repository<Address> {
	
	public AddressRepository(Connection connection, IEntityBuilder<Address> builder, IUnitOfWork uow) {
		super(connection,builder,uow);
	}

	@Override
	protected void setUpInsertQuery(Address entity) throws SQLException {
		insert.setString(1, entity.getCountry());
		insert.setString(2, entity.getCity());
		insert.setString(3, entity.getPostalCode());
		insert.setString(4, entity.getStreet());
		insert.setString(5, entity.getHouseNumber());
		insert.setString(6, entity.getLocalNumber());
	}
	
	@Override
	protected String getInsertQuery() {
		return "INSERT INTO addresses(country,city,postalCode,street,houseNumber,localNumber)"
				+ "VALUES(?,?,?,?,?,?)";
	}

	@Override
	protected String getUpdateQuery() {
		return "UPDATE addresses SET country=?, city=?, postalCode=?, street=?, houseNumber=?, "
				+ "localNumber=? WHERE id=?";
	}

	@Override
	protected String getTableName() {
		return "addresses";
	}

	@Override
	protected void setUpUpdateQuery(Address entity) throws SQLException {
		update.setString(1, entity.getCountry());
		update.setString(2, entity.getCity());
		update.setString(3, entity.getPostalCode());
		update.setString(4, entity.getStreet());
		update.setString(5, entity.getHouseNumber());
		update.setString(6, entity.getLocalNumber());
		update.setInt(7, entity.getId());
	}

}
