package repositories;

import java.util.List;

import domain.*;

public interface ILanguageRepository extends IRepository<Language> {
	
	public Language ofTeacher(Teacher teacher);
	public Language ofTeacher(int teacherId);
	public Language ofTeacher(String teacherFirstName, String teacherLastName);
	
	public List<Language> ofStudent(Student student);
	public List<Language> ofStudent(int studentId);
	public List<Language> ofStudent(String studentFirstName, String studentLastName);

}
