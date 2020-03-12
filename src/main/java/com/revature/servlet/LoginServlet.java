package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.domain.Employee;
import com.revature.service.AuthenticationService;
import com.revature.service.AuthenticationServiceImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static AuthenticationService authService = new AuthenticationServiceImpl();
	private static Logger log = Logger.getRootLogger();

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: " + username + " Password: " + password);
		Employee employee = authService.validateEmployee(username, password);
		System.out.println("Employee: " + employee);
		if (employee == null) {
			response.setStatus(response.SC_UNAUTHORIZED);
		} else {
			log.info(username +" logged into the employee portal.");
			HttpSession sess = request.getSession(true);
			sess.setAttribute("employee", employee);
			response.sendRedirect("Basic_Employee_Page");
		}
	}
}
