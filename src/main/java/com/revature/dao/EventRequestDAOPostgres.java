package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.domain.Employee;
import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;
import com.revature.util.ConnectionFactory;

public class EventRequestDAOPostgres implements EventRequestDAO {

	private static Logger log = Logger.getRootLogger();

	private Connection conn = ConnectionFactory.getConnection();

	private static final String EVENTS_TABLE = "events";

	private static final String EVENT_STATUS = "event_status";

	private static final String EMPLOYEES_TABLE = "employees";

	private static final String SELECT_ALL_EVENTS = "select * from " + EVENTS_TABLE
			+ " where username = ? AND EVENT_ID IN (SELECT EVENT_ID from EVENT_STATUS where pending = true)";

	private static final String INSERT_EVENTS = "insert into " + EVENTS_TABLE
			+ " (event_description, price, city, state, zip_code, start_date, end_date, "
			+ "start_time, end_time, grading_format_id, event_type_id, justification, "
			+ "username) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String GET_EMPLOYEE_LEVEL = "select employee_level from " + EMPLOYEES_TABLE
			+ " where username=?";

	private static final String GET_EVENT_ID = "select event_id from " + EVENTS_TABLE
			+ " where username=? and start_date=? and event_description=?";

	private static final String SET_EVENT_STATUS = "insert into " + EVENT_STATUS
			+ "(event_id, approval_stage) values(?,?)";

	private static final String SET_EVENT_STATUS_URGENT = "insert into " + EVENT_STATUS
			+ "(event_id, approval_stage, urgent) values(?,?,?)";

	private static final String GET_APPROVED_EVENTS = "SELECT * from EVENTS where username = ? "
			+ "AND EVENT_ID IN (SELECT EVENT_ID from EVENT_STATUS where pending = false)";

	private static final String GET_MANAGER_PENDING_EVENTS = "SELECT * from EVENTS where EVENT_ID IN (SELECT EVENT_ID from EVENT_STATUS where APPROVAL_STAGE = ?) AND \r\n"
			+ "event_id in (SELECT EVENT_ID from EVENT_STATUS where pending = true)";

	private static final String MANAGER_APPROVE_EVENT = "update EVENT_STATUS set APPROVAL_STAGE = APPROVAL_STAGE + 1 where EVENT_ID = ?";

	private static final String GET_CURRENT_APPROVAL_LEVEL = "select APPROVAL_STAGE from EVENT_STATUS where EVENT_ID = ?";

	private static final String SET_PENDING_FALSE = "update event_status set pending = false where EVENT_ID = ?";

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public List<EventRequest> retrieveAllEvents(Employee employee) {
		List<EventRequest> eventsList = new ArrayList<EventRequest>();
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_EVENTS);
			stmt.setString(1, employee.getUsername());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				eventsList.add(new EventRequest(rs.getString("event_description"), rs.getInt("price"),
						rs.getString("city"), rs.getString("state"), rs.getInt("zip_code"), rs.getString("start_date"),
						rs.getString("end_date"), rs.getString("start_time"), rs.getString("end_time"),
						rs.getString("grading_format_id"), rs.getString("event_type_id"), rs.getString("justification"),
						rs.getString("username"), rs.getInt("event_id")));
			}
			log.info("All events have been retrieved by " + employee.getUsername());
		} catch (Exception e) {
			log.error("The system has experienced a fatal defect " + e);
			e.printStackTrace();
		}
		return eventsList;
	}

	public void insertEvent(EventRequest event) throws EventInsertionException {
		try {
			PreparedStatement stmt = conn.prepareStatement(INSERT_EVENTS);
			stmt.setString(1, event.getEventDescription());
			stmt.setInt(2, event.getPrice());
			stmt.setString(3, event.getCity());
			stmt.setString(4, event.getState());
			stmt.setInt(5, event.getZipCode());
			stmt.setDate(6, event.getStartDate());
			stmt.setDate(7, event.getEndDate());
			stmt.setTime(8, event.getStartTime());
			stmt.setTime(9, event.getEndTime());
			stmt.setInt(10, event.getGradingFormat());
			stmt.setInt(11, event.getEventType());
			stmt.setString(12, event.getJustification());
			stmt.setString(13, event.getUsername());
			stmt.executeUpdate();

			log.info("The event " + event + " has been submitted to the database.");

			// This gets the employee_level for the submitted event request
			stmt = conn.prepareStatement(GET_EMPLOYEE_LEVEL);
			stmt.setString(1, event.getUsername());
			ResultSet rs = stmt.executeQuery();
			int employeeLevel = 0;
			while (rs.next()) {
				employeeLevel = rs.getInt("employee_level");
			}

			// This gets the event id for the recently submitted event based on username,
			// start_date and description match.
			stmt = conn.prepareStatement(GET_EVENT_ID);
			stmt.setString(1, event.getUsername());
			stmt.setDate(2, event.getStartDate());
			stmt.setString(3, event.getEventDescription());

			rs = stmt.executeQuery();
			int eventId = 0;
			while (rs.next()) {
				eventId = rs.getInt("event_id");
			}

			Period intervalPeriod = Period.between(LocalDate.now(), event.getStartDate().toLocalDate());

			if (intervalPeriod.getDays() < 14) {
				stmt = conn.prepareStatement(SET_EVENT_STATUS_URGENT);
				stmt.setInt(1, eventId);
				stmt.setInt(2, employeeLevel + 1);
				stmt.setBoolean(3, true);
				stmt.executeUpdate();
			} else {
				stmt = conn.prepareStatement(SET_EVENT_STATUS);
				stmt.setInt(1, eventId);
				stmt.setInt(2, employeeLevel + 1);
				stmt.executeUpdate();
			}
			// TODO change this so that the BenCO department head needs approval from one
			// below
		} catch (SQLException e) {
			log.error("There has been a fatal error in the system " + e);
			e.printStackTrace();
			EventInsertionException newE = new EventInsertionException();
			newE.initCause(e);
			throw newE;
		}
	}

	@Override
	public List<EventRequest> retrieveApprovedEvents(Employee employee) {
		List<EventRequest> approvedEventsList = new ArrayList<EventRequest>();
		try {
			PreparedStatement stmt = conn.prepareStatement(GET_APPROVED_EVENTS);
			stmt.setString(1, employee.getUsername());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				approvedEventsList.add(new EventRequest(rs.getString("event_description"), rs.getInt("price"),
						rs.getString("city"), rs.getString("state"), rs.getInt("zip_code"), rs.getString("start_date"),
						rs.getString("end_date"), rs.getString("start_time"), rs.getString("end_time"),
						rs.getString("grading_format_id"), rs.getString("event_type_id"), rs.getString("justification"),
						rs.getString("username"), rs.getInt("event_id")));
			}
			log.info(employee.getUsername() + " retreived all of their approved events");
		} catch (Exception e) {
			log.error("There has been a fatal error in the system " + e);
			e.printStackTrace();
		}
		return approvedEventsList;
	}

	@Override
	public List<EventRequest> managerGetPendingEvents(Employee employee) {
		List<EventRequest> managerPendingEvents = new ArrayList<EventRequest>();
		try {
			PreparedStatement stmt = conn.prepareStatement(GET_MANAGER_PENDING_EVENTS);
			stmt.setInt(1, employee.getEmployeeLevel());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				managerPendingEvents.add(new EventRequest(rs.getString("event_description"), rs.getInt("price"),
						rs.getString("city"), rs.getString("state"), rs.getInt("zip_code"), rs.getString("start_date"),
						rs.getString("end_date"), rs.getString("start_time"), rs.getString("end_time"),
						rs.getString("grading_format_id"), rs.getString("event_type_id"), rs.getString("justification"),
						rs.getString("username"), rs.getInt("event_id")));
			}
			log.info("Manager " + employee.getUsername() + " has retrieved all pending events");
		} catch (Exception e) {
			log.error("There has been a fatal error in the system " + e);
			e.printStackTrace();
		}
		return managerPendingEvents;
	}

	@Override
	public void approveEvent(EventRequest myEvent) {
		try {
			int employeeLevel = 0;
			int currentApprovalLevel = 0;
			PreparedStatement stmt = conn.prepareStatement(GET_EMPLOYEE_LEVEL);
			stmt.setString(1, myEvent.getUsername());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employeeLevel = rs.getInt("employee_level");
			}
			stmt = conn.prepareStatement(GET_CURRENT_APPROVAL_LEVEL);
			stmt.setInt(1, myEvent.getEvent_id());
			rs = stmt.executeQuery();
			while (rs.next()) {
				currentApprovalLevel = rs.getInt("approval_stage");
			}
			// for employee levels 1-3 that go up to Benco approval
			if (employeeLevel < 4) {
				if (currentApprovalLevel + 1 > 4) {
					stmt = conn.prepareStatement(SET_PENDING_FALSE);
					stmt.setInt(1, myEvent.getEvent_id());
					stmt.executeUpdate();
				} else {
					stmt = conn.prepareStatement(MANAGER_APPROVE_EVENT);
					stmt.setInt(1, myEvent.getEvent_id());
					stmt.executeUpdate();
				}
				// if benco is not a department head
			} else if (employeeLevel == 4 || employeeLevel == 5) {
				if (currentApprovalLevel + 1 > 6) {
					stmt = conn.prepareStatement(SET_PENDING_FALSE);
					stmt.setInt(1, myEvent.getEvent_id());
					stmt.executeUpdate();
				} else {
					stmt = conn.prepareStatement(MANAGER_APPROVE_EVENT);
					stmt.setInt(1, myEvent.getEvent_id());
					stmt.executeUpdate();
				}
			} else {
				if (employeeLevel == 6 && currentApprovalLevel == 5) {
					stmt = conn.prepareStatement(SET_PENDING_FALSE);
					stmt.setInt(1, myEvent.getEvent_id());
					stmt.executeUpdate();
				}
			}
			log.info("Event ID: " + myEvent.getEvent_id() + " has been approved by a manager");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
