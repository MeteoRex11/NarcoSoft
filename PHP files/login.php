<?php
require "init.php";
$UID=$_POST["UID"];
$date=$_POST["date"];
$mysql_qry = "select * from login_screen where UID_number like '$UID' and birth_date like '$date';";
$result = mysqli_query($con ,$mysql_qry);
if(mysqli_num_rows($result)>0){
	echo "Login sucessfull";
	
}
else{
	echo "Either UID Number or DOB is incorrect. Pls try again.";
}

?>
