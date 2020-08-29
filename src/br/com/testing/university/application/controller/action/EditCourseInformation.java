package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Course;

public class EditCourseInformation implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		
		String name = request.getParameter("course-name");
		int numStudents = Integer.parseInt(request.getParameter("course-max-students"));
		int load = Integer.parseInt(request.getParameter("course-load"));

		DataBase dataBase = new DataBaseFactory().getConnection();
		dataBase.updateCourse(courseId, name, numStudents, load);
		
		return "redirect:main?action=CourseInformation&courseId=" + courseId;
	}
}