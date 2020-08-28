package br.com.testing.university.application.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Actions {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}