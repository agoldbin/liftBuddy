<%-- Search page for Admins --%>
<!DOCTYPE html>
<head>
    <%@include file="head.jsp"%>
    <script src="js/varInitialize.js"></script>
</head>

<html>

<body>
<header>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Lift Buddy</a>
            <a href="#" data-target="nav-mobile-admin" class="sidenav-trigger hide-on-med-and-up"><i class="material-icons">menu</i></a>
            <ul id="nav-admin" class="right hide-on-med-and-down show-on-large">
                <li class="active"><a href="#">ADMIN PAGE BABY!</a></li>
                <li><a href="index.jsp">Home</a></li>
                <li ><a href="search.jsp">Search</a></li>
                <%--<li><a class="modal-trigger" href="#login" data-target="login">Login M</a></li>--%>
                <li><a href="#">Admin Logout</a></li>
            </ul>

            <ul id="nav-mobile-admin" class="sidenav hide-on-med-and-up">
                <li class="active"><a href="#">ADMIN PAGE BABY!</a></li>
                <li><a href="index.jsp">Home</a></li>
                <li ><a href="search.jsp">Search</a></li>
                <%--<li><a class="modal-trigger" href="#login" data-target="login">Login M</a></li>--%>
                <li><a href="#">Admin Logout</a></li>
            </ul>
        </div>
    </nav>
</header>

    <div class="parallax-container hide-on-med-and-up">
        <div class="parallax"><img src="images/background_bar_s.jpg"></div>
    </div>
    <div class="parallax-container hide-on-small-and-down show-on-medium-and-up">
        <div class="parallax"><img src="images/background_bar_m.jpg"></div>
    </div>
    <div class="section white">
        <div class="row container">

            <h2 class="header">ADMIN SEARCH PAGE!</h2>
            <p class="grey-text text-darken-3 lighten-3">Parallax is an effect where the background content or image
                in this case, is moved at a different speed than the foreground content while scrolling.</p>

            <h2>Search form</h2>
            <form action="searchForm" class="form-inline">
                <div class="valign-wrapper">
                    <div class="input-field col m6">
                        <input type="text" class="form-control" name="searchTerm" id="searchTerm" aria-describedby="searchTermHelp">
                        <label for="searchTerm">Search</label>
                    </div>
                    <div class="input-field col s6 m3">
                        <select name="searchType" id="searchType">
                            <option value="" disabled="disabled">Search by:</option>
                            <option value="id">User ID</option>
                            <option value="userName">User Last Name</option>
                            <option value="gymName">Gym Name</option>
                        </select>
                    </div>
                    <div class="col s6 m3">
                        <button class="btn btn-primary" type="submit" name="submit" value="search">
                            Submit Search
                        </button>
                    </div>
                </div>
                <h4 align="center-align">OR</h4>
                <div class="center-align col s12">
                    <button class="btn btn-primary" type="submit" name="submit" value="viewAllUsers">
                        View All Users
                    </button>
                    <button class="btn btn-primary" type="submit" name="submit" value="viewAllGyms">
                        View All Gyms
                    </button>
                </div>
            </form>

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
    // Initialize SIDENAV bar for headers
    $(document).ready(function(){
        $('.sidenav').sidenav();
    });
</script>
</body>
</html>