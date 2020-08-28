package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.testing.university.application.controller.database.DataBase;
import br.com.testing.university.application.controller.database.DataBaseFactory;
import br.com.testing.university.application.model.Account;

public class CreateAccount implements Actions {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("add-username");
		String password = request.getParameter("add-password");
		
		Account account = new Account(username, password);
		DataBase dataBase = new DataBaseFactory().getConnection();
		
		dataBase.addAccount(account);
		return "forward:loginform.jsp:";
	}
}