package repository;

import domain.User;

public class DummyUserRepository {
	
	private DummyDb db;
	
	public DummyUserRepository(DummyDb db){
		this.db = db;
	}
	
	public void add(User entity){
		db.users.add(entity);
	}
	
	public void delete(User entity){
		db.users.remove(entity);
	}
	

}
