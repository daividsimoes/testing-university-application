package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Course;

public class CourseInformation implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		
		DataBase dataBase = new DataBaseFactory().getConnection();
		Course course = dataBase.findCourseById(courseId);
		
		if(course != null){
			
			HttpSession session = request.getSession();
			session.setAttribute("course", course);
		}
		
		return "forward:courseinformation.jsp";
	}
}