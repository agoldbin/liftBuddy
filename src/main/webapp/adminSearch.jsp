<%-- Search page for Admins --%>
<!DOCTYPE html>
<head>
    <%@include file="templates/head.jsp"%>
    <script src="js/init.js"></script>
</head>

<html>

<body>
<%@include file="adminNav.jsp"%>
<div class="parallax-container hide-on-med-and-up">
    <div class="parallax"><img src="images/background_bar_s.jpg"></div>
</div>
<div class="parallax-container show-on-medium-and-up">
    <div class="parallax"><img src="images/background_bar_m.jpg"></div>
</div>
<div class="section white">
    <div class="row container">
        <c:if test="userAdded">
            <h3>Successfull added ${userAdded}</h3>
        </c:if>
        <h2 class="header">ADMIN SEARCH PAGE!</h2>
        <p class="grey-text text-darken-3 lighten-3">Parallax is an effect where the background content or image
            in this case, is moved at a different speed than the foreground content while scrolling.</p>

        <h2>Search form</h2>
        <form action="adminSearch" class="form-inline">
            <div class="valign-wrapper">
                <div class="input-field col m6">
                    <input type="text" class="form-control" name="searchTerm" id="searchTerm" aria-describedby="searchTermHelp">
                    <label for="searchTerm">Search</label>
                </div>
                    <%-- Custom search --%>
                <div class="input-field col s6 m3">
                    <select name="searchType" id="searchType">
                        <option value="" disabled="disabled">Search by:</option>
                        <option value="id">User ID</option>
                        <option value="id">User Name</option>
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
                <%-- Edit or remove from database --%>
            <div>
                <h4 class="center-align">VIEW ALL</h4>
            </div>
            <div class="center-align col s12">
                <button class="btn btn-primary" type="submit" name="submit" value="viewAllAdmins">
                    View All Admins
                </button>
                <button class="btn btn-primary" type="submit" name="submit" value="viewAllUsers">
                    View All Users
                </button>
                <button class="btn btn-primary" type="submit" name="submit" value="viewAllGyms">
                    View All Gyms
                </button>
            </div>
            <hr />
                <%-- Add to database --%>
            <div>
                <h4 class="center-align">ADD</h4>
            </div>
            <div class="center-align col s12">
                <button class="btn btn-primary" type="submit" name="submit" value="addAdmin">
                    Add Admin
                </button>
                <button class="btn btn-primary" type="submit" name="submit" value="addUser">
                    Add User
                </button>
                <button class="btn btn-primary" type="submit" name="submit" value="addGym">
                    Add Gym
                </button>
            </div>
        </form>
    </div>
</div>
<div class="parallax-container">
    <div class="parallax"><img src="images/test3.jpg"></div>
</div>

<footer>
    <%@include file="templates/footer.jsp"%>
</footer>

</body>
</html>