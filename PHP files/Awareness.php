<?php
require "awareinit.php";
$attempt_status=$_POST["attempt_status"];
$activity=$_POST["activity"];
$no_of_people=$_POST["no_of_people"];
$feedback=$_POST["feedback"];
$probs=$_POST["probs"];
$suggestions=$_POST["suggestions"];


$mysql_qry = "insert into awareness_info(attempt_status, activity, no_of_people,
feedback, probs, suggestions) values ('$attempt_status', '$activity', '$no_of_people',
'$feedback', '$probs', '$suggestions')";


if($awareinit->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $awareinit->error;
}

$awareinit->close();
?>