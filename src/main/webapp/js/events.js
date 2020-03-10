// window.onload = function () {
    this.document.getElementById("pendingEvent").addEventListener('click', showEvents);
// }

function showEvents() {
    document.getElementById("pendingEvent").disabled = true;
    document.getElementById("addEvent").disabled = false;
    document.getElementById("add_event_form").style.display = "none";
}