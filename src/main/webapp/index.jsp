<!DOCTYPE html>
<head>
    <%@include file="head.jsp"%>
<head>

<html>
<body>

<header>
    <%@include file="navbar.jsp"%>
</header>

<%--<div class="container">--%>
<%--<h2>Lift Buddy Display</h2>--%>
    <div class="parallax-container">
        <div class="parallax"><img src="/images/background_bar.jpg"></div>
    </div>
    <div class="section white">
        <div class="row container">

            <h2 class="header">Parallax</h2>
            <p class="grey-text text-darken-3 lighten-3">Parallax is an effect where the background content or image
                in this case, is moved at a different speed than the foreground content while scrolling.</p>
            <a href="adminSearch.jsp">Click here to search! (Admin only)</a>


        </div>
    </div>
    <div class="parallax-container">
        <div class="parallax"><img src="/images/test3.jpg"></div>
    </div>

<footer>
    <p>Hi there!</p>
</footer>

<script>
    $(document).ready(function(){
        $('.parallax').parallax();
    });
    $(document).ready(function(){
        $('#login').modal();
    });
    $('#login').modal('open');
    // // script for parallax
    // var elem = document.querySelector('.parallax');
    // var instance = M.Parallax.init(elem, options);
    //
    // // for modal
    // var elem = document.querySelector('.login');
    // var login = M.Modal.init(elem, options);
    // login.open();
    //
    // // script for sidenav
    // var elem = document.querySelector('.sidenav');
    // var instance = M.Sidenav.init(elem, options);
    //
    // // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
    // var collapsibleElem = document.querySelector('.collapsible');
    // var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);
</script>

</body>
</html>