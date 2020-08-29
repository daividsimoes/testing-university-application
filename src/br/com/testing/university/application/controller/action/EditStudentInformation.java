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

public class EditStudentInformation implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataBase dataBase = new DataBaseFactory().getConnection();
		HttpSession session = request.getSession();
		Course course = (Course) session.getAttribute("course");
		int registrationNumber = Integer.parseInt(request.getParameter("registrationNumber"));

		String name = request.getParameter("student-name");
		String email = request.getParameter("student-email");
		Gender gender = Gender.valueOf(request.getParameter("student-gender"));
		int age = Integer.parseInt(request.getParameter("student-age"));

		dataBase.updateStudent(course, registrationNumber, name, email, age, gender);

		return "redirect:main?action=StudentInformation&studentRegistrationNumber=" + registrationNumber + "&courseId="
				+ course.getId();
	}
}