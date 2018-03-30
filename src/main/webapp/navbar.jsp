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
<div class="mobile-collapse">
    <nav>
        <div class="nav-wrapper">
            <a href="#" id="logo-large" class="brand-logo left hide-on-small-and-down">Lift Buddy</a>
            <a href="#" id="logo-mobile" class="brand-logo center hide-on-med-and-up">Lift Buddy</a>
            <a href="#" data-target="nav-mobile" class="button-collapse"><i class="material-icons menu-hamburger hide-on-med-and-up">menu</i></a>
            <ul class="right show-on-large">
                <%-- TODO add functionality so login changes to logout depending on session status --%>
                <li id="home"><a href="index.jsp">Home</a></li>
                <li id="search"><a href="search.jsp">Search</a></li>
                <li id="loginLink"><a class="modal-trigger" href="#loginModal" data-target="loginModal">Login</a></li>
                <li id="signUp"><a href="newUser.jsp">Sign Up</a></li>
            </ul>


        <%--<ul class="sidenav" id="mobile-demo" style="transform: translateX(0%);">--%>
        <%--<li><a href="sass.html">Sass</a></li>--%>
        <%--<li><a href="badges.html">Components</a></li>--%>
        <%--<li><a href="collapsible.html">JavaScript</a></li>--%>
        <%--</ul>--%>
        <%-- Mobile side menu options --%>
        <ul id="nav-mobile" class="side-nav">
        <%-- TODO work on making li dynamically use class="active" when user is on that page --%>
        <%-- TODO add functionality so login changes to logout depending on session status --%>
            <li id="home"><a href="index.jsp">Home</a></li>
            <li id="search"><a href="search.jsp">Search</a></li>
            <li id="login"><a class="modal-trigger" href="#login" data-target="login">Login</a></li>
            <li id="signUp"><a href="newUser.jsp">Sign Up</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse iconLinks"><i class="material-icons">menu</i></a>

    <%@include file="loginModal.jsp" %>
        </div>
    </nav>
</div>