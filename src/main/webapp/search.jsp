<!DOCTYPE html>
<head>
    <%@include file="head.jsp"%>
</head>

<html>
<header>
    <%@include file="navbar.jsp"%>
</header>

<div class="container">
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
                <div class="valign-wrapper">
                    <div class="input-field col m6">
                        <input type="text" class="form-control" type="text" name="searchTerm" id="searchTerm" aria-describedby="searchTermHelp">
                        <label for="searchTerm">Search For</label>
                    </div>

                    <div class="input-field col s6 m3">
                        <select name="searchType" id="searchType">
                            <option value="" disabled selected>Search By:</option>
                            <option value="userName">User Name</option>
                            <option value="gymName">Gym Name</option>
                        </select>
                    </div>
                    <div class="col s6 m3">
                        <button class="btn btn-primary" type="submit" name="submit" value="search">
                            Submit Search
                        </button>
                    </div>
                </div>
                <div class="center-align col s12">
                    OR
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
    <p>Hi there!</p>
</footer>

<script>
    // Initialize SELECT boxes (forms)
    var elem = document.querySelector('select');
    var instance = M.FormSelect.init(elem, options);

    // Initialize PARALLAX (styling for pages)
    $(document).ready(function(){
        $('.parallax').parallax();
    });

    // Initialize MODAL (for user login)
    $(document).ready(function(){
        $('#login').modal();
    });
    $('#login').modal('open');


    var elem = document.querySelector('.sidenav');
    var instance = M.Sidenav.init(elem, options);

    // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
    var collapsibleElem = document.querySelector('.collapsible');
    var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);
</script>
</div>
</body>
</html>