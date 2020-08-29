package br.com.testing.university.application.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Course;
import br.com.testing.university.application.model.Student;

public class StudentList implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String courseId = request.getParameter("courseId");

		DataBase dataBase = new DataBaseFactory().getConnection();
		Course course = dataBase.findCourseById(Integer.parseInt(courseId));

		if (course != null) {
			
			HttpSession session = request.getSession();
			List<Student> list = course.getStudents();
			session.setAttribute("course", course);
			session.setAttribute("studentList", list);
		}

		return "forward:studentlist.jsp";
	}
}