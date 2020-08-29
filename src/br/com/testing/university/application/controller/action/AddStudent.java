package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.enums.Gender;
import br.com.testing.university.application.model.Course;
import br.com.testing.university.application.model.Student;

public class AddStudent implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Course course = (Course) session.getAttribute("course");

		if (course.getStudents().size() < course.getStudentNumber()) {

			String name = request.getParameter("sname");
			int age = Integer.parseInt(request.getParameter("sage"));
			Gender gender = Gender.valueOf(request.getParameter("gender"));
			Student student = new Student(name, age, gender);

			DataBase dataBase = new DataBaseFactory().getConnection();
			dataBase.addStudent(course, student);

			return "redirect:main?action=StudentList&courseId=" + course.getId();
		} else {

			return "forward:addstudenterror.jsp";
		}
	}
}