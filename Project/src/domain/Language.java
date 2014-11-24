package domain;

import java.util.ArrayList;
import java.util.List;

public class Language extends Entity {
	
	public Language()
	{
		this.students=new ArrayList<Student>();
		this.teachers=new ArrayList<Teacher>();
	}
	
	private String name;
	private String level;
	
	private List<Student> students;
	private List<Teacher> teachers;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
		

}
