<%@include file="templates/head.jsp"%>
<%@include file="templates/taglib.jsp"%>
<script language="JavaScript">
    function OnSearch() {
        var searchType = document.getElementById("searchType")
        if (searchType === "gymName") {
            $.get('localhost/controller/searchGym');
/*
            document.SearchForm.action = "/searchGym";
            document.SearchForm.target = "/results"
            document.SearchForm.submit();
*/
        } else {
            $.get('localhost/webapp/searchUser');
/*
            document.SearchForm.action = "/searchUser";
            document.SearchForm.target = "/results"
            document.SearchForm.submit();
*/
        }
    }

    function OnViewUsers() {

    }

    function OnViewGyms() {

    }
</script>