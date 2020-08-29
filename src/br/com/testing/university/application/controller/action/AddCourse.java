package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Course;

public class AddCourse implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("course-name");
		int courseLoad = Integer.parseInt(request.getParameter("course-loa"));
		int maxStudents = Integer.parseInt(request.getParameter("couse-max-student"));
		
		Course course = new Course(name, courseLoad, maxStudents);
		DataBase dataBase = new DataBaseFactory().getConnection();
		
		dataBase.addCourse(course);
		
		return "redirect:main?action=CourseList";
	}
}