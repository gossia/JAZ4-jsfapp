package repository;

import domain.Address;

public class DummyAddressRepository {
	
	private DummyDb db;
	
	public DummyAddressRepository(DummyDb db){
		this.db = db;
	}
	
	public void add(Address entity){
		db.addresses.add(entity);
	}
	
	public void delete(Address entity){
		db.addresses.remove(entity);
	}
	

}
