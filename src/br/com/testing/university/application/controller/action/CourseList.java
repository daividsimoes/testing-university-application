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

public class CourseList implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DataBase dataBase = new DataBaseFactory().getConnection();
		List<Course> courses = dataBase.getCourses();
		
		HttpSession session = request.getSession();
		session.setAttribute("courseList", courses);

		return "forward:courselist.jsp";
	}
}