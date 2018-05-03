<%-- This jsp contains the code for the header of the majority of the web pages --%>
<%-- PAGES NOT USED IN: --%>
<%-- adminSearch.jsp, loginError.jsp  --%>
<!DOCTYPE html>

<%@include file="templates/taglib.jsp"%>
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
                $('.brand-logo').addClass("orange-text text-darken-3 active");
                break;
            case 'search.jsp':
                $('#search').addClass("active");
                break;
            case 'userNew.jsp':
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

    $(".dropdown-trigger").dropdown();
</script>
<nav>
    <div class="nav-wrapper blue darken-2">
        <div id="nav-large" class="hide-on-med-and-down">
            <img src="images/logo2.png" class="center-align" height="60px">
            <a id="home" href="../LiftBuddy/index.jsp" class="brand-logo left orange-text">Lift Buddy</a>

            <%--<c:choose>--%>

            <%--<c:when test="${empty pageContext.request.remoteUser}">--%>

            <%--<li>--%>

            <%--<a href="login" class="nav-link">Log In</a>--%>

            <%--</li>--%>

            <%--</c:when>--%>

            <%--<c:otherwise>--%>

            <%--<li class="nav-item">--%>

            <%--<a href="search.jsp" class="nav-link">Search</a>--%>

            <%--</li>--%>

            <%--<li class="nav-item">--%>

            <%--<a href="#">Import Connections</a>--%>

            <%--</li>--%>

            <%--<c:if test="${role == 'admin'}">--%>

            <%--<li class="nav-item">--%>

            <%--<a href="adminSearch.jsp">Admin</a>--%>

            <%--</li>--%>

            <%--</c:if>--%>

            <%--<li>--%>

            <%--<a href="logout">Log Out</a>--%>

            <%--</li>--%>

            <%--</c:otherwise>--%>

            <%--</c:choose>--%>

            <%-- Check if user is signed in --%>
            <c:if test="${not empty pageContext.request.remoteUser}">
                <ul class="right">
                        <%-- Dropdown menu if user is signed in --%>
                        <%--TODO user crud--%>
                    <ul id="userDropdown" class="dropdown-content">
                        <li><a href="#!">Update Info</a></li>
                        <li><a href="#!">Something</a></li>
                        <li class="divider"></li>
                        <li><a href="#!">Delete Account</a></li>
                    </ul>
                    <li>
                        <a href="user.jsp">Home</a>
                    </li>
                    <li>
                        <a class="dropdown-trigger" href="#" data-target="userDropdown">Edit Profile ${user.firstName}
                            <i class="material-icons right">arrow_drop_down</i>
                        </a>
                    </li>
                        <%-- check if user is admin --%>
                        <%--TODO admin crud - including gyms--%>
                    <c:if test="${role = 'admin'}">
                        <li><a href="#">You're an Admin!</a></li>
                    </c:if>

                        <%-- Default user links --%>
                    <li><a href="userSearch.jsp">User Search</a></li>
                    <li><a href="logout">Logout</a></li>

                </ul>
            </c:if>

            <%-- TODO add functionality so login changes to logout depending on session status --%>
            <%-- Links if user not signed in --%>
            <c:if test="${empty pageContext.request.remoteUser}">
                <ul class="right">
                    <li id="search"><a href="../LiftBuddy/search.jsp">Search</a></li>
                        <%--<li id="loginLink"><a class="modal-trigger" href="#loginModal" data-target="modal">Login</a></li>--%>
                    <li id="loginLink"><a class="" href="../LiftBuddy/user.jsp">Login</a></li>
                    <li id="signUp"><a href="getGyms">Sign Up</a></li>
                </ul>
            </c:if>
            <%--<c:if test="${not empty sessionScope.user}">--%>
            <%--&lt;%&ndash;<li><a href="user.jsp#favorites">${user.userName}'s favorites</a></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li><a href="user.jsp#reviews">${user.userName}'s reviews</a></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li><a href="user.jsp#profile">${user.userName}'s profile</a></li>&ndash;%&gt;--%>
            <%--</c:if>--%>
        </div>

        <div id="nav-mobile" class="hide-on-large-only">
            <ul id="nav-m" class="side-nav">
                <c:if test="${empty pageContext.request.remoteUser}">
                    <li><a href="../LiftBuddy/search.jsp"><i class="material-icons">search</i>Search</a></li>
                    <li><a class="" href="../LiftBuddy/user.jsp">Login</a></li>
                    <li><a href="getGyms">Sign Up</a></li>
                    <li><a href="../LiftBuddy/search.jsp">Search</a></li>
                </c:if>
                <%-- check if user is admin --%>
                <%--<c:if test="${roleName = 'admin'}">--%>

                <%--</c:if>--%>
                <c:if test="${not empty pageContext.request.remoteUser}">
                    <%--<li><a href="user.jsp#favorites">${user.userName}'s favorites</a></li>--%>
                    <%--<li><a href="user.jsp#reviews">${user.userName}'s reviews</a></li>--%>
                    <%--<li><a href="user.jsp#profile">${user.userName}'s profile</a></li>--%>
                    <li><a href="logout">Logout</a></li>
                </c:if>

            </ul>
            <a href="#" data-activates="nav-m" class="button-collapse iconLinks"><i class="material-icons orange-text">menu</i></a>
            <div class="valign-wrapper">
                <a href="index.jsp" class="center">
                    <img src="images/logo2.png" class="center-block center-align" height="50px">
                </a>
            </div>

        </div>
    </div>
</nav>
