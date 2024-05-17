// Get the modal
var modal = document.getElementById("loginModal");

var btn = document.getElementById("openLoginBtn");

var span = document.getElementsByClassName("closeBtn")[0];

btn.onclick = function() {
    modal.style.display = "block";
}

span.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        alert("Esta é uma mensagem de alerta!");
        modal.style.display = "none";

    }
}
