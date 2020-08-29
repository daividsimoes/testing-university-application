package br.com.testing.university.application.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/main")
public class AutenticationFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String actionParameter = req.getParameter("action");

		if (actionParameter == null) {

			resp.sendRedirect("main?action=LoginForm");
			return;
		}

		boolean isLoginRequired = !(actionParameter.equals("LoginForm") || actionParameter.equals("Login")
				|| actionParameter.equals("CreateAccountForm") || actionParameter.equals("CreateAccount"));

		boolean isLogged = false;
		HttpSession session = req.getSession();

		if ((session.getAttribute("isLogged") != null)) {
			isLogged = (Boolean) session.getAttribute("isLogged");
		}

		if (isLoginRequired && !isLogged) {

			resp.sendRedirect("main?action=LoginForm");
			return;
		}

		chain.doFilter(req, resp);
	}
}