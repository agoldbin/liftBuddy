<%-- New user sign up page --%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@include file="head.jsp"%>
    <script src="js/varInitialize.js"></script>
</head>

<html>
<header>
    <%@include file="navbar.jsp"%>
</header>
<body>
    <div class="row">


        <form class="col offset-m9">
            <div class="row">
                <div class="input-field col m4">
                    <input id="first_name" type="text" pattern="^[a-zA-Z]*$"
                           title="First name must be only letters" required>
                    <label for="first_name">First Name</label>
                </div>
                <div class="input-field col m4">
                    <input id="last_name" type="text" pattern="^[a-zA-Z]*$"
                           title="Last name must be only letters" required>
                    <label for="last_name">Last Name</label>
                </div>
            </div>
            <div></div>


        <div class="row">
            <form class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate">
                        <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="last_name" type="text" class="validate">
                        <label for="last_name">Last Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s12">
                        <input disabled value="I am not editable" id="disabled" type="text" class="validate">
                        <label for="disabled">Disabled</label>
                    </div>
                </div>

        </form>
    </div>
</body>
</html>
