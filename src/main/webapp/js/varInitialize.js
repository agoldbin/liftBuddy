//********************* Materialize Variables *********************\\
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

//************************* Functions *************************\\
// Function to validate user login
function userLoginValidation() {
    var userName = document.forms["loginForm"]["loginUserName"].value;
    var password = document.forms["loginForm"]["loginPassword"].value;

    window.alert(userName);
    console.log(userName);

}

// Function to validate user search

// Function to validate Admin search
