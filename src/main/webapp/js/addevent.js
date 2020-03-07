class Event {
    constructor(eventDescription, price, city, state,
        zipCode, startDate, endDate, startTime, endTime,
        gradingFormat, eventType, justification, username) {
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
}

function addEvent() {
    event.preventDefault();
    console.log("This should run");
    let eventDescription = document.getElementById("eventDescription").value;
    console.log(document.getElementById("price").value + " " +
        document.getElementById("price").value + " " +
        document.getElementById("city").value + " " +
        document.getElementById("state").value + " " +
        document.getElementById("zipCode").value + " " +
        document.getElementById("startDate").value + " " +
        document.getElementById("endDate").value + " " +
        document.getElementById("startTime").value + " " +
        document.getElementById("endTime").value + " " +
        document.getElementById("gradingFormat").value + " " +
        document.getElementById("eventType").value + " " +
        document.getElementById("justification").value + " " +
        document.getElementById("username").value);
    // let price = document.getElementById("price").value;
    // let city = document.getElementById("city").value;
    // let state = document.getElementById("state").value;
    // let zipCode = document.getElementById("zipCode").value;
    // let startDate = document.getElementById("startDate").value;
    // let endDate = document.getElementById("endDate").value;
    // let startTime = document.getElementById("startTime").value;
    // let endTime = document.getElementById("endTime").value;
    // let gradingFormat = document.getElementById("gradingFormat").value;
    // let eventType = document.getElementById("eventType").value;
    // let justification = document.getElementById("justification").value;
    // let username = document.getElementById("username ").value;

    let events = new Event(eventDescription, price, city, state,
        zipCode, startDate, endDate, startTime, endTime,
        gradingFormat, eventType, justification, username);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Success");
        }
    }
    xhr.open("POST", "/TRMS/event_request", true);
    xhr.send(JSON.stringify(events));
}

window.onload = function () {
    this.document.getElementById("submitEvent").addEventListener("click", addEvent, false);
}