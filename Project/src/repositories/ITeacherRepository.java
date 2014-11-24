package repositories;

import java.util.List;
import domain.*;

public interface ITeacherRepository extends IRepository<Teacher> {
	
	public List<Teacher> ofLanguage(Language language);
	public List<Teacher> ofLanguage(int languageId);
	public List<Teacher> ofLanguage(String languageName);
}
