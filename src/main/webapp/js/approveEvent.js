class Events {
    constructor(eventID, username) {
       this.eventID = eventID;
        this.username = username;
    }
}

function approveEvent() {
    event.preventDefault();

    let eventID = document.getElementById("eventID").value;
    let username = document.getElementById("username").value;

    let approveEvent = new Events(eventID, username);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Success");
        }
    }
    xhr.open("POST", "/Manager", true);
    xhr.send(JSON.stringify(approveEvent));
}

this.document.getElementById("approveButton").addEventListener('click', approveEvent);