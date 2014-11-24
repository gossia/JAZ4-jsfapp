package repositories.impl;

import repositories.*;

public class DummyRepositoryCatalog implements IRepositoryCatalog {
	
	private DummyDb db = new DummyDb();

	@Override
	public IStudentRepository getStudents() {
		return new DummyStudentRepository(db);
	}

	@Override
	public ILanguageRepository getLanguages() {
		return new DummyLanguageRepository(db);
	}

	@Override
	public ITeacherRepository getTeachers() {
		return new DummyTeacherRepository(db);
	}

	@Override
	public IAddressRepository getAddresses() {
		return new DummyAddressRepository(db);
	}
	
	

}
