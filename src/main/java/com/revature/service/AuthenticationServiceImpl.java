package com.revature.service;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOPostgres;
import com.revature.domain.Employee;

public class AuthenticationServiceImpl implements AuthenticationService {
	private static EmployeeDAO employeeDAO = new EmployeeDAOPostgres();

	@Override
	public Employee validateEmployee(String username, String password) {
		Employee employee = employeeDAO.getEmployeeByUsername(username);
		if (employee != null && employee.getPassword().equals(password)) {
			return employee;
		}
		return null;
	}
}
