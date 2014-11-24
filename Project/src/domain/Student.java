package domain;

import java.util.ArrayList;
import java.util.List;

public class Student extends Entity {
	
	public Student()
	{
		this.addresses=new ArrayList<Address>();
		this.languages=new ArrayList<Language>();
	}
	
	private String firstName;
	private String lastName;
	private String pesel;
	
	private List<Address> addresses;
	private List<Language> languages;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

}
