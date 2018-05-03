<%-- User search results page --%>
<!DOCTYPE html>
<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Admin User Query Results" />

<head>
    <%@include file="templates/head.jsp"%>
    <script src="js/init.js"></script>
    <script type="text/javascript" class="init">
        $(document).ready( function () {
            $('#searchTable').DataTable();
        } );
    </script>
</head>


<html>
<body>
<header>
    <%@include file="adminNav.jsp"%>
</header>
<%@include file="templates/loginModal.jsp"%>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="searchTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Name</th>
        <th>User Name</th>
        <th>Gym</th>
        <th>Location</th>
        <th>Edit</th>
        <th>Remove</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.gymName}</td>
                <td>${user.location}</td>
                <td><button class="waves-effect waves-light btn" type="submit" name="submit">Edit</button></td>
                <td><button class="waves-effect waves-light btn red" type="submit" name="submit">Remove</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<footer>
    <%@include file="templates/footer.jsp"%>
</footer>
</body>
</html>