package br.com.testing.university.application.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class represents a course entity
 * 
 * @author Daivid
 * 
 */
public class Course {

	private static final String COURSE_EMAIL = "@testinguniversity.com";
	private int studentRegistrationNumber = 1;
	private int id;
	private String name;
	private int studentNumber;
	private int courseLoad;
	private List<Student> students;

	public Course(String name, int courseLoad, int studentNumber) {

		this.name = name;
		this.courseLoad = courseLoad;
		this.studentNumber = studentNumber;
		this.students = new ArrayList<Student>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getCourseLoad() {
		return this.courseLoad;
	}

	public void setCourseLoad(int courseLoad) {
		this.courseLoad = courseLoad;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	/**
	 * Add new student in the course
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {
		String email = student.getName().replaceAll("\\s+", "").toLowerCase().concat(COURSE_EMAIL);

		student.setEmail(email);
		student.setRegistrationNumber(studentRegistrationNumber++);
		students.add(student);
	}
}