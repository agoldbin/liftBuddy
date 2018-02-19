<%@include file="taglib.jsp"%>
<c:set var="title" value="Query Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#searchTable').DataTable();
    } );
</script>

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
                <c:forEach var="gym" items="${gyms}">
                    <td>${gym.gymName}</td>
                </c:forEach>
                <td>${user.location}</td>
            </tr>
        </c:forEach>

        <!--
                <c:forEach var="gym" items="${gyms}">
                    <tr>
                        <td>${gym.gymName}</td>
                        <c:forEach var="user" items="${gym.users}">
                            <tr>

                            <td>${user.firstName} ${user.lastName}</td>
                            <td>${user.userName}</td>
                            <td>${user.age}</td>
                            <td>${user.location}</td>
                            </tr>
                        </c:forEach>
                    </tr>
                </c:forEach>
        -->
        </tbody>
    </table>
</div>

</body>
</html>