package com.revature.dao;

import java.util.List;

import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;

public interface EventRequestDAO {

public List<EventRequest> retrieveAllEvents();
	
	public void insertEvent(EventRequest event) throws EventInsertionException;
}
