<%-- Jsp for all the files/plugins to be included throughout site --%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <%--<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>--%>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <!-- jQuery slim -->
        <script src="https://code.jquery.com/jquery-3.1.1.slim.js" integrity="sha256-5i/mQ300M779N2OVDrl16lbohwXNUdzL/R2aVUXyXWA="   crossorigin="anonymous"></script>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!-- The next two items are to support jQuery datatables. Learn more about datatables here:https://datatables.net -->
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>


        <%-- Media query CSS since Materialize doesn't work for crap --%>
        <%--<link rel="stylesheet" href="css/screens.css">--%>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="css/materialize.css">
        <!-- Compiled and minified JavaScript -->
        <script src="js/materialize.js"></script>

        <title>${title}</title>
    </head>

    <body>
        <script>
            //********************* Materialize Variables *********************\\
            // Initialize PARALLAX (used for styling of pages)
            $(document).ready(function(){
            $('.parallax').parallax();
            });

            // Initialize MODAL (used for user login)
            $(document).ready(function(){
            $('#login').modal();
            });
            $('#login').modal('open');

            // Initialize SELECT boxes (used in forms)
            $(document).ready(function() {
            $('select').material_select();
            });

            // Initialize SIDENAV bar for headers
            $(document).ready(function(){
            $('.sidenav').sidenav();
            });
        </script>
    </body>
</html>





    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->--%>