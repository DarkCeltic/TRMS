window.onload = function () {
    this.document.getElementById("addEvent").addEventListener('click', add);
}

function add() {
    document.getElementById("addEvent").disabled = true;
    document.getElementById("add_event_form").style.display = "block";
}

$("#submitEvent").click(function(e) {
    e.preventDefault();
});

// submitEvent

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

    let end_date = document.getElementsByName("event_end_date")[0];
    end_date.min = one_week_from_now;
});


    //your code right here;


// function insertListItem() {
//     var listItem = document.getElementById("userInput").value;
//     var list = document.createElement("li");
//     list.id = listItem;
//     list.draggable = true;
//     list.className = "column"
//     list.innerHTML = listItem;
//     document.getElementById("toDo").appendChild(list);
//     enableButtons();
//     removeButtons();
//     var cols = document.querySelectorAll('#toDo .column');
//     [].forEach.call(cols, addDnDHandlers);
// }

// function remove() {
//     disableButtons()
//     var addItem = document.createElement("label");
//     addItem.innerHTML = "Item to Add <br>";
//     addItem.id = "addIt";
//     document.getElementById("itemListManipulator").appendChild(addItem);

//     var input = document.createElement("input");
//     input.id = "userInput";
//     input.placeholder = "Enter Item";
//     document.getElementById("itemListManipulator").appendChild(input);

//     var submit = document.createElement("button");
//     submit.onclick = removeListItem;
//     submit.id = "id";
//     submit.innerHTML = "Submit";
//     document.getElementById("itemListManipulator").appendChild(submit);
// }

// function removeListItem() {
//     var listItem = document.getElementById("userInput").value;
//     var itemToRemove = document.getElementById(listItem);
//     itemToRemove.remove();
//     enableButtons();
//     removeButtons();
// }

// function moveUp() {
//     disableButtons()
//     var addItem = document.createElement("label");
//     addItem.innerHTML = "Item to Add <br>";
//     addItem.id = "addIt";
//     document.getElementById("itemListManipulator").appendChild(addItem);

//     var input = document.createElement("input");
//     input.id = "userInput";
//     input.placeholder = "Enter Item";
//     document.getElementById("itemListManipulator").appendChild(input);

//     var move = document.createElement("label");
//     move.innerHTML = "Move Position to: <br>";
//     move.id = "move";
//     document.getElementById("itemListManipulator").appendChild(move);

//     var movePosition = document.createElement("input");
//     movePosition.id = "itemPosition";
//     movePosition.placeholder = "Enter the position to move the item to";
//     document.getElementById("itemListManipulator").appendChild(movePosition);

//     var submit = document.createElement("button");
//     submit.onclick = moveItemUp;
//     submit.id = "id";
//     submit.innerHTML = "Submit";
//     document.getElementById("itemListManipulator").appendChild(submit);
// }

// function moveItemUp() {
//     // Get user Input
//     var inputfromUser = document.getElementById("userInput").value;
//     var positionInput = document.getElementById("itemPosition").value;
//     var number = parseInt(positionInput, 10);
//     // Get the list item with id of user input
//     var itemToRemove = document.getElementById(inputfromUser);// grabbing the item to remove
//     var copy = document.createElement("li");// Make a copy of the list item
//     copy.innerHTML = inputfromUser;
//     copy.id = inputfromUser;
//     //Remove the old list item position
//     itemToRemove.remove();
//     var allListItems = document.getElementById("toDo");
//     //move the new list item to the new position
//     allListItems.insertBefore(copy, allListItems.childNodes[3]);
//     enableButtons();
//     removeButtons();
//     removePositionButton();

//     // let list = document.getElementById("asdf");
//     // let copy = document.createElement("li");
//     // copy.innerHTML = list.childNodes[item].innerHTML;
//     // list.removeChild(list.childNodes[item]);
//     // list.insertBefore(copy, list.childNodes[position]);

//     // item and position are passed in
// }
// function moveDown() { }


// // function disableButtons() {
// //     document.getElementById("addItem").disabled = true;
// //     document.getElementById("removeItem").disabled = true;
// //     document.getElementById("moveUp").disabled = true;
// //     document.getElementById("moveDown").disabled = true;
// // }

// function enableButtons() {
//     document.getElementById("addItem").disabled = false;
//     document.getElementById("removeItem").disabled = false;
//     document.getElementById("moveUp").disabled = false;
//     document.getElementById("moveDown").disabled = false;
// }

// function removeButtons() {
//     var addItem = document.getElementById("addIt");
//     addItem.remove();
//     var input = document.getElementById("userInput");
//     input.remove();
//     var submit = document.getElementById("id");
//     submit.remove();
// }

// function removePositionButton() {
//     var move = document.getElementById("move");
//     move.remove();
//     var movePosition = document.getElementById("itemPosition");
//     movePosition.remove();
// }
