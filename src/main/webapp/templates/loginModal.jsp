<%-- This jsp contains the code for the user login modal  which is used throughout the site --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body background="gray">

    <%-- TODO work on making modal functional for user login --%>
    <div id="loginModal" class="modal">

        <div class="modal-content">
            <h4>Log In</h4>
            <form id="loginForm" onsubmit="return userLoginValidation()" method="POST">
            <div class="input-field col s12 m6 l6">
                <input id="loginUserName" name="loginUserName" type="text" class="form-control"
                        pattern="^[a-zA-Z0-9_]{4,}$"
                        title="Username must be at least 4 characters, no special symbols" required>
                <label for="loginUserName">User Name</label>
            </div>
            <div class="input-field col s12 m6 l6">
                <input id="loginPassword" name="loginPassword" type="password" class="form-control"
                        pattern="{6,}" title="Password must be at least 6 characters" required>
                <label for="loginPassword">Password</label>
            </div>
            <div class="left-align">
                <p>Not a member? <a href="../newUser.jsp">Sign up now!</a></p>
                <a href="#">Forgot username or password?</a>
            </div>
            <div class="right-align">
                <button id="userLogin" class="btn waves-effect waves-light" type="submit">Login
                    <i class="material-icons right">send</i>
                </button>
            </div>
            </form>
        </div>
    </div>

</body>
</html>
