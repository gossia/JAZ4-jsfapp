package repositories.impl;

import java.util.ArrayList;
import java.util.List;

import domain.*;
import repositories.ITeacherRepository;

public class DummyTeacherRepository implements ITeacherRepository {
	
	private DummyDb db;
	
	public DummyTeacherRepository(DummyDb db) {
		super();
		this.db = db;
	}

	@Override
	public void add(Teacher entity) {
		db.teachers.add(entity);
	}

	@Override
	public void update(Teacher entity) {
	}

	@Override
	public void delete(Teacher entity) {
		
		db.teachers.remove(entity);
		
	}

	@Override
	public Teacher get(int id) {
		
		for(Teacher t:db.teachers)
		{
			if(t.getId()==id)
				return t;
		}
		return null;
	}

	@Override
	public List<Teacher> getAll() {
		return db.teachers;
	}

	@Override
	public List<Teacher> ofLanguage(Language language) {
		return ofLanguage(language.getId());
	}

	@Override
	public List<Teacher> ofLanguage(String languageName) {
		
		for(Language l:db.languages)
		{
			if(l.getName()==languageName)
				return l.getTeachers();
		}
		return new ArrayList<Teacher>();
	}

	@Override
	public List<Teacher> ofLanguage(int languageId) {
		
		for(Language l:db.languages)
		{
			if(l.getId()==languageId)
				return l.getTeachers();
		}
		return new ArrayList<Teacher>();
	}
	
}
