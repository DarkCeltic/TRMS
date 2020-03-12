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
import com.revature.service.EventRequestService;
import com.revature.service.EventRequestServiceImpl;

public class ApprovedEventsRequestServlet extends HttpServlet {

	private EventRequestService eventService = new EventRequestServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		System.out.println(sess.getAttribute("employee"));
		if (sess != null && sess.getAttribute("employee") != null) {
			List<EventRequest> eventList = eventService.getApprovedEvents((Employee)sess.getAttribute("employee"));
			String eventListJSON = new GsonBuilder().create().toJson(eventList);
			PrintWriter pw = resp.getWriter();
			pw.write(eventListJSON);
		} else {
			resp.getWriter().write("Employee not logged in");
			resp.setStatus(resp.SC_UNAUTHORIZED);
		}
	}
}
