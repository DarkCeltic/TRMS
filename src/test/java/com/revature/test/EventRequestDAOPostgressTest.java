package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.dao.EventRequestDAOPostgres;
import com.revature.domain.Employee;
import com.revature.domain.EventRequest;
import com.revature.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class EventRequestDAOPostgressTest {

	private static final String TEST_SCHEMA = "public";
	private static final String EVENTS_TABLE = "events";
	private static final String GET_ALL_SQL = "select * from " + EVENTS_TABLE
			+ " where username = ? AND EVENT_ID IN (SELECT EVENT_ID from EVENT_STATUS where pending = true)";

	private static final String GET_APPROVED_EVENTS = "SELECT * from EVENTS where username = ? "
			+ "AND EVENT_ID IN (SELECT EVENT_ID from EVENT_STATUS where pending = false)";

	private static final String GET_MANAGER_PENDING_EVENTS = "SELECT * from EVENTS where EVENT_ID IN (SELECT EVENT_ID from EVENT_STATUS where APPROVAL_STAGE = ?) AND \r\n"
			+ "event_id in (SELECT EVENT_ID from EVENT_STATUS where pending = true)";

	private EventRequestDAOPostgres eventDAO = new EventRequestDAOPostgres();

	private List<EventRequest> events = new ArrayList<EventRequest>();

	private List<EventRequest> approvedEvents = new ArrayList<EventRequest>();

//	private List<EventRequest> managerPendingEvents = new ArrayList<EventRequest>();

	Employee employee;
	Employee manager;

	@Mock
	private Connection conn;

	private PreparedStatement stmt;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		events.clear();

		events.add(new EventRequest("beet", 20, "Daleville", "AL", 36322, "2020-04-04", "2020-05-04", "19:00:00",
				"21:00:00", "1", "1", "ssdsf", "Rand", 2));

		approvedEvents.add(new EventRequest("Star Wars", 500, "Daleville", "AL", 36322, "2020-06-04", "2020-08-04",
				"20:00:00", "22:00:00", "2", "5", "SITH", "Rand", 17));

		employee = new Employee("Roy", "Anderson", "Rand", "ware", 1, 1000);

		manager = new Employee("Lonny", "Collins", "Lcol", "ware", 2, 1000);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getAllEventsTest() throws SQLException {
		Connection newConn = ConnectionFactory.getConnection();
		newConn.setSchema(TEST_SCHEMA);
		PreparedStatement stmt = newConn.prepareStatement(GET_ALL_SQL);
		stmt = Mockito.spy(stmt);
		when(conn.prepareStatement(GET_ALL_SQL)).thenReturn((PreparedStatement) stmt);
		eventDAO.setConn(conn);

		List<EventRequest> result = eventDAO.retrieveAllEvents(employee);

		verify(stmt).executeQuery();
		assertEquals("List should match expected", events, result);
	}

	@Test
	public void getApprovedEvents() throws SQLException {
		Connection newConn = ConnectionFactory.getConnection();
		newConn.setSchema(TEST_SCHEMA);
		PreparedStatement stmt = newConn.prepareStatement(GET_APPROVED_EVENTS);
		stmt = Mockito.spy(stmt);
		when(conn.prepareStatement(GET_APPROVED_EVENTS)).thenReturn((PreparedStatement) stmt);
		eventDAO.setConn(conn);

		List<EventRequest> result = eventDAO.retrieveApprovedEvents(employee);

		verify(stmt).executeQuery();
		assertEquals("List should match expected", approvedEvents, result);
	}

	@Test
	public void getManagerPendingEvents() throws SQLException {
		Connection newConn = ConnectionFactory.getConnection();
		newConn.setSchema(TEST_SCHEMA);
		PreparedStatement stmt = newConn.prepareStatement(GET_MANAGER_PENDING_EVENTS);
		stmt = Mockito.spy(stmt);
		when(conn.prepareStatement(GET_MANAGER_PENDING_EVENTS)).thenReturn((PreparedStatement) stmt);
		eventDAO.setConn(conn);

		List<EventRequest> result = eventDAO.managerGetPendingEvents(manager);

		verify(stmt).executeQuery();
		assertEquals("List should match expected", events, result);
	}
//	managerGetPendingEvents
}
