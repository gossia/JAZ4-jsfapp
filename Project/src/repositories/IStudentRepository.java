package repositories;

import java.util.List;

import domain.*;

public interface IStudentRepository extends IRepository<Student> {
	
	public List<Student> byLanguage(Language language);
	public List<Student> byLanguage(int languageId);
	public List<Student> byLanguage(String languageName);
	public Student byAddress(Address address);
	public Student byAddress(int addressId);
	public Student byAddress(String street, String houseNumber, String localNumber, String postalCode, String city, String country);
	
}

