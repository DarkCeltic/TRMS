package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.GsonBuilder;
import com.revature.domain.Employee;
import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;
import com.revature.service.EventRequestService;
import com.revature.service.EventRequestServiceImpl;

public class EventRequestServlet extends HttpServlet {

	private EventRequestService eventService = new EventRequestServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);

		if (sess != null && sess.getAttribute("employee") != null) {
			List<EventRequest> eventList = eventService.getAllEvents((Employee) sess.getAttribute("employee"));
			String eventListJSON = new GsonBuilder().create().toJson(eventList);
			PrintWriter pw = resp.getWriter();
			pw.write(eventListJSON);
		} else {
			resp.getWriter().write("Employee not logged in");
			resp.setStatus(resp.SC_UNAUTHORIZED);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if (sess != null && sess.getAttribute("employee") != null) {
			String eventJson = req.getReader().readLine();
			System.out.println("This is from eventJson " + eventJson);
			EventRequest myEvent = new GsonBuilder().setPrettyPrinting().create().fromJson(eventJson,
					EventRequest.class);
			try {
				eventService.addEvent(myEvent);
				resp.getWriter().write("Success");
			} catch (EventInsertionException e) {
				resp.setStatus(resp.SC_INTERNAL_SERVER_ERROR);
				resp.getWriter().write("Event could not be created");
			}
		} else {
			resp.getWriter().write("Employee not logged in");
			resp.setStatus(resp.SC_UNAUTHORIZED);
		}
	}

	public void setEventService(EventRequestService eventService) {
		this.eventService = eventService;
	}

}
