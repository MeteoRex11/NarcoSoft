<?php
require "awareinit.php";

$attempt_status=$_POST["attempt_status"];
$activity=$_POST["activity"];
$venue=$_POST["venue"];
$time=$_POST["time"];
$duration=$_POST["duration"];
$no_of_people=$_POST["no_of_people"];
$no_of_people_participated=$_POST["no_of_people_participated"];
$who_participated=$_POST["who_participated"];
$official_status=$_POST["official_status"];
$official=$_POST["official"];
$prob_status=$_POST["prob_status"];
$probs=$_POST["probs"];
$infrastructure=$_POST["infrastructure"];
$probs_infra=$_POST["probs_infra"];
$effortsToCreateInfra=$_POST["effortsToCreateInfra"];
$suggestion=$_POST["suggestions"];


$mysql_qry = "insert into awareness_info(attempt_status, activity,venue,time,duration, no_of_people,
no_of_people_participated,who_participated,official_status,official,prob_status,probs,infrastructure,probs_infra,effortsToCreateInfra, suggestions) 
values ('$attempt_status', '$activity', '$venue','$time', '$duration', '$no_of_people','$no_of_people_participated','$who_participated','$official_status','$official','$prob_status','$probs','$infrastructure','$probs_infra','$effortsToCreateInfra','$suggestions')";


if($awareinit->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $awareinit->error;
}

$awareinit->close();
?>
