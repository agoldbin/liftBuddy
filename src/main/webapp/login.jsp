<%-- Jsp for the Admin login --%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="../templates/head.jsp"%>
    <title>Login</title>
    <script src="../js/init.js"></script>
</head>
<body>
<header>
    <%@include file="../templates/navbar.jsp"%>
</header>
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password" >
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
<footer>
    <%@include file="../templates/footer.jsp"%>
</footer>
</body>
</html>