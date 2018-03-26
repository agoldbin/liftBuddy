<!DOCTYPE html>
<head>
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
</head>

<html>

<body>
<header>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Lift Buddy</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li class="active"><a href="#">ADMIN PAGE BABY!</a></li>
                <li><a href="index.jsp">Home</a></li>
                <li ><a href="search.jsp">Search</a></li>
                <li><a class="modal-trigger" href="#loginModal">Login M</a></li>
            </ul>
        </div>
    </nav>
</header>

<%--<div class="container">--%>
<%--<h2>Lift Buddy Display</h2>--%>
    <div class="parallax-container">
        <div class="parallax"><img src="/images/background_bar.jpg"></div>
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
                    <div class="form-group col m6">
                        <select class="form-control" name="searchType" id="searchType">
                            <option value="" disabled value>Search by:</option>
                            <option value="id">User ID</option>
                            <option value="userName">User Last Name</option>
                            <option value="gymName">Gym Name</option>
                        </select>
                    </div>
                </div>
                <div class="center-align col s12">
                    <button class="btn btn-primary" type="submit" name="submit" value="search">
                        Submit Search
                    </button>
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
        <div class="parallax"><img src="/images/test3.jpg"></div>
    </div>

<%@include file="loginModal.jsp"%>

<%--</div>--%>
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
</script>

</body>
</html>