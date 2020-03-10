package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.domain.Employee;
import com.revature.domain.User;
import com.revature.util.ConnectionFactory;

public class EmployeeDAOPostgres implements EmployeeDAO {

	private Connection conn = ConnectionFactory.getConnection();

	private static final String EMPLOYEE_TABLE = "employees";
	private static final String SELECT_EMPLOYEE_BY_USERNAME = "select * from " + EMPLOYEE_TABLE + " where username=?";

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_EMPLOYEE_BY_USERNAME);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				employee = new Employee();
				employee.setUserName(rs.getString(1));
				employee.setPassword(rs.getString(2));
				employee.setEmployeeLevel(rs.getInt(3));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
