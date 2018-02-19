<%@include file="head.jsp"%>
<html>
<body>
<h2>Lift Buddy Display</h2>
<form action="searchForm" class="form-inline">
    <div class="form-group">
        <label for="searchTerm">Search</label>
        <input type="text" class="form-control" name="searchTerm" id="searchTerm" aria-describedby="searchTermHelp" placeholder="Search">
    </div>
    <div class="form-group">
        <label>Search by:</label>
        <select class="form-control" name="searchType" id="searchType">
            <option value="id">User ID</option>
            <option value="lastName">User Last Name</option>
            <option value="gymName">Gym Name</option>

        </select>
    </div>
    <button class="btn btn-primary" type="submit" name="submit" value="search">
        Submit Search
    </button>
    <button class="btn btn-primary" type="submit" name="submit" value="viewAllUsers">
        View All Users
    </button>

    <button class="btn btn-primary" type="submit" name="submit" value="viewAllGyms">
        View All Gyms
    </button>

</form>
</body>
</html>