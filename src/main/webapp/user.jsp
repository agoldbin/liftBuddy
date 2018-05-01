<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/taglib.jsp" %>
<c:set var = "title" value = "LB User"/>
<html>
<%@include file="templates/head.jsp" %>
<script src="js/init.js"></script>
<body>
<%@include file="templates/navbar.jsp" %>
    <div class="center-align">
        <h1>Welcome to LiftBuddy <c:out value="${user.userName}" />!</h1>
        <br>
        <img src="images/logo2.png" width="30%">
    </div>
<%@include file="templates/footer.jsp"%>
</body>
</html>
