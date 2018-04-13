<%-- Jsp for the home screen --%>
<!DOCTYPE html>
<head>
    <%@include file="templates/head.jsp"%>
    <script src="../js/init.js"></script>
<head>

<html>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
    <!-- Container element -->
    <div class="bgimg1"></div>

    <%@include file="templates/navbar.jsp"%>

    <div class="section white">
        <div class="row container">
            <h2 class="header">Parallax</h2>
            <p class="grey-text text-darken-3 lighten-3">Parallax is an effect where the background content or image
                in this case, is moved at a different speed than the foreground content while scrolling.</p>
            <a href="../admin/adminSearch.jsp">Click here to search! (Admin only)</a>
        </div>
    </div>
    <div class="bgimg2"></div>

    <%@include file="templates/loginModal.jsp"%>

    <footer>
        <%@include file="templates/footer.jsp"%>
    </footer>

</body>
</html>