package com.revature.service;

import com.revature.domain.Employee;

public interface AuthenticationService {

	public Employee validateEmployee(String username, String password);

}
