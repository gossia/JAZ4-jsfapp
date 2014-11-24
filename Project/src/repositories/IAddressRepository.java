package repositories;

import java.util.List;
import domain.*;

public interface IAddressRepository extends IRepository<Address> {
	
	public List<Address> ofStudent(Student student);
	public List<Address> ofStudent(int studentId);
	public List<Address> ofStudent(String studentFirstName, String studentLastName);

}
