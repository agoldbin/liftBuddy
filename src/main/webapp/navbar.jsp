<%--
  Created by IntelliJ IDEA.
  User: real_
  Date: 3/24/2018
  Time: 04:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>

<head>
<%--<script>--%>
    <%--var elem = document.querySelector('.sidenav');--%>
    <%--var instance = M.Sidenav.init(elem, options);--%>

    <%--// Initialize collapsible (uncomment the lines below if you use the dropdown variation)--%>
    <%--// var collapsibleElem = document.querySelector('.collapsible');--%>
    <%--// var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);--%>

    <%--var instance = M.Sidenav.getInstance(elem);--%>

    <%--$('.button-collapse').sideNav({--%>
            <%--closeOnClick: true,--%>
            <%--edge: 'right', // <--- CHECK THIS OUT--%>
        <%--}--%>
    <%--);--%>
    <%--$('.collapsible').collapsible();--%>
<%--</script>--%>
    <script>
        var elem = document.querySelector('.sidenav');
        var instance = M.Sidenav.init(elem, options);
        instance.onCloseStart;
        instance.draggable = true;
    </script>
</head>

<html>
<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo">Lift Buddy</a>
        <ul id="nav-big" class="right hide-on-med-and-down">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="search.jsp">Search</a></li>
            <li><a class="modal-trigger" href="#login">Login M</a></li>
            <li><a href="newUser.jsp">Sign Up</a></li>
        </ul>
    </div>

</nav>




<div class="container"><a href="#" data-target="nav-mobile" class="top-nav sidenav-trigger full show-on-medium-and-down"><i class="material-icons">menu</i></a></div>
<ul id="nav-mobile" class="sidenav sidenav-fixed">
    <li class="logo"><a id="logo-container" href="/" class="brand-logo">
        <object id="front-page-logo" type="image/svg+xml" data="res/materialize.svg">Your browser does not support SVG</object></a></li>
    <li class="version"><a href="#" data-target="version-dropdown" class="dropdown-trigger">
        1.0.0-beta
        <svg class="caret" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M7 10l5 5 5-5z"></path><path d="M0 0h24v24H0z" fill="none"></path></svg></a>
        <ul id="version-dropdown" class="dropdown-content">
            <li><a>1.0.0-beta</a></li>
            <li><a href="http://archives.materializecss.com/0.100.2/">0.100.2</a></li>
        </ul>
    </li>
    <li class="search">
        <div class="search-wrapper">
            <input id="search" placeholder="Search"><i class="material-icons">search</i>
            <div class="search-results"></div>
        </div>
    </li>
    <li class="bold"><a href="about.html" class="waves-effect waves-teal">About</a></li>
    <li class="bold"><a href="getting-started.html" class="waves-effect waves-teal">Getting Started</a></li>
    <li class="no-padding">
        <ul class="collapsible collapsible-accordion">
            <li class="bold"><a class="collapsible-header waves-effect waves-teal">CSS</a>
                <div class="collapsible-body">
                    <ul>
                        <li><a href="color.html">Color</a></li>
                        <li><a href="grid.html">Grid</a></li>
                        <li><a href="helpers.html">Helpers</a></li>
                        <li><a href="media-css.html">Media</a></li>
                        <li><a href="pulse.html">Pulse</a></li>
                        <li><a href="sass.html">Sass</a></li>
                        <li><a href="shadow.html">Shadow</a></li>
                        <li><a href="table.html">Table</a></li>
                        <li><a href="css-transitions.html">Transitions</a></li>
                        <li><a href="typography.html">Typography</a></li>
                    </ul>
                </div>
            </li>
            <li class="bold"><a class="collapsible-header waves-effect waves-teal">Components</a>
                <div class="collapsible-body">
                    <ul>
                        <li><a href="badges.html">Badges</a></li>
                        <li><a href="buttons.html">Buttons</a></li>
                        <li><a href="breadcrumbs.html">Breadcrumbs</a></li>
                        <li><a href="cards.html">Cards</a></li>
                        <li><a href="collections.html">Collections</a></li>
                        <li><a href="floating-action-button.html">Floating Action Button</a></li>
                        <li><a href="footer.html">Footer</a></li>
                        <li><a href="icons.html">Icons</a></li>
                        <li><a href="navbar.html">Navbar</a></li>
                        <li><a href="pagination.html">Pagination</a></li>
                        <li><a href="preloader.html">Preloader</a></li>
                    </ul>
                </div>
            </li>
            <li class="bold active"><a class="collapsible-header waves-effect waves-teal">JavaScript</a>
                <div class="collapsible-body">
                    <ul>
                        <li><a href="auto-init.html">Auto Init</a></li>
                        <li><a href="carousel.html">Carousel</a></li>
                        <li><a href="collapsible.html">Collapsible</a></li>
                        <li><a href="dropdown.html">Dropdown</a></li>
                        <li><a href="feature-discovery.html">FeatureDiscovery</a></li>
                        <li><a href="media.html">Media</a></li>
                        <li><a href="modals.html">Modals</a></li>
                        <li><a href="parallax.html">Parallax</a></li>
                        <li><a href="pushpin.html">Pushpin</a></li>
                        <li><a href="scrollspy.html">Scrollspy</a></li>
                        <li class="active"><a href="sidenav.html">Sidenav</a></li>
                        <li><a href="tabs.html">Tabs</a></li>
                        <li><a href="toasts.html">Toasts</a></li>
                        <li><a href="tooltips.html">Tooltips</a></li>
                        <li><a href="waves.html">Waves</a></li>
                    </ul>
                </div>
            </li>
            <li class="bold"><a class="collapsible-header waves-effect waves-teal">Forms</a>
                <div class="collapsible-body">
                    <ul>
                        <li><a href="autocomplete.html">Autocomplete</a></li>
                        <li><a href="checkboxes.html">Checkboxes</a></li>
                        <li><a href="chips.html">Chips</a></li>
                        <li><a href="pickers.html">Pickers</a></li>
                        <li><a href="radio-buttons.html">Radio Buttons</a></li>
                        <li><a href="range.html">Range</a></li>
                        <li><a href="select.html">Select</a></li>
                        <li><a href="switches.html">Switches</a></li>
                        <li><a href="text-inputs.html">Text Inputs</a></li>
                    </ul>
                </div>
            </li>
        </ul>
    </li>
</ul>








<%--<ul id="slide-out" class="sidenav show-on-medium-and-down">--%>
    <%--<li><a href="index.jsp">Home</a></li>--%>
    <%--<li><a href="search.jsp">Search</a></li>--%>
    <%--<li class="no-padding">--%>
        <%--<ul class="collapsible collapsible-accordion">--%>
            <%--<li>--%>
                <%--<a class="collapsible-header">Dropdown<i class="material-icons">arrow_drop_down</i></a>--%>
                <%--<div class="collapsible-body">--%>
                    <%--<ul>--%>
                        <%--<li><a href="#!">First</a></li>--%>
                        <%--<li><a href="#!">Second</a></li>--%>
                        <%--<li><a href="#!">Third</a></li>--%>
                        <%--<li><a href="#!">Fourth</a></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</li>--%>
<%--</ul>--%>
<%--<a href="#" data-target="slide-out" class="sidenav-trigger show-on-medium-and-down"><i class="material-icons">menu</i></a>--%>

</html>
