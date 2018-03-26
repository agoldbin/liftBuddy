<%-- Gym search results page --%>
<!DOCTYPE html>

<%@include file="taglib.jsp"%>
<c:set var="title" value="Gym Query Results" />

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
        <th>Gym</th>
        <th>User Name</th>

        </thead>
        <tbody>
        <c:forEach var="gym" items="${gyms}">
            <tr>
                <td>${gym.gymName}</td>
                <td>
                    <c:forEach var="user" items="${gym.users}">
                        ${user.firstName} ${user.lastName}<br/>
                    </c:forEach>
                </td>
            </tr>


        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>