<%@include file="head.jsp"%>
<script>
    $(document).ready(function(){
        $('.parallax').parallax();
    });
    $(document).ready(function(){
        $('.login').modal();
    });
</script>

<html>
<header>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Lift Buddy</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Search</a></li>
                <li><a href="#login">Login</a></li>
                <li><a href="#">Sign Up</a></li>
            </ul>
        </div>
    </nav>
</header>

<body>
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

            <h2>Search form</h2>
            <form action="searchForm" class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control" name="searchTerm" id="searchTerm" aria-describedby="searchTermHelp" placeholder="Search">
                </div>
                <div class="form-group">
                    <label>Search by:</label>
                    <select class="form-control" name="searchType" id="searchType">
                        <option value="id">User ID</option>
                        <option value="lastName">User Last Name</option>
                        <option value="gymName">Gym Name</option>
                    </select>
                </div>
                <button class="btn btn-primary" type="submit" name="submit" value="search">
                    Submit Search
                </button>
                <button class="btn btn-primary" type="submit" name="submit" value="viewAllUsers">
                    View All Users
                </button>

                <button class="btn btn-primary" type="submit" name="submit" value="viewAllGyms">
                    View All Gyms
                </button>
            </form>


        </div>
    </div>
    <div class="parallax-container">
        <div class="parallax"><img src="/images/test3.jpg"></div>
    </div>


<!-- Login Modal -->
<div id="login" class="modal">
    <div class="modal-content">
        <form>
            <h4>Log In</h4>

            <div class="form-group, row">
                <input type="text" class="form-control" name="loginUserName" id="loginUserName" aria-describedby="userNameHelp" placeholder="User Name">
            </div>
            <div class="form-group, row">
                <input type="text" class="form-control" name="loginPassword" id="loginPassword" aria-describedby="passwordHelp" placeholder="Password">
            </div>

            <button class="btn btn-primary" type="submit" name="submit" value="viewAllGyms">
                Log In
            </button>
        </form>
    </div>
</div>

<%--</div>--%>
</body>
</html>