package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Course;
import br.com.testing.university.application.model.Student;

public class StudentInformation implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int registrationNumber = Integer.parseInt(request.getParameter("studentRegistrationNumber"));

		DataBase dataBase = new DataBaseFactory().getConnection();
		Course course = dataBase.findCourseById(courseId);
		Student student = dataBase.findStudentByCourseAndId(course, registrationNumber);

		if (student != null) {

			HttpSession session = request.getSession();
			session.setAttribute("student", student);
		}

		return "forward:studentinformation.jsp";
	}
}