package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.revature.domain.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeeDAOPostgres implements EmployeeDAO {
	private static Logger log = Logger.getRootLogger();

	private Connection conn = ConnectionFactory.getConnection();

	private static final String EMPLOYEE_TABLE = "employees";
	private static final String SELECT_EMPLOYEE_BY_USERNAME = "select username, password, employee_level from "
			+ EMPLOYEE_TABLE + " where username=?";

	@Override
	public Employee getEmployeeByUsername(String username) {
		Employee employee = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_EMPLOYEE_BY_USERNAME);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				employee = new Employee();
				employee.setUsername(rs.getString(1));
				employee.setPassword(rs.getString(2));
				employee.setEmployeeLevel(rs.getInt(3));
				log.info(employee.getUsername() + " information was retrieved from the database.");
			}
		} catch (Exception e) {
			log.error("The system has experienced a fatal defect: "+e);
			e.printStackTrace();
		}

		return employee;
	}

}
