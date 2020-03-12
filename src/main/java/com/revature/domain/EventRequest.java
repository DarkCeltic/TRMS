package com.revature.domain;

import java.sql.Date;
import java.sql.Time;

public class EventRequest {
	private String eventDescription;
	private int price;
	private String city;
	private String state;
	private int zipCode;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private String gradingFormat;
	private String eventType;
	private String justification;
	private String username;
	private String finalGrade;
	private boolean active;
	private int event_id;

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public Date getStartDate() {
		return java.sql.Date.valueOf(startDate);
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return java.sql.Date.valueOf(endDate);
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Time getStartTime() {
		return java.sql.Time.valueOf(startTime + ":00");
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return java.sql.Time.valueOf(endTime + ":00");
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	// TODO change this to read from the database
	public int getGradingFormat() {
		switch (gradingFormat) {
		case "Letter Grade":
			return 1;
		case "Pass/Fail":
			return 2;
		case "Presentation":
			return 3;
		}
		return 0;
	}

	public String setGradingFormat(String gradingFormat) {
//		this.gradingFormat = gradingFormat;
		switch (gradingFormat) {
		case "1":
			return "Letter Grade";
		case "2":
			return "Pass/Fail";
		case "3":
			return "Presentation";
		}
		return null;
	}

	// TODO change this to read from the database
	public int getEventType() {
		switch (eventType) {
		case "University Course":
			return 1;
		case "Seminar":
			return 2;
		case "Certification Prep":
			return 3;
		case "Certification":
			return 4;
		case "Technical Training":
			return 5;
		case "Other":
			return 6;
		}

		return 0;
	}

	public String setEventType(String eventType) {
//		this.eventType = eventType;
		switch (eventType) {
		case "1":
			return "University Course";
		case "2":
			return "Seminar";
		case "3":
			return "Certification Prep";
		case "4":
			return "Certification";
		case "5":
			return "Technical Training";
		case "6":
			return "Other";
		}

		return null;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((eventDescription == null) ? 0 : eventDescription.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((finalGrade == null) ? 0 : finalGrade.hashCode());
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + price;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + zipCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventRequest other = (EventRequest) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (eventDescription == null) {
			if (other.eventDescription != null)
				return false;
		} else if (!eventDescription.equals(other.eventDescription))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (finalGrade == null) {
			if (other.finalGrade != null)
				return false;
		} else if (!finalGrade.equals(other.finalGrade))
			return false;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (price != other.price)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventRequest [eventDescription=" + eventDescription + ", price=" + price + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", startDate=" + startDate + ", endDate=" + endDate + ", startTime="
				+ startTime + ", endTime=" + endTime + ", gradingFormat=" + gradingFormat + ", eventType=" + eventType
				+ ", justification=" + justification + ", username=" + username + ", finalGrade=" + finalGrade + "]";
	}

	public EventRequest(String eventDescription, int price, String city, String state, int zipCode, String startDate,
			String endDate, String startTime, String endTime, String gradingFormat, String eventType,
			String justification, String username) {
		this.eventDescription = eventDescription;
		this.price = price;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.username = username;
	}

	public EventRequest(String username, int event_id) {
		this.username = username;
		this.event_id = event_id;
	}

	public EventRequest(String eventDescription, int price, String city, String state, int zipCode, String startDate,
			String endDate, String startTime, String endTime, String gradingFormat, String eventType,
			String justification, String username, int event_id) {
		this.eventDescription = eventDescription;
		this.price = price;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.gradingFormat = setGradingFormat(gradingFormat);
		this.eventType = setEventType(eventType);
		this.justification = justification;
		this.username = username;
		this.event_id = event_id;
	}

	public EventRequest() {
		super();
	}
}
