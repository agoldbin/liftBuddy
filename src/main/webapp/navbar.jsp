<%-- This jsp contains the code for the header of the majority of the web pages --%>
<!DOCTYPE html>
<html>
<%@include file="taglib.jsp"%>
<% %>
<body>
    <header>
        <nav>
            <div class="nav-wrapper">
                <a href="#" class="brand-logo">Lift Buddy</a>
                <ul id="nav-big" class="right hide-on-med-and-down">
                    <%-- TODO work on making li dynamically use class="active" when user is on that page --%>
                    <%-- TODO add functionality so login changes to logout depending on session status --%>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="search.jsp">Search</a></li>
                    <li><a class="modal-trigger" href="#login" data-target="login">Login</a></li>
                    <li><a href="newUser.jsp">Sign Up</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <%--  TODO work on making damn sidenav actually collapse on load  OR figure out another option
          TODO  for mobile. Floating action bar? --%>
    <%--<ul id="slide-out" class="sidenav">--%>
        <%--<li><div class="user-view">--%>
            <%--<div class="background">--%>
                <%--<img src="images/office.jpg">--%>
            <%--</div>--%>
            <%--<a href="#user"><img class="circle" src="images/yuna.jpg"></a>--%>
            <%--<a href="#name"><span class="white-text name">John Doe</span></a>--%>
            <%--<a href="#email"><span class="white-text email">jdandturk@gmail.com</span></a>--%>
        <%--</div></li>--%>
        <%--<li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>--%>
        <%--<li><a href="#!">Second Link</a></li>--%>
        <%--<li><div class="divider"></div></li>--%>
        <%--<li><a class="subheader">Subheader</a></li>--%>
        <%--<li><a class="waves-effect" href="#!">Third Link With Waves</a></li>--%>
    <%--</ul>--%>
    <%--<a href="#" data-target="slide-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>--%>

    <script>
        // Initialize MODAL (for user login)
        $(document).ready(function(){
            $('#login').modal();
        });
        $('#login').modal('open');
    </script>
</body>