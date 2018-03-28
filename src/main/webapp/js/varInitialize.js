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

// // Initialize SIDENAV bar for headers
// $(document).ready(function(){
//     $('.sidenav').sidenav();
// });

//************************* Functions *************************\\
// Function to validate user login credentials
function userLoginValidation() {
    var userName = document.forms["loginForm"]["loginUserName"].value;
    var password = document.forms["loginForm"]["loginPassword"].value;

    window.alert(userName);
    console.log(userName);

}

// Function to validate user search

// Function to validate Admin search

// Function to check that new user passwords match
function checkPasswordMatch() {
    var password = $("#password").val();
    var confirmPassword = $("#confirmPassword").val();

    if (password != confirmPassword) {
        $("#divCheckPasswordMatch").html("<span class=\"badge red\">Passwords do not match</span>");
    } else {
        $("#divCheckPasswordMatch").html("<span class=\"badge blue\">Passwords match</span>");
    }
}
$(document).ready(function () {
    $("#password, #confirmPassword").keyup(checkPasswordMatch);
});
