import domain.*;
import repositories.*;
import repositories.impl.*;

import java.sql.*;
import java.util.List;

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
			
			ITeacherRepository teachers = new TeacherRepository(connection);
			IStudentRepository students = new StudentRepository(connection);
			IAddressRepository addresses = new AddressRepository(connection);
			ILanguageRepository languages = new LanguageRepository(connection);
			
			
			
			Student sluchacz1 = new Student();
			sluchacz1.setFirstName("Anna");
			sluchacz1.setLastName("Kowalska");
			sluchacz1.setPesel("82020212345");
			
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
			

			//teachers
			teachers.add(lektor1);
			List<Teacher> teachersfromDb = teachers.getAll();
			for(Teacher fromDb : teachersfromDb)
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName());
			Teacher lektor2 = teachers.get(1);
			lektor2.setLastName("Nowak");
			teachers.update(lektor2);
			Teacher toDelete = teachersfromDb.get(0);
			teachers.delete(toDelete);
			for(Teacher fromDb : teachers.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName());
			
			//students
			students.add(sluchacz1);
			sluchacz1 = students.get(1);
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			Student sluchacz2 = new Student();
			students.add(sluchacz2);
			sluchacz2 = students.get(2);
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			sluchacz2.setFirstName("Iwona");
			sluchacz2.setLastName("Iwonowska");
			sluchacz2.setPesel("85050512345");
			students.update(sluchacz2);
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			System.out.println("Student o id 1 to: "+students.get(1).getFirstName()+" "+students.get(1).getLastName());
			
			students.delete(sluchacz2);
			//Student toDel = students.getAll().get(0);
			//students.delete(toDel);
			
			System.out.println("Wszyscy studenci w bazie:");
			for(Student fromDb : students.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getFirstName()+" "+fromDb.getLastName()+" "
				+fromDb.getPesel());
			
			//addresses
			addresses.add(adres1);
			adres1 = addresses.get(1);
			System.out.println("Wszystkie adresy w bazie:");
			for(Address fromDb : addresses.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getCountry()+", "+fromDb.getCity()+", "
				+fromDb.getPostalCode()+", "+fromDb.getStreet()+", "+fromDb.getHouseNumber()+"/"
				+fromDb.getLocalNumber());
			
			adres1.setLocalNumber("22");
			addresses.update(adres1);
			System.out.println("Wszystkie adresy w bazie:");
			for(Address fromDb : addresses.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getCountry()+", "+fromDb.getCity()+", "
				+fromDb.getPostalCode()+", "+fromDb.getStreet()+", "+fromDb.getHouseNumber()+"/"
				+fromDb.getLocalNumber());
			
			//languages
			languages.add(angielskiB1);
			angielskiB1 = languages.get(1);
			Language angielskiB2 = new Language();
			angielskiB2.setName("English");
			angielskiB2.setLevel("Upper-Intermediate");
			languages.add(angielskiB2);
			angielskiB2 = languages.get(2);
			System.out.println("Wszystkie jêzyki w bazie:");
			for(Language fromDb : languages.getAll())
				System.out.println(fromDb.getId()+" "+fromDb.getName()+" "+fromDb.getLevel());
			
			
			
			/*
			// table teacher
			stmt.execute("DROP TABLE IF EXISTS teacher");
			stmt.execute("CREATE TABLE teacher (" +
					"id INT AUTO_INCREMENT PRIMARY KEY," +
					"firstname VARCHAR(20)," +
					"lastname VARCHAR(40)" +
					")");
			stmt.execute("INSERT INTO teacher (firstname, lastname) VALUES" +
			"('Janina', 'Nowak'), " +
			"('Anna', 'Kowalska'), " +
			"('Jan', 'Kowalski'), " +
			"('Ewa', 'Kowalska')" +
			"");
			
			ResultSet result1 = stmt.executeQuery("SELECT * FROM Teacher WHERE " +
			"lastname = 'Kowalska' or lastname = 'Kowalski'");
			System.out.println("");
			System.out.println("List of teachers by lastname:");
			while (result1.next())
			{
				System.out.println(result1.getString("firstname") + " " + result1.getString("lastname"));
			}
			
			//table language
			stmt.execute("DROP TABLE IF EXISTS language");
			stmt.execute("CREATE TABLE language (" +
					"id INT AUTO_INCREMENT PRIMARY KEY," +
					"name VARCHAR(40)" +
					")");
			stmt.execute("INSERT INTO language (name) VALUES" +
			"('English'), " +
			"('German')" +
			"");
			
			ResultSet result2 = stmt.executeQuery("SELECT * FROM language");
			System.out.println("");
			System.out.println("List of languages:");
			while (result2.next())
			{
				System.out.println(result2.getString("name"));
			}
			*/
			
			
			stmt.close();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}

