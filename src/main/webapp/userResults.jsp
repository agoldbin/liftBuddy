<%-- User search results page --%>
<!DOCTYPE html>
<%@include file="taglib.jsp"%>
<c:set var="title" value="User Query Results" />

<head>
    <%@include file="head.jsp"%>
    <script src="js/varInitialize.js"></script>
    <script type="text/javascript" class="init">
        $(document).ready( function () {
            $('#searchTable').DataTable();
        } );
    </script>
</head>


<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="searchTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Name</th>
        <th>User Name</th>
        <th>Age</th>
        <th>Gym</th>
        <th>Location</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.userName}</td>
                <td>${user.age}</td>
                <td>${user.gymName}</td>
                <td>${user.location}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>