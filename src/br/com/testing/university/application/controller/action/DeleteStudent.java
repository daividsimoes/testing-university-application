package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Course;
import br.com.testing.university.application.model.Student;

public class DeleteStudent implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int registrationNumber = Integer.parseInt(request.getParameter("studentRegistrationNumber"));

		DataBase dataBase = new DataBaseFactory().getConnection();
		Course course = dataBase.findCourseById(courseId);
		Student student = dataBase.findStudentByCourseAndId(course, registrationNumber);

		if (student != null) {

			dataBase.deleteStudent(course, student);
		}

		return "redirect:main?action=StudentList&courseId=" + course.getId();
	}
}