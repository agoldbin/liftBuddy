<%@include file="jsp/head.jsp"%>
<%@include file="jsp/taglib.jsp"%>
<script language="JavaScript">
    function OnSearch() {
        var searchType = document.getElementById("searchType")
        if (searchType === "gymName") {
            $.get('localhost/controller/searchGym');
/*
            document.searchForm.action = "/searchGym";
            document.searchForm.target = "/results"
            document.searchForm.submit();
*/
        } else {
            $.get('localhost/webapp/searchUser');
/*
            document.searchForm.action = "/searchUser";
            document.searchForm.target = "/results"
            document.searchForm.submit();
*/
        }
    }

    function OnViewUsers() {

    }

    function OnViewGyms() {

    }
</script>