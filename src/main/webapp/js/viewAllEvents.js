document.getElementById("viewAllPendingEvents").addEventListener('click', showAllPendingEvents);

function showAllPendingEvents() {
    document.getElementById("add_event_form").style.display = "none";
    document.getElementById("previousTable").style.display = "block";
    // document.getElementById("approvedTable").style.display = "none";
    // document.getElementById("pendingEventButton").disabled = true;
    let list = document.getElementsByClassName("list-form");
    if ($("#table-body tr").length > 0) {
        for (let index = list.length; index > 0; index--) {
            list[0].remove();
        }
    }
    getAllPendingEventList();
}

function getAllPendingEventList() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            let eventList = JSON.parse(xhr.responseText);
            console.log(eventList);
            displayAllPendingEventList(eventList);
        }
    }
    xhr.open("GET", "/TRMS/Manager", true);
    xhr.send();
}

function displayAllPendingEventList(eventList) {
    if (eventList === "<h1>Employee is not a manager</h1>") {
        let div = document.createElement("div");
        div.innerHTML = eventList;
        div.style.color = "red";
        document.getElementById("options").appendChild(div);
    }
    else {
        for (let event of eventList) {
            let row = document.createElement("tr");
            row.className = "list-form";
            row.id = "pendingEventsRows";
            let eventDescription = document.createElement("td");
            let price = document.createElement("td");
            let city = document.createElement("td");
            let state = document.createElement("td");
            let zipCode = document.createElement("td");
            let startDate = document.createElement("td");
            let endDate = document.createElement("td");
            let startTime = document.createElement("td");
            let endTime = document.createElement("td");
            let gradingFormat = document.createElement("td");
            let eventType = document.createElement("td");
            let justification = document.createElement("td");
            let username = document.createElement("td");
            // let active = document.createElement("td");
            let event_id = document.createElement("td");

            event_id.innerHTML = event.event_id;
            eventDescription.innerHTML = event.eventDescription;
            price.innerHTML = event.price;
            city.innerHTML = event.city;
            state.innerHTML = event.state;
            zipCode.innerHTML = event.zipCode;
            startDate.innerHTML = event.startDate;
            endDate.innerHTML = event.endDate;
            startTime.innerHTML = event.startTime;
            endTime.innerHTML = event.endTime;
            gradingFormat.innerHTML = event.gradingFormat;
            eventType.innerHTML = event.eventType;
            justification.innerHTML = event.justification;
            username.innerHTML = event.username;
            // active.innerHTML = event.active;

            row.appendChild(event_id);
            row.appendChild(username);
            row.appendChild(eventDescription);
            row.appendChild(price);
            row.appendChild(city);
            row.appendChild(state);
            row.appendChild(zipCode);
            row.appendChild(startDate);
            row.appendChild(endDate);
            row.appendChild(startTime);
            row.appendChild(endTime);
            row.appendChild(gradingFormat);
            row.appendChild(eventType);
            row.appendChild(justification);
            // row.appendChild(active);
            document.getElementById("table-body").appendChild(row);
        }
        displayEvents();
    }
}