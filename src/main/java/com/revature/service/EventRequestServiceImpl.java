package com.revature.service;

import java.util.List;

import org.w3c.dom.events.EventException;

import com.revature.dao.EventRequestDAO;
import com.revature.dao.EventRequestDAOPostgres;
import com.revature.domain.Employee;
import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;

public class EventRequestServiceImpl implements EventRequestService {
	
	private EventRequestDAO eventDAO = new EventRequestDAOPostgres();

	@Override
	public List<EventRequest> getAllEvents(Employee employee) {
		return eventDAO.retrieveAllEvents(employee);
	}

	@Override
	public void addEvent(EventRequest event) throws EventInsertionException {
		eventDAO.insertEvent(event);
	}
	
	public void setEventRequestDao(EventRequestDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

	@Override
	public List<EventRequest> getApprovedEvents(Employee employee) {
		return eventDAO.retrieveApprovedEvents(employee);
	}

	@Override
	public List<EventRequest> managerGetPendingEvents(Employee employee) {
		return eventDAO.managerGetPendingEvents(employee);
	}

}
