package repositories.impl;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IAddressRepository;

public class DummyAddressRepository implements IAddressRepository {
	
private DummyDb db;
	
	public DummyAddressRepository(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Address entity) {
		db.addresses.add(entity);	
	}
	
	@Override
	public void update(Address entity) {
	}

	@Override
	public void delete(Address entity) {
		db.addresses.remove(entity);
	}

	@Override
	public Address get(int id) {
		
		for(Address a:db.addresses)
		{
			if(a.getId()==id)
				return a;
		}
		return null;
	}

	@Override
	public List<Address> getAll() {
		return db.addresses;
	}

	@Override
	public List<Address> ofStudent(Student student) {
		return ofStudent(student.getId());
	}

	@Override
	public List<Address> ofStudent(int studentId) {
		
		for(Student s:db.students)
		{
			if(s.getId()==studentId)
				return s.getAddresses();
		}
		return new ArrayList<Address>();
	}

	@Override
	public List<Address> ofStudent(String studentFirstName,
			String studentLastName) {

		for(Student s:db.students)
		{
			if((s.getFirstName()==studentFirstName)&&(s.getLastName()==studentLastName))
				return s.getAddresses();
		}
		return new ArrayList<Address>();
	}
	
	

}
