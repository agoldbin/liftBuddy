<%-- Admin Gym search results page --%>
<!DOCTYPE html>

<%@include file="templates/taglib.jsp"%>
<c:set var="title" value="Admin Gym Query Results" />

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
        <th>Gym</th>
        <th>Edit</th>
        <th>Remove</th>
        </thead>
        <tbody>
        <c:forEach var="gym" items="${gyms}">
            <tr>
                <td>${gym.gymName}</td>
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