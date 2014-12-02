package repositories.impl.dummy;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.ILanguageRepository;

public class DummyLanguageRepository implements ILanguageRepository {
	
private DummyDb db;
	
	public DummyLanguageRepository(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Language entity) {
		db.languages.add(entity);
	}

	@Override
	public void update(Language entity) {
	}

	@Override
	public void delete(Language entity) {
		db.languages.remove(entity);
	}

	@Override
	public Language get(int id) {
		
		for(Language l:db.languages)
		{
			if(l.getId()==id)
				return l;
		}
		return null;
	}

	@Override
	public List<Language> getAll() {
		return db.languages;
	}

	@Override
	public List<Language> ofStudent(Student student) {
		return ofStudent(student.getId());
	}

	@Override
	public List<Language> ofStudent(String studentFirstName, String studentLastName) {
		
		for(Student s:db.students)
		{
			if((s.getFirstName()==studentFirstName) && (s.getLastName()==studentLastName))//?
				return s.getLanguages();
		}
		return new ArrayList<Language>();
	}

	@Override
	public List<Language> ofStudent(int studentId) {
		
		for(Student s:db.students)
		{
			if(s.getId()==studentId)
				return s.getLanguages();
		}
		return new ArrayList<Language>();
	}
	
	
	@Override
	public Language ofTeacher(Teacher teacher) {
		return ofTeacher(teacher.getId());
	}

	@Override
	public Language ofTeacher(String teacherFirstName, String teacherLastName) {
		
		for(Teacher t:db.teachers)
		{
			if((t.getFirstName()==teacherFirstName) && (t.getLastName()==teacherLastName))//?
				return t.getLanguage();
		}
		return null;
	}

	@Override
	public Language ofTeacher(int teacherId) {
		
		for(Teacher t:db.teachers)
		{
			if(t.getId()==teacherId)
				return t.getLanguage();
		}
		return null;
	}
	
}
