<%--
  Created by IntelliJ IDEA.
  User: real_
  Date: 3/8/2018
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../templates/head.jsp"%>
    <title>Login Failed</title>
</head>
<body>
<header>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Lift Buddy</a>
            <a href="#" data-target="nav-mobile-loginError" class="sidenav-trigger hide-on-med-and-up"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down show-on-large">
                <li><a href="index.jsp">Home</a></li>
                <li ><a href="search.jsp">Search</a></li>
                <li><a class="modal-trigger" href="#login" data-target="login">Login M</a></li>
            </ul>

            <ul class="sidenav hide-on-med-and-up">
                <li><a href="index.jsp">Home</a></li>
                <li ><a href="search.jsp">Search</a></li>
                <li><a class="modal-trigger" href="#login" data-target="login">Login M</a></li>
            </ul>
        </div>
    </nav>
</header>

<div class="row">
    <img class="col s3" src="images/loginErr.png" alt="Login Error" />
    <h2 class="col s9 left-align">Login Failed. Please try again.</h2>
</div>
<footer>
    <%@include file="../templates/footer.jsp"%>
</footer>
</body>
</html>
