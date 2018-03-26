<!DOCTYPE html>

<head>
    <%@include file="head.jsp"%>
    <script>
        var elem = document.querySelector('.sidenav');
        var instance = M.Sidenav.init(elem, options);

        // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
        var collapsibleElem = document.querySelector('.collapsible');
        var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);
    </script>
</head>

<html>
<body>
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Lift Buddy</a>
            <ul id="nav-big" class="right hide-on-med-and-down">
                <%-- TODO work on making li dynamically use class="active" when user is on that page --%>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="search.jsp">Search</a></li>
                <li><a class="modal-trigger" href="#loginModal" data-target="loginModal">Login M</a></li>
                <li><a href="newUser.jsp">Sign Up</a></li>
            </ul>
        </div>
    </nav>

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

</body>