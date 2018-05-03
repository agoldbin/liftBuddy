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

        <h2 class="header center-align">ADMIN ADD USER</h2>
        <p class="grey-text text-darken-3 lighten-3">Parallax is an effect where the background content or image
            in this case, is moved at a different speed than the foreground content while scrolling.</p>

        <form class="col s12 m6 offset-m3" action="adminAddUser">
            <div class="row">
                <div class="input-field col s12 m6">
                    <input id="first_name" name="first_name" type="text" class="validate" pattern="^[a-zA-Z]*$"
                           title="First name must be only letters" autofocus="autofocus" required="">
                    <label for="first_name">First Name</label>
                </div>
                <div class="input-field col s12 m6">
                    <input id="last_name" name="last_name" type="text" class="validate" pattern="^[a-zA-Z]*$"
                           title="Last name must be only letters" required="">
                    <label for="last_name">Last Name</label>
                </div>
                <%--TODO fix validation for username and email--%>
                <div class="input-field col s12">
                    <input id="email" name="email" type="email" class="validate" title="Please enter a valid email"
                           required="">
                    <%--pattern="^([a-zA-Z0-9_\-\.]+)@|(([a-zA-Z0-9\-]+\.)+))--%>
                    <%--([a-zA-Z]{2,4}$"--%>
                    <label for="email" class="active">Email</label>
                </div>
                <div class="input-field col s12">
                    <input id="user_name" name="user_name" type="text" class="validate"
                           title="Username must begin with a letter or underscore, no special characters.
                <%--pattern="^[A-Za-z_]\\w{4,19}$"--%>
                    5 to 20 characters long" required="">
                    <label for="user_name">Username</label>
                </div>
                <div class="input-field col s12">
                    <input id="location" name="location" type="text" class="validate" pattern="^[\d]{5}"
                           title="Enter 5 digit Zip Code" required="">
                    <label for="location">Zip Code</label>
                </div>
                <div class="valign-wrapper col s12">
                    <div class="input-field col s12 m6">
                        <select name="gymSelect" id="gymSelect">
                            <option value="" selected>Select your gym</option>
                            <%--TODO add new user servlet, query gym names, store as attribute, grab attribute to populate drop down--%>
                            <c:forEach items="${gyms}" var="gym">
                                <option value="${gym.gymName}"> ${gym.gymName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <p></p>
                    <div class="input-field col s12 m6">
                        <input id="newGym" name="newGym" type="text" class="validate"
                               title="Gym name">
                        <label for="newGym">Add gym</label>
                    </div>
                </div>
            <div class="center-align">
                <button id="createUser" class="btn waves-effect waves-light" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
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