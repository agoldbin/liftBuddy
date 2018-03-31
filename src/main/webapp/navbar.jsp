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
<div class="mobile-collapse">
    <nav>
        <div class="nav-wrapper">
            <div id="nav-large" class="hide-on-med-and-down">
                <a id="home" href="index.jsp" class="brand-logo left">Lift Buddy</a>
                <ul class="right">
                    <%-- TODO add functionality so login changes to logout depending on session status --%>
                    <li id="search"><a href="search.jsp">Search</a></li>
                    <li id="loginLink"><a class="modal-trigger" href="#loginModal" data-target="modal">Login</a></li>
                    <li id="signUp"><a href="newUser.jsp">Sign Up</a></li>
                </ul>
            </div>

            <div id="nav-mobile" class="hide-on-large-only">
                <a href="index.jsp" class="brand-logo center">Lift Buddy</a>
                <a href="#" data-target="nav-sidenav" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <%--<a href="#" data-activates="nav-sidenav" class="button-collapse iconLinks"><i class="material-icons">menu</i></a>--%>
            </div>

            <%--<ul id="nav-sidenav" class="sidenav hide-on-large-only">--%>
                <%--&lt;%&ndash; TODO work on making li dynamically use class="active" when user is on that page &ndash;%&gt;--%>
                <%--&lt;%&ndash; TODO add functionality so login changes to logout depending on session status &ndash;%&gt;--%>
                <%--<li id="search"><a href="search.jsp">Search</a></li>--%>
                <%--<li id="login"><a class="modal-trigger" href="#login" data-target="login">Login</a></li>--%>
                <%--<li id="signUp"><a href="newUser.jsp">Sign Up</a></li>--%>
            <%--</ul>--%>


            <%--//////////////////////////////////////////////////////////--%>
            <ul id="nav-m" class="side-nav">
                <li><a href="explore"><i class="material-icons">search</i>Search</a></li>
                <%--<c:if test="${empty user}">--%>
                <li><a class="modal-trigger" href="#signup">Sign Up</a></li>
                <li><a href="login">Login</a><li>
                <%--</c:if>--%>
                <%--<c:if test="${not empty user}">--%>
                <%--<li class="divider"></li>--%>
                <%--<li><a href="user.jsp#favorites">${user.userName}'s favorites</a></li>--%>
                <%--<li><a href="user.jsp#reviews">${user.userName}'s reviews</a></li>--%>
                <%--<li><a href="user.jsp#profile">${user.userName}'s profile</a></li>--%>
                <%--<li class="divider"></li>--%>
                <%--<li><a href="logout">logout</a></li>--%>
                <%--</c:if>--%>
            </ul>
            <a href="#" data-activates="nav-m" class="button-collapse iconLinks"><i class="material-icons teal">menu</i></a>
            <%--//////////////////////////////////////////////////////////--%>

        <%--<ul class="sidenav" id="mobile-demo" style="transform: translateX(0%);">--%>
        <%--<li><a href="sass.html">Sass</a></li>--%>
        <%--<li><a href="badges.html">Components</a></li>--%>
        <%--<li><a href="collapsible.html">JavaScript</a></li>--%>
        <%--</ul>--%>
        <%-- Mobile side menu options --%>

    <%@include file="loginModal.jsp" %>
        </div>
    </nav>
</div>