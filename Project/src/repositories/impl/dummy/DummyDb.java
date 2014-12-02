package repositories.impl.dummy;

import java.util.*;
import domain.*;

public class DummyDb {
	
	public List<Student> students;
	public List<Language> languages;
	public List<Teacher> teachers;
	public List<Address> addresses;
	
	public DummyDb()
	{
		students = new ArrayList<Student>();
		languages = new ArrayList<Language>();
		teachers = new ArrayList<Teacher>();
		addresses = new ArrayList<Address>();
	}

}
