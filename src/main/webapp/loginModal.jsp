<%-- This jsp contains the code for the user login modal  which is used throughout the site --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%-- TODO either work on making login modal functional --%>


<!-- Login Modal -->
<form>

    <div id="login" class="modal">

        <div class="modal-content">
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
        </div>
    </div>
</form>
</body>
</html>
