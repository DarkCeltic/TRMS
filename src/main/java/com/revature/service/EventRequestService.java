package com.revature.service;

import java.util.List;

import com.revature.dao.EventRequestDAO;
import com.revature.domain.Employee;
import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;

public interface EventRequestService {

	public List<EventRequest> getAllEvents(Employee employee);

	public void addEvent(EventRequest event) throws EventInsertionException;
	
	public void setEventRequestDao(EventRequestDAO eventDao);

	public List<EventRequest> getApprovedEvents(Employee employee);

	public List<EventRequest> managerGetPendingEvents(Employee attribute);

}
