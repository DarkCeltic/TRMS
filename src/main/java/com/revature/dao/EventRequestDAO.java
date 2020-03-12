package com.revature.dao;

import java.util.List;

import com.revature.domain.Employee;
import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;

public interface EventRequestDAO {

	public List<EventRequest> retrieveAllEvents(Employee employee);

	public void insertEvent(EventRequest event) throws EventInsertionException;

	public List<EventRequest> retrieveApprovedEvents(Employee employee);

	public List<EventRequest> managerGetPendingEvents(Employee employee);
}
