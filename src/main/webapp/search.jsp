<%@include file="head.jsp"%>
<script>
    $(document).ready(function(){
        $('.parallax').parallax();
    });
    $(document).ready(function(){
        $('#login').modal();
    });
    $('#login').modal('open');
</script>

<html>
<header>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Lift Buddy</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="#">Home</a></li>
                <li class="active"><a href="search.jsp">Search</a></li>
                <li><a class="modal-trigger" href="#login">Login M</a></li>
                <li><a href="#">Sign Up</a></li>
            </ul>
        </div>
    </nav>
</header>

<body>
<%--<div class="container">--%>
<%--<h2>Lift Buddy Display</h2>--%>
    <div class="parallax-container">
        <div class="parallax"><img src="images/background_bar.jpg"></div>
    </div>
    <div class="section white">
        <div class="row container">

            <h2 class="header">Search</h2>
            <p class="grey-text text-darken-3 lighten-3">Parallax is an effect where the background content or image
                in this case, is moved at a different speed than the foreground content while scrolling.</p>

<%-- TODO Somewhere I need to add the functionality for users to search for other users within a specific radius
     I don't know if that means that I should convert the zip codes to long/lat and then search within a radius
     but that is one idea --%>

            <h2>Search form</h2>
            <form action="searchForm" class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control" name="searchTerm" id="searchTerm" aria-describedby="searchTermHelp" placeholder="Search">
                </div>
                <div class="form-group">
                    <label>Search by:</label>
                    <select class="form-control" name="searchType" id="searchType">
                        <option value="lastName">User Last Name</option>
                        <option value="gymName">Gym Name</option>
                    </select>
                </div>
                <button class="btn btn-primary" type="submit" name="submit" value="search">
                    Submit Search
                </button>
                <button class="btn btn-primary" type="submit" name="submit" value="viewAllGyms">
                    View All Gyms
                </button>
            </form>

        </div>
    </div>
    <div class="parallax-container">
        <div class="parallax"><img src="images/test3.jpg"></div>
    </div>


<!-- Login Modal -->
<div id="login" class="modal">
    <form>

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
    </form>
</div>

<%--</div>--%>
<footer>
    <p>Hi there!</p>
</footer>

</body>
</html>