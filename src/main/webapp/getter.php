<?php

	$username = "agoldbin";
	$password = "dontforget";
	$hostname = "localhost";

	$dbhandle = mysql_connect($hostname, $username, $password) or die("Unable to connect to MySQL");
	$selected = mysql_select_db("dropdownvalues", $dbhandle) or die("Could not select examples");
	$choice = mysql_real_escape_string($_GET['choice']);

	$query = "SELECT * FROM gym WHERE category='$gym_name'";

	$result = mysql_query($query);

	while ($row = mysql_fetch_array($result)) {
   		echo "<option>" . $row{'gym'} . "</option>";
	}
?>