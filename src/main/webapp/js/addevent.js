class Events {
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
    let eventDescription = document.getElementById("addevent_eventdescription").value;
    let price = document.getElementById("addevent_price").value;
    let city = document.getElementById("addevent_city").value;
    let state = document.getElementById("addevent_state").value;
    let zipCode = document.getElementById("addevent_zipcode").value;
    let startDate = document.getElementById("addevent_event_start_date").value;
    let endDate = document.getElementById("addevent_event_end_date").value;
    let startTime = document.getElementById("addevent_event_start_time").value;
    let endTime = document.getElementById("addevent_event_end_time").value;
    let gradingFormat = document.getElementById("addevent_gradingformat").value;
    let eventType = document.getElementById("addevent_eventtype").value;
    let justification = document.getElementById("addevent_justification").value;
    let username = document.getElementById("addevent_username").value;

    let newEvents = new Events(eventDescription, price, city, state,
        zipCode, startDate, endDate, startTime, endTime,
        gradingFormat, eventType, justification, username);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log("Success");
        }
    }
    xhr.open("POST", "/pendingEvents", true);
    xhr.send(JSON.stringify(newEvents));
}

window.onload = function () {
    this.document.getElementById("addEvent").addEventListener('click', add);
}

function add() {

    document.getElementById("addEvent").disabled = true;
    document.getElementById("add_event_form").style.display = "block";
    // document.getElementById("approvedTable").style.display = "none";
    document.getElementById("previousTable").style.display = "none";
    document.getElementById("pendingEventButton").disabled = false;
    document.getElementById("approvedEvent").disabled = false;
    document.getElementById("previousEvent").disabled = false;
    // let list = document.getElementsByClassName("list-form");
    // if (list.empty !== undefined) {
    //     for (let index = list.length; index >= 0; index++) {
    //         list[0].remove();
    //     }
    // }
    let list = document.getElementsByClassName("list-form");
    jQuery.isEmptyObject(list); 
    if ($("#table-body tr").length > 0) {
        for (let index = list.length; index > 0; index--) {
            list[0].remove();
        }
    }
}

window.addEventListener('load', function () {
    let one_week = new Date(+new Date + 6.048e+8);
    let year = one_week.getUTCFullYear();
    let day = one_week.getDate();
    var month = one_week.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    let one_week_from_now = year + "-" + month + "-" + day;
    let date = document.getElementsByName("event_start_date")[0];
    date.min = one_week_from_now;
    date.val = one_week_from_now;

    let end_date = document.getElementsByName("event_end_date")[0];
    end_date.min = one_week_from_now;
    end_date.val = one_week_from_now;
});

$(document).ready(function () {
    $('#addevent_firstname').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    });
    $('#addevent_lastname').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_username').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_event_start_date').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_event_end_date').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_event_start_time').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_event_end_time').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_city').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_state').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_zipcode').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_eventdescription').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_price').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_gradingformat').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_eventtype').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    }); $('#addevent_justification').on('input', function () {
        var input = $(this);
        var is_name = input.val();
        if (is_name) {
            input.removeClass("invalid").addClass("valid");
        } else {
            input.removeClass("valid").addClass("invalid");
        }
    });
});

$("#submitEvent").click(function (event) {
    var form_data = $("#add_event_form").serializeArray();
    var error_free = true;
    for (var input in form_data) {
        var element = $("#addevent_" + form_data[input]['name']);
        var valid = element.hasClass("valid");
        var error_element = $("span", element.parent());
        if (!valid) {
            error_element.removeClass("error").addClass("error_show");
            error_free = false;
            // console.log("This shouldnt run");
        } else {
            error_element.removeClass("error_show").addClass("error");
        }
    }
    if (!error_free) {
        event.preventDefault();
    }
    else {
        event.preventDefault();
        let gradingFormat = $('#addevent_gradingformat');
        let eventType = $('#addevent_eventtype');
        if (gradingFormat.val() === null || eventType.val() === null) {
            if (gradingFormat.val() === null) {
                $("#gradingformat").removeClass("error").addClass("error_show");
            }
            else {
                $("#eventtyoe").removeClass("error").addClass("error_show");
            }
        } else {
            addEvent();
        }
    }
});