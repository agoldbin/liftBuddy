<%-- Jsp for the home screen --%>
<!DOCTYPE html>
<head>
    <%@include file="head.jsp"%>
    <script src="js/init.js"></script>
<head>

<html>
<body>

<%@include file="navbar.jsp"%>

<%--<h2>Lift Buddy Display</h2>--%>
    <div class="parallax-container">
        <div class="parallax show-on-large"><img src="images/background_bar_m.jpg"></div>
        <div class="parallax show-on-medium-and-down"><img src="images/background_bar_s.jpg"></div>
        <%--<div class="parallax background-l"><img src="images/background_bar_m.jpg"></div>--%>
        <%--<div class="parallax background-s"><img src="images/background_bar_s.jpg"></div>--%>
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
        <div class="parallax"><img src="images/test3.jpg"></div>
    </div>

    <%@include file="loginModal.jsp"%>

<footer>
    <%@include file="footer.jsp"%>
</footer>

<script>
    // // Initialize SIDENAV bar for headers
    // $(document).ready(function(){
    //     $('.sidenav').sidenav();
    // });

    // Initialize MODAL (used for user login)
    $(document).ready(function(){
        $('#loginModal').modal();
    });
    $('#loginModal').modal('open');
</script>
</body>
</html>