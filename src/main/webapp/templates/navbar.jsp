<%-- This jsp contains the code for the header of the majority of the web pages --%>
<%-- PAGES NOT USED IN: --%>
<%-- adminSearch.jsp, loginError.jsp  --%>
<!DOCTYPE html>

<%@include file="taglib.jsp"%>
<script type="text/javascript">

    function getPageNameFromURL() {
        var URL = document.location.href;
        var PageFileName = URL.substring(URL.lastIndexOf('/') + 1);
        return PageFileName;
    }
    $(document).ready(function() {
        var PageName = getPageNameFromURL();
        switch (PageName) {
            case 'index.jsp':
                $('.brand-logo').addClass("green-text text-darken-4 active");
                break;
            case 'search.jsp':
                $('#search').addClass("active");
                break;
            case 'newUser.jsp':
                $('#newUser').addClass("active");
                break;
            // case 'addReport':
            //     $('#addReport').addClass("active");
            //     break;
            // case 'addTrail':
            //     $('#addTrail').addClass("active");
            //     break;
            // case 'signInConfirmation.jsp':
            //     $('#signInConfirmation').addClass("active");
            //     break;
            // case 'about.jsp':
            //     $('#about').addClass("active");
            //     break;
            default:
                $('#home').addClass("green-text");
                break;
        }
    });
</script>
<style>
    /* Note: Try to remove the following lines to see the effect of CSS positioning */
    .affix {
        top: 0;
        width: 100%;
        z-index: 9999 !important;
    }

    .affix + .container-fluid {
        padding-top: 70px;
    }
</style>
<body data-spy="scroll" data-target=".navbar">
<%--<nav id="bigNav" class="navbar navbar-inverse" data-spy="affix">--%>
    <%--<div class="container-fluid">--%>
        <%--<div class="navbar-header">--%>
            <%--<a class="navbar-brand" href="#">LiftBuddy</a>--%>
        <%--</div>--%>
        <%--<ul class="nav navbar-nav">--%>
            <%--<li class="active"><a href="#">Home</a></li>--%>
            <%--<li><a href="#">Page 1</a></li>--%>
            <%--<li><a href="#">Page 2</a></li>--%>
        <%--</ul>--%>
        <%--<ul class="nav navbar-nav navbar-right">--%>
            <%--<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
            <%--<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--%>
        <%--</ul>--%>
    <%--</div>--%>
<%--</nav>--%>
<nav id="mobileNav" class="navbar navbar-inverse" data-spy="affix" data-offset-top="500">
    <div class="container-fluid">
        <div class="navbar-header">
            <button id="mobileNavButton" type="button" class="navbar-toggle" data-toggle="collapse" data-target="#siteNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <%--<img src="images/logo2.png" height="48px">--%>
                Lift Buddy
            </a>
        </div>
        <div class="collapse navbar-collapse" id="siteNavbar">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="search.jsp">Search</a></li>
                <li><a href="#">Page 2</a></li>
                <li><a href="#">Page 3</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="newUser.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="#loginModal" data-toggle="modal" data-target="#loginModal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </div>
</nav>
    <%@include file="loginModal.jsp" %>
</body>