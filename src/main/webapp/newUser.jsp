<%-- New user sign up page --%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%@include file="head.jsp"%>
    <script src="js/init.js"></script>
</head>

<html>
<body>
<header>
    <%@include file="navbar.jsp"%>
</header>
<div class="row">
    <form class="col s12 m6 offset-m3">
        <div class="row">
            <div class="input-field col s12 m6">
                <input id="first_name" type="text" class="validate" pattern="^[a-zA-Z]*$" title="First name must be only letters" required="">
                <label for="first_name">First Name</label>
            </div>
            <div class="input-field col s12 m6">
                <input id="last_name" type="text" class="validate" pattern="^[a-zA-Z]*$" title="Last name must be only letters" required="">
                <label for="last_name">Last Name</label>
            </div>
            <div class="input-field col s12">
                <input id="email" type="email" class="validate" pattern="^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))
                           ([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$" title="Please enter a valid email" placeholder="johnsnow@winterfell.com" required="">
                <label for="email" class="active">Email</label>
            </div>
            <div class="input-field col s12">
                <input id="user_name" type="text" class="validate" pattern="^[A-Za-z_]\\w{4,19}$" title="Username must begin with a letter or underscore, no special characters.
                           5 to 20 characters long" required="">
                <label for="user_name">Username</label>
            </div>
            <div class="input-field col s12">
                <input id="location" type="text" class="validate" pattern="^[\d]{5}" title="Enter 5 digit Zip Code" required="">
                <label for="location">Zip Code</label>
            </div>
            <div class="input-field col s12">
                <input id="password" type="password" class="validate" pattern="^[A-Za-z\d$@$!%*#?&amp;]{6,}$" title="Password must be at least 6 characters long" required="">
                <label for="password">Password</label>
            </div>
            <div class="input-field col s12">
                <input id="confirmPassword" type="password" class="validate" pattern="^[A-Za-z\d$@$!%*#?&amp;]{6,}$" title="Password must be at least 6 characters long" onchange="checkPasswordMatch();" required="">
                <label for="confirmPassword">Confirm Password</label>
            </div>
            <div>
                <div class="registrationFormAlert" id="divCheckPasswordMatch">
                </div>
            </div>
        </div>
    </form>
    <div class="col m3 hide-on-small-and-down">
        Some content. Lolz.
    </div>
</div>
<footer>
    <%@include file="footer.jsp"%>
</footer>
</body>
</html>

<%--<div class="row">--%>
<%--<form class="col s12">--%>
<%--<div class="row">--%>
<%--<div class="input-field col s6">--%>
<%--<input placeholder="Placeholder" id="first_name" type="text" class="validate">--%>
<%--<label for="first_name">First Name</label>--%>
<%--</div>--%>
<%--<div class="input-field col s6">--%>
<%--<input id="last_name" type="text" class="validate">--%>
<%--<label for="last_name">Last Name</label>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--<div class="input-field col s12">--%>
<%--<input disabled value="I am not editable" id="disabled" type="text" class="validate">--%>
<%--<label for="disabled">Disabled</label>--%>
<%--</div>--%>
<%--</div>--%>

<%--</form>--%>
<%--</div>--%>

