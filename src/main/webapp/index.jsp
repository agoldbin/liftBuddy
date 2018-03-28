<%-- Jsp for the home screen --%>
<!DOCTYPE html>
<head>
    <%@include file="jsp/head.jsp"%>
    <script src="js/varInitialize.js"></script>
<head>

<html>
<body>

<header>
    <%@include file="jsp/navbar.jsp"%>
</header>

<%--<h2>Lift Buddy Display</h2>--%>
    <div class="parallax-container hide-on-large-and-up">
        <div class="parallax"><img src="images/background_bar_s.jpg"></div>
    </div>
    <div class="parallax-container hide-on-med-and-down">
        <div class="parallax"><img src="images/background_bar_m.jpg"></div>
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

    <%@include file="jsp/loginModal.jsp"%>

<footer>
    <%@include file="jsp/footer.jsp"%>
</footer>
</body>
</html>