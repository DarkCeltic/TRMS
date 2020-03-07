package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
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
import com.revature.domain.EventRequest;
import com.revature.util.ConnectionFactory;

@RunWith(MockitoJUnitRunner.class)
public class EventRequestDAOPostgressTest {

	private static final String TEST_SCHEMA = "TRMS-test";

	private static final String GET_ALL_SQL = "select * from events";

	private static final String INSERT_INTO_SQL = "insert into " + TEST_SCHEMA + " ";

	private EventRequestDAOPostgres eventDAO = new EventRequestDAOPostgres();

	private List<EventRequest> events = new ArrayList<EventRequest>();

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
		LocalDate startDate = LocalDate.now();
		LocalDate endDate = startDate.plusDays(5);

		LocalTime startTime = LocalTime.now();
		LocalTime endTime = startTime.plusHours(2);

		events.add(new EventRequest("Beet Farming", 500, "Tampa", "FL", 79584, startDate, endDate, startTime, endTime,
				"Letter Grade", "University Course", "Need this class to move up", "Rand"));
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

		List<EventRequest> result = eventDAO.retrieveAllEvents();

		verify(stmt).executeQuery();
		assertEquals("List should match expected", events, result);
	}
}
