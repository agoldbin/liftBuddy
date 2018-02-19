<%@include file="taglib.jsp"%>
<c:set var="title" value="Gym Query Results" />
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
        <c:forEach var="gym" items="${gyms}">
            <thead>
                <th>Gym</th>
                <th>Gym Goer</th>
                <th>Age</th>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                <tr>
                    <td>${gym.gymName}</td>
                    <td>${user.firstName} ${user.lastName}</td>

                </tr>
                </c:forEach>
            </tbody>
        </c:forEach>

        <!--
        <thead>
        <th>Gym</th>
        <th>Gym Goer</th>
        <th>Age</th>
        <th>Location</th>
        </thead>
        <tbody>
        <c:forEach var="gym" items="${gyms}">
            <tr>
                <td>${gym.gymName}</td>
                <td>$</td>
            </tr>
        </c:forEach>
        </tbody>
        -->
    </table>
</div>

</body>
</html>