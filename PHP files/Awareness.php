<?php
require "Bridge.php";
$Awareness_Activity_Completion =$_POST["a_a_c"];
$Activity_Performed_for_Awareness=$_POST["a_activity"];
$Activity_Audience=$_POST["a_audience"];
$Audience_Feedback=$_POST["a_fdbk"];
$Problems_Faced=$_POST["a_prob"];
$Suggestions=$_POST["a_sug"];


$mysql_qry = "insert into feedback(a_a_c, a_activity, a_audience, a_fdbk, a_prob, a_sug) values ('$Awareness_Activity_Completion', '$Activity_Performed_for_Awareness', '$Activity_Audience',
'$Audience_Feedback', '$Problems_Faced', '$Suggestions')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission Successful";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
