<!DOCTYPE html>
<head>
    <%@include file="jsp/head.jsp"%>
    <script src="js/varInitialize.js"></script>
</head>

<html>
<header>
    <%@include file="jsp/navbar.jsp"%>
</header>

    <div class="parallax-container hide-on-large-and-up">
        <div class="parallax"><img src="images/background_bar_s.jpg"></div>
    </div>
    <div class="parallax-container hide-on-med-and-down">
        <div class="parallax"><img src="images/background_bar_m.jpg"></div>
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
                <h4 class="center-align">OR</h4>
                <div class="center-align col s12">
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

    <%@include file="jsp/loginModal.jsp"%>

<footer>
    <%@include file="jsp/footer.jsp"%>
</footer>
</body>
</html>