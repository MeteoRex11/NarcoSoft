<?php
require "Bridge.php";
$Awareness_Activity_Performed_for_Awareness_Completion=$_POST["Awareness_Activity_Performed_for_Awareness_Completion"];
$Activity_Performed_for_Awareness=$_POST["Activity_Performed_for_Awareness"];
$Activity_Audience=$_POST["Activity_Audience"];
$Audience_Feedback=$_POST["Audience_Feedback"];
$Problems_Faced=$_POST["Problems_Faced"];
$Suggestions=$_POST["Suggestions"];


$mysql_qry = "insert into awareness_info(Awareness_Activity_Performed_for_Awareness_Completion, Activity_Performed_for_Awareness, Activity_Audience,
Audience_Feedback, Problems_Faced, Suggestions) values ('$Awareness_Activity_Performed_for_Awareness_Completion', '$Activity_Performed_for_Awareness', '$Activity_Audience',
'$Audience_Feedback', '$Problems_Faced', '$Suggestions')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
