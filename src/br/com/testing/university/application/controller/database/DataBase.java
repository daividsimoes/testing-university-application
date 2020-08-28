package br.com.testing.university.application.controller.database;

import java.util.ArrayList;
import java.util.List;

import br.com.testing.university.application.enums.Gender;
import br.com.testing.university.application.model.Account;
import br.com.testing.university.application.model.Course;
import br.com.testing.university.application.model.Student;

/**
 * Simulate a Data Base
 * 
 * @author Daivid
 *
 */
public class DataBase {

	public static final String USER_ADMIN = "admin";
	public static final String PASSWORD_ADMIN = "admin";
	private static int idCourse = 1;
	private static List<Course> courses = new ArrayList<>();
	private static List<Account> accounts = new ArrayList<>();

	/**
	 * Create a default account when starting the application
	 */
	static {

		Account account = new Account(USER_ADMIN, PASSWORD_ADMIN);
		accounts.add(account);
	}

	/**
	 * Check if username and password is valid
	 * 
	 * @param username
	 * @param password
	 * @return boolean indicating if user exists in database or not
	 */
	public boolean isValidUser(String username, String password) {

		Account loginAccount = new Account(username, password);

		for (Account account : accounts) {
			if (account.equals(loginAccount))
				return true;
		}

		return false;
	}

	/**
	 * Add new account
	 * 
	 * @param account
	 */
	public void addAccount(Account account) {

		accounts.add(account);
	}

	/**
	 * Add new course
	 * 
	 * @param course
	 */
	public void addCourse(Course course) {

		course.setStudentNumber(course.getStudentNumber() + 1);
		course.setId(DataBase.idCourse++);
		DataBase.courses.add(course);
	}

	/**
	 * Delete a specific course
	 * 
	 * @param course
	 */
	public void deleteCourse(Course course) {
		DataBase.courses.remove(course);
	}

	/**
	 * Retrieve all courses
	 * 
	 * @return list of courses
	 */
	public List<Course> getCourses() {

		return DataBase.courses;
	}

	/**
	 * Find a specific course by id
	 * 
	 * @param courseId
	 * @return the course
	 */
	public Course findCourseById(int courseId) {

		return getCourses().stream()
				.filter(course -> (course.getId() == courseId))
				.findFirst()
				.orElse(null);
	}

	/**
	 * Update course data
	 * 
	 * @param courseId
	 * @param name
	 * @param studentNumber
	 * @param courseLoad
	 */
	public void updateCourse(int courseId, String name, int studentNumber, int courseLoad) {

		Course course = findCourseById(courseId);

		if (course != null) {
			course.setName(name);
			course.setCourseLoad(courseLoad);

			if (course.getStudents().size() <= (studentNumber)) {
				course.setStudentNumber(studentNumber);
			}
		}
	}

	/**
	 * Add new student in the course
	 * 
	 * @param course
	 * @param student
	 */
	public void addStudent(Course course, Student student) {

		course.addStudent(student);
	}

	/**
	 * Delete a student from course
	 * 
	 * @param course
	 * @param student
	 */
	public void deleteStudent(Course course, Student student) {
		course.getStudents().remove(student);
	}

	/**
	 * Retrieve all students from course
	 * 
	 * @param course
	 * @return
	 */
	public List<Student> getStudents(Course course) {

		return course.getStudents();
	}

	/**
	 * Find a specific student from course
	 * 
	 * @param course
	 * @param registrationNumber
	 * @return
	 */
	public Student findStudentByCourseAndId(Course course, int registrationNumber) {

		return getStudents(course).stream()
				.filter(s -> s.getRegistrationNumber() == (registrationNumber))
				.findFirst()
				.orElse(null);
	}

	/**
	 * Update student data
	 * 
	 * @param course
	 * @param registrationNumber
	 * @param name
	 * @param email
	 * @param age
	 * @param gender
	 */
	public void updateStudent(Course course, int registrationNumber, String name, String email, int age,
			Gender gender) {

		Student student = findStudentByCourseAndId(course, registrationNumber);

		if (student != null) {

			student.setName(name);
			student.setEmail(email.toLowerCase());
			student.setAge(age);
			student.setGender(gender);
		}
	}
}