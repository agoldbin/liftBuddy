<%@include file="taglib.jsp"%>
<c:set var="title" value="Query Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Gym</th>
        <th>Name</th>
        <th>User Name</th>
        <th>Age</th>
        <th>Location</th>
        </thead>
        <tbody>
        <c:forEach var="gym" items="${gyms}">
            <tr>
                <td>${gym.gymName}</td>
                <td>
                <c:forEach var="user" items="${gym.users}">
                    ${user.firstName} ${user.lastName}
                    ${user.userName}
                    ${user.age}
                    ${user.location}
                </c:forEach>
                </td>
            </tr>


        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>