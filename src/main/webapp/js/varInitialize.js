// Initialize PARALLAX (used for styling of pages)
$(document).ready(function(){
    $('.parallax').parallax();
});

// Initialize MODAL (used for user login)
$(document).ready(function(){
    $('#login').modal();
});
$('#login').modal('open');

// Initialize SELECT boxes (used in forms)
$(document).ready(function() {
    $('select').material_select();
});

// Function to validate user login
function userLogin() {
    var userName = document.getElementById("loginUserName");
    var password = document.getElementById("loginPassword");

    window.alert(userName);
}

// Function to validate user search

// Function to validate Admin search
