package repositories;

public interface IRepositoryCatalog {
	
	public IStudentRepository getStudents();
	public ILanguageRepository getLanguages();
	public ITeacherRepository getTeachers();
	public IAddressRepository getAddresses();

}
