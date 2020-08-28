package br.com.testing.university.application.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testing.university.application.controller.action.Actions;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String actionParameter = request.getParameter("action");
		String className = "br.com.testing.university.application.controller.action.".concat(actionParameter);

		Actions actions;

		try {
			// Get the class object and create new instance of class
			actions = (Actions) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {

			throw new ServletException(e);
		}
		
		String redirectType = actions.execute(request, response);
		String[] typeAndAddress = redirectType.split(":");
		
		if(typeAndAddress[0].equals("forward")) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/views/".concat(typeAndAddress[1]));
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect(typeAndAddress[1]);
		}
	}
}