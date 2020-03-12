function displayEvents() {
    var table = document.getElementById('table-body');
    for (var i = 0; i < table.rows.length; i++) {
        table.rows[i].addEventListener('click', function () {
            if (document.getElementsByClassName("eventForm").length > 0) {
                document.getElementById("eventForm").remove();
            }
            let eventForm = document.createElement("form");
            eventForm.id = "eventForm";
            eventForm.style = "text-align: center"
            eventForm.className = "eventForm";

            for (var j = 0; j < this.cells.length; j++) {
                switch (j) {
                    case 0:
                        var div1 = document.createElement("div");
                        div1.className = "form-row";
                        let label = document.createElement("label");
                        label.innerHTML = "Event ID";
                        let eventID = document.createElement("input");
                        eventID.readOnly = true;
                        eventID.id = "eventID";
                        eventID.className = "form-control";
                        eventID.style = "text-align:center";
                        eventID.style = "width: 10%";
                        eventID.value = this.cells[j].innerHTML;
                        eventForm.appendChild(div1);
                        div1.appendChild(label);
                        div1.appendChild(eventID);
                        break;
                    case 1:
                    
                        let label0 = document.createElement("label");
                        label0.innerHTML = "Username";
                        let username = document.createElement("input");
                        username.readOnly = true;
                        username.id = "username";
                        username.className = "form-control";
                        username.style = "text-align:center";
                        username.style = "width: 10%";
                        username.value = this.cells[j].innerHTML;
                        div1.appendChild(label0);
                        div1.appendChild(username);
                        break;
                    case 2:
                        let label1 = document.createElement("label");
                        label1.innerHTML = "Description";
                        let eventDescription = document.createElement("input");
                        eventDescription.readOnly = true;
                        eventDescription.id = "eventDescription";
                        eventDescription.className = "form-control";
                        eventDescription.style = "text-align:center";
                        eventDescription.style = "width: 20%";
                        eventDescription.value = this.cells[j].innerHTML;
                        div1.appendChild(label1);
                        div1.appendChild(eventDescription);
                        break;
                    case 3:
                        let label2 = document.createElement("label");
                        label2.innerHTML = "Price";
                        let eventPrice = document.createElement("input");
                        eventPrice.readOnly = true;
                        eventPrice.id = "eventPrice";
                        eventPrice.className = "form-control";
                        eventPrice.style = "text-align:center";
                        eventPrice.style = "width: 10%";
                        eventPrice.value = "$" + this.cells[j].innerHTML;
                        div1.appendChild(label2);
                        div1.appendChild(eventPrice);
                        break;
                    case 4:
                        var div2 = document.createElement("div");
                        div2.className = "form-row";
                        let label3 = document.createElement("label");
                        label3.innerHTML = "City";
                        let eventCity = document.createElement("input");
                        eventCity.readOnly = true;
                        eventCity.id = "eventCity";
                        eventCity.className = "form-control";
                        eventCity.style = "text-align:center";
                        eventCity.style = "width: 10%";
                        eventCity.value = this.cells[j].innerHTML;
                        eventForm.appendChild(div2);
                        div2.appendChild(label3);
                        div2.appendChild(eventCity);
                        break;
                    case 5:
                        let label4 = document.createElement("label");
                        label4.innerHTML = "State";
                        let eventState = document.createElement("input");
                        eventState.readOnly = true;
                        eventState.id = "eventState";
                        eventState.className = "form-control";
                        eventState.style = "text-align:center";
                        eventState.style = "width: 10%";
                        eventState.value = this.cells[j].innerHTML;
                        div2.appendChild(label4);
                        div2.appendChild(eventState);
                        break;
                    case 6:
                        let label5 = document.createElement("label");
                        label5.innerHTML = "Zip Code";
                        let eventZipCode = document.createElement("input");
                        eventZipCode.readOnly = true;
                        eventZipCode.className = "form-control";
                        eventZipCode.id = "eventZipCode";
                        eventZipCode.style = "text-align:center";
                        eventZipCode.style = "width: 10%";
                        eventZipCode.value = this.cells[j].innerHTML;
                        div2.appendChild(label5);
                        div2.appendChild(eventZipCode);
                        break;
                    case 7:
                        var div3 = document.createElement("div");
                        div3.className = "form-row";
                        let label6 = document.createElement("label");
                        label6.innerHTML = "Start Date";
                        let eventStartDate = document.createElement("input");
                        eventStartDate.readOnly = true;
                        eventStartDate.id = "eventStartDate";
                        eventStartDate.className = "form-control";
                        eventStartDate.style = "text-align:center";
                        eventStartDate.style = "width: 10%";
                        eventStartDate.value = this.cells[j].innerHTML;
                        eventForm.appendChild(div3);
                        div3.appendChild(label6);
                        div3.appendChild(eventStartDate);
                        break;
                    case 8:
                        let label7 = document.createElement("label");
                        label7.innerHTML = "End Date";
                        let eventEndDate = document.createElement("input");
                        eventEndDate.readOnly = true;
                        eventEndDate.id = "eventEndDate";
                        eventEndDate.className = "form-control";
                        eventEndDate.style = "text-align:center";
                        eventEndDate.style = "width: 10%";
                        eventEndDate.value = this.cells[j].innerHTML;
                        div3.appendChild(label7);
                        div3.appendChild(eventEndDate);
                        break;
                    case 9:
                        let label8 = document.createElement("label");
                        label8.innerHTML = "Start Time";
                        let eventStartTime = document.createElement("input");
                        eventStartTime.readOnly = true;
                        eventStartTime.id = "eventStartTime";
                        eventStartTime.className = "form-control";
                        eventStartTime.style = "text-align:center";
                        eventStartTime.style = "width: 10%";
                        eventStartTime.value = this.cells[j].innerHTML;
                        div3.appendChild(label8);
                        div3.appendChild(eventStartTime);
                        break;
                    case 10:
                        let label9 = document.createElement("label");
                        label9.innerHTML = "End Time";
                        let eventEndTime = document.createElement("input");
                        eventEndTime.readOnly = true;
                        eventEndTime.id = "eventEndTime";
                        eventEndTime.className = "form-control";
                        eventEndTime.style = "text-align:center";
                        eventEndTime.style = "width: 10%";
                        eventEndTime.value = this.cells[j].innerHTML;
                        div3.appendChild(label9);
                        div3.appendChild(eventEndTime);
                        break;
                    case 11:
                        var div4 = document.createElement("div");
                        div4.className = "form-row";
                        let label10 = document.createElement("label");
                        label10.innerHTML = "Grading Format";
                        let eventGradingFormat = document.createElement("input");
                        eventGradingFormat.readOnly = true;
                        eventGradingFormat.id = "eventGradingFormat";
                        eventGradingFormat.className = "form-control";
                        eventGradingFormat.style = "text-align:center";
                        eventGradingFormat.style = "width: 15%";
                        eventGradingFormat.value = this.cells[j].innerHTML;
                        eventForm.appendChild(div4);
                        div4.appendChild(label10);
                        div4.appendChild(eventGradingFormat);
                        break;
                    case 12:
                        let label11 = document.createElement("label");
                        label11.innerHTML = "Type";
                        let eventType = document.createElement("input");
                        eventType.readOnly = true;
                        eventType.id = "eventType";
                        eventType.className = "form-control";
                        eventType.style = "text-align:center";
                        eventType.style = "width: 15%";
                        eventType.value = this.cells[j].innerHTML;
                        div4.appendChild(label11);
                        div4.appendChild(eventType);
                        break;
                    case 13:
                        let label12 = document.createElement("label");
                        label12.innerHTML = "Justification";
                        let eventJustification = document.createElement("input");
                        eventJustification.readOnly = true;
                        eventJustification.id = "eventJustification";
                        eventJustification.className = "form-control";
                        eventJustification.style = "text-align:center";
                        eventJustification.style = "width: 20%";
                        eventJustification.value = this.cells[j].innerHTML;
                        div4.appendChild(label12);
                        div4.appendChild(eventJustification);
                        break;
                }
                console.log(this.cells[j].innerHTML);
            }
            let approve = document.createElement("button");
            approve.type = "submit";
            approve.id = "approveButton";
            approve.className = "btn btn-success";
            approve.innerHTML = "Approve Request";
            let deny = document.createElement("button");
            deny.type = "submit";
            deny.id = "denyButton";
            deny.className = "btn btn-danger";
            deny.innerHTML = "Deny Request";
            eventForm.appendChild(approve);
            eventForm.appendChild(deny);
            document.body.appendChild(eventForm);
        });
    }
}