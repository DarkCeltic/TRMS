this.document.getElementById("managerRoles").addEventListener('click', managerRoles);

function managerRoles() {
    window.location.replace("/TRMS/page/Manager_Employee_Page.html");
    // let xhr = new XMLHttpRequest();
    // xhr.onreadystatechange = function () {
    // //     if (xhr.readyState === 4 && xhr.status === 200) {
    // //         let managerPage = JSON.parse(xhr.responseText);
    // //         console.log(managerPage);
    // //     }
    // // }
    // xhr.open("GET", "/TRMS/Manager_Employee_Page", true);
    // xhr.send();
}