package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Course;

public class DeleteCourse implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		
		DataBase dataBase = new DataBaseFactory().getConnection();
		Course course = dataBase.findCourseById(courseId);
		
		if(course != null){
			
			dataBase.deleteCourse(course);
		}
		
		return "redirect:main?action=CourseList";
	}
}