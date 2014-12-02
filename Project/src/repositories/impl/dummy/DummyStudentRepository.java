package repositories.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.IStudentRepository;

public class DummyStudentRepository implements IStudentRepository{
	
	private DummyDb db;
	
	public DummyStudentRepository(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Student entity) {
		db.students.add(entity);
	}

	@Override
	public void update(Student entity) {
	}

	@Override
	public void delete(Student entity) {
		db.students.remove(entity);
	}

	@Override
	public Student get(int id) {
		
		for(Student s:db.students)
		{
			if(s.getId()==id)
				return s;
		}
		return null;
	}

	@Override
	public List<Student> getAll() {
		return db.students;
	}

	@Override
	public List<Student> byLanguage(Language language) {
		return byLanguage(language.getId());
	}

	@Override
	public List<Student> byLanguage(String languageName) {
		
		for(Language l:db.languages)
		{
			if(l.getName()==languageName)
				return l.getStudents();
		}
		return new ArrayList<Student>();
	}

	@Override
	public List<Student> byLanguage(int languageId) {
		
		for(Language l:db.languages)
		{
			if(l.getId()==languageId)
				return l.getStudents();
		}
		return new ArrayList<Student>();
	}

	@Override
	public Student byAddress(Address address) {
		return byAddress(address.getId());
	}

	@Override
	public Student byAddress(int addressId) {
		
		for(Address a:db.addresses)
		{
			if(a.getId()==addressId)
				return a.getStudent();
		}
		return null;
	}

	@Override
	public Student byAddress(String street, String houseNumber,
			String localNumber, String postalCode, String city, String country) {
		
		for(Address a:db.addresses)
		{
			if((a.getStreet()==street)&&(a.getHouseNumber()==houseNumber)&&(a.getLocalNumber()==localNumber)&&(a.getPostalCode()==postalCode)&&(a.getCity()==city)&&(a.getCountry()==country))
				return a.getStudent();
		}
		
		return null;
	}
	
}
