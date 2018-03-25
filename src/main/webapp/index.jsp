<head>
    <%@include file="head.jsp"%>

<script>
    // script for parallax
    var elem = document.querySelector('.parallax');
    var instance = M.Parallax.init(elem, options);

    // for modal
    var elem = document.querySelector('.login');
    var instance = M.Modal.init(elem, options);

    // script for sidenav
    var elem = document.querySelector('.sidenav');
    var instance = M.Sidenav.init(elem, options);

    // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
    var collapsibleElem = document.querySelector('.collapsible');
    var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);
</script>

<head>
<html>
<header>
    <%@include file="navbar.jsp"%>
</header>

<body>
<%--<div class="container">--%>
<%--<h2>Lift Buddy Display</h2>--%>
    <div class="parallax-container">
        <div class="parallax"><img src="images/background_bar.jpg"></div>
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


<%-- TODO either work on making login modal functional --%>
<!-- Login Modal -->
<form>
<div id="login" class="modal">
    <%--<form>--%>

    <div class="modal-content">
        <%--<form>--%>
            <h4>Log In</h4>

            <div class="input-field col s12 m6 l6">
                <input type="text" class="form-control" name="loginUserName" id="loginUserName" aria-describedby="userNameHelp">
                <label for="loginUserName">User Name</label>
            </div>
            <div class="input-field col s12 m6 l6">
                <input type="text" class="form-control" name="loginPassword" id="loginPassword" aria-describedby="passwordHelp">
                <label for="loginPassword">Password</label>
            </div>

            <div class="right-align">
                <button class="btn waves-effect waves-light" type="submit" name="action">Login
                    <i class="material-icons right">send</i>
                </button>
            </div>
        <%--</form>--%>
    </div>
    <%--</form>--%>
</div>
</form>

<%--</div>--%>
<footer>
    <p>Hi there!</p>
</footer>

</body>
</html>