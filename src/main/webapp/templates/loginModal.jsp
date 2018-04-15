<%-- This jsp contains the code for the user login modal  which is used throughout the site --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- TODO work on making modal functional for user login --%>
<div id="loginModal" class="modal grey lighten-2 black-text">

    <div class="modal-content">
        <h4>Log In</h4>
        <form id="loginForm" ACTION="j_security_check" method="POST">
        <div class="input-field col s12 m6 l6">
            <input id="loginUserName" name="j_username" type="text" class="form-control" required>
            <label for="loginUserName">User Name</label>
        </div>
        <div class="input-field col s12 m6 l6">
            <input id="loginPassword" name="j_password" type="password" class="form-control" required>
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