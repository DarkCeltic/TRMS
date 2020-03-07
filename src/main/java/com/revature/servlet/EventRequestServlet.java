package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;
import com.revature.service.EventRequestService;
import com.revature.service.EventRequestServiceImpl;

public class EventRequestServlet extends HttpServlet {

	private EventRequestService eventService = new EventRequestServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<EventRequest> eventList = eventService.getAllEvents();
		String carListJSON = new GsonBuilder().create().toJson(eventList);
		PrintWriter pw = resp.getWriter();
		pw.write(carListJSON);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("THis should run");
		String eventJson = req.getReader().readLine();
		System.out.println(eventJson);
		EventRequest myEvent = new GsonBuilder().create().fromJson(eventJson, EventRequest.class);
		try {
			eventService.addEvent(myEvent);
			resp.getWriter().write("Success");
		} catch (EventInsertionException e) {
			resp.setStatus(resp.SC_INTERNAL_SERVER_ERROR);
			resp.getWriter().write("Event could not be created");
		}
		System.out.println("THis should run");

	}

	public void setEventService(EventRequestService eventService) {
		this.eventService = eventService;
	}

}
