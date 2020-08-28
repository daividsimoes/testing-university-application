package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;

public class Login implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("user-username");
		String password = request.getParameter("user-password");
		
		DataBase dataBase = new DataBaseFactory().getConnection();
		boolean isValidUser = dataBase.isValidUser(username, password);
		
		HttpSession session = request.getSession();
		
		if(isValidUser) {
			
			session.setAttribute("isLogged", true);
			return "redirect:main?action=CourseList";
		}
		
		session.setAttribute("isLogged", false);
		return "redirect:main?action=LoginForm";
	}
}