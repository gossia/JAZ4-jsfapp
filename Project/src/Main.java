import java.sql.*;

import domain.*;
import repositories.*;
import repositories.impl.*;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the best language school!");
		
		String url = "jdbc:mysql://localhost:3306/";
		String user = "user";
		String password = "password";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(url, user, password);
			
			IUnitOfWork uow = new UnitOfWork(connection);
			
			
			Statement stmt = connection.createStatement();
			
			stmt.execute("CREATE DATABASE IF NOT EXISTS language_school");
			stmt.execute("USE language_school");
			stmt.execute("DROP TABLE IF EXISTS teachers");
			stmt.execute("DROP TABLE IF EXISTS students");
			stmt.execute("DROP TABLE IF EXISTS addresses");
			stmt.execute("DROP TABLE IF EXISTS languages");
			
			
			String createTeacherTable=
					"CREATE TABLE teachers ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "firstName VARCHAR(20),"
					+ "lastName VARCHAR(40)"
					+ ")";
			
			String createStudentTable=
					"CREATE TABLE students ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "firstName VARCHAR(20),"
					+ "lastName VARCHAR(40),"
					+ "pesel CHAR(11)"
					+ ")";
			
			String createAddressTable=
					"CREATE TABLE addresses ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "country VARCHAR(30),"
					+ "city VARCHAR(40),"
					+ "postalCode VARCHAR(10),"
					+ "street VARCHAR(40),"
					+ "houseNumber VARCHAR(10),"
					+ "localNumber VARCHAR(10)"
					+ ")";
			
			String createLanguageTable=
					"CREATE TABLE languages ("
					+ "id INT AUTO_INCREMENT PRIMARY KEY,"
					+ "name VARCHAR(20),"
					+ "level VARCHAR(20)"
					+ ")";
			
			stmt.executeUpdate(createTeacherTable); 
			stmt.executeUpdate(createStudentTable); 
			stmt.executeUpdate(createAddressTable);
			stmt.executeUpdate(createLanguageTable);
			
			
			IRepository<Teacher> teachers = new TeacherRepository(connection, new TeacherBuilder(), uow);
			IRepository<Student> students = new StudentRepository(connection, new StudentBuilder(), uow);
			IRepository<Address> addresses = new AddressRepository(connection, new AddressBuilder(), uow);
			IRepository<Language> languages = new LanguageRepository(connection, new LanguageBuilder(), uow);
			
			
			Student sluchacz1 = new Student();
			sluchacz1.setFirstName("Anna");
			sluchacz1.setLastName("Kowalska");
			sluchacz1.setPesel("82020212345");
			Student sluchacz2 = new Student();
			sluchacz2.setFirstName("Iwona");
			sluchacz2.setLastName("Iwonowska");
			sluchacz2.setPesel("72020212345");
			
			Teacher lektor1 = new Teacher();
			lektor1.setFirstName("Ewa");
			lektor1.setLastName("Wiœniewska");
			
			Language angielskiB1 = new Language();
			angielskiB1.setName("English");
			angielskiB1.setLevel("Intermediate");
			
			Address adres1 = new Address();
			adres1.setCountry("Polska");
			adres1.setCity("Gdañsk");
			adres1.setPostalCode("80-808");
			adres1.setStreet("Brzegi");
			adres1.setHouseNumber("55");
			adres1.setLocalNumber("1");
			
			
			//add
			
			students.add(sluchacz1);
			students.add(sluchacz2);
			teachers.add(lektor1);
			languages.add(angielskiB1);
			addresses.add(adres1);
			
			uow.commit();
			
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			System.out.println("Wszyscy nauczyciele w bazie:");
			for(Teacher fromDb : teachers.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName());
			
			System.out.println("Wszystkie jêzyki w bazie:");
			for(Language fromDb : languages.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getName()+" "+fromDb.getLevel());
			
			System.out.println("Wszystkie adresy w bazie:");
			for(Address fromDb : addresses.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getCountry()+", "+fromDb.getCity()+", "
				+fromDb.getPostalCode()+", "+fromDb.getStreet()+", "+fromDb.getHouseNumber()+"/"
				+fromDb.getLocalNumber());
			
			//update
			
			sluchacz2 = students.get(2);
			sluchacz2.setLastName("Piwonowska");
			students.update(sluchacz2);
			
			uow.commit();
			
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			//delete
			
			Student toDel = students.getAll().get(0);
			students.delete(toDel);
			
			uow.commit();
			
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			
			System.out.println("Student o id 2 to: "+students.get(2).getFirstName()+" "+students.get(2).getLastName());
			
			
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

