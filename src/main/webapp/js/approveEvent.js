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

    let eventApproval = new Events(eventID, username);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Success");
        }
    }
    xhr.open("POST", "/Manager", true);
    xhr.send(JSON.stringify(eventApproval)); 
}

document.getElementById("approveButton").addEventListener('click', approveEvent);