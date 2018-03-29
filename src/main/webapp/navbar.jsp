<%-- This jsp contains the code for the header of the majority of the web pages --%>
<%-- PAGES NOT USED IN: --%>
<%-- adminSearch.jsp, loginError.jsp  --%>
<!DOCTYPE html>

<%@include file="taglib.jsp"%>
<% %>
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
                $('#home').addClass("active");
                break;
            case 'search.jsp':
                $('#search').addClass("active");
                break;
            case 'newUser.jsp':
                $('#signUp').addClass("active");
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
                $('#home').addClass("active");
                break;
        }
    });
</script>

<nav>
    <div class="nav-wrapper">
        <a href="#" id="logo-large" class="brand-logo left">Lift Buddy</a>
        <a href="#" id="logo-mobile" class="brand-logo center">Lift Buddy</a>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        <ul id="nav-big" class="right">
            <%-- TODO add functionality so login changes to logout depending on session status --%>
            <li id="home"><a href="index.jsp">Home</a></li>
            <li id="search"><a href="search.jsp">Search</a></li>
            <li id="login"><a class="modal-trigger" href="#login" data-target="login">Login</a></li>
            <li id="signUp"><a href="newUser.jsp">Sign Up</a></li>
        </ul>

    </div>
</nav>

<ul id="nav-mobile" class="sidenav">
    <%-- TODO work on making li dynamically use class="active" when user is on that page --%>
    <%-- TODO add functionality so login changes to logout depending on session status --%>
    <li id="home"><a href="index.jsp">Home</a></li>
    <li id="search"><a href="search.jsp">Search</a></li>
    <li id="login"><a class="modal-trigger" href="#login" data-target="login">Login</a></li>
    <li id="signUp"><a href="newUser.jsp">Sign Up</a></li>
</ul>

<%@include file="loginModal.jsp" %>