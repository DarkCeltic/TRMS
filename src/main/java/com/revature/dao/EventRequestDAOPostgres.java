package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.domain.EventRequest;
import com.revature.exception.EventInsertionException;
import com.revature.util.ConnectionFactory;

public class EventRequestDAOPostgres implements EventRequestDAO {

	private Connection conn = ConnectionFactory.getConnection();

	private static final String EVENTS_TABLE = "events";
	private static final String SELECT_ALL_EVENTS = "select * from " + EVENTS_TABLE;
	private static final String INSERT_EVENTS = "insert into " + EVENTS_TABLE
			+ " (event_description, price, city, state, zip_code, start_date, end_date, "
			+ "start_time, end_time, grading_format_id, event_type_id, justification, "
			+ "username, final_grade) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public List<EventRequest> retrieveAllEvents() {
		// TODO Auto-generated method stub
		return null;
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
			stmt.setString(14, event.getFinalGrade());

		} catch (SQLException e) {
			EventInsertionException newE = new EventInsertionException();
			newE.initCause(e);
			throw newE;
		}
	}
}
