<?php
require "Bridge.php";

$Positive_Activity_Completion=$_POST["pa_c"];
$Positive_Activity_Performed=$_POST["pa_activity"];
$Activity_Venue=$_POST["pa_venue"];
$Time_at_Which_Activity_Was_Performed=$_POST["pa_time"];
$Activity_Duration=$_POST["pa_duration"];
$Number_of_People_Invited_to_Participate=$_POST["pa_invites"];
$Actual_Number_of_Participants=$_POST["pa_participants"];
$Participants=$_POST["participants"];
$Availability_of_an_Official=$_POST["pa_ofcl"];
$Identity_of_the_Official=$_POST["ofcl_identity"];
$Existence_of_Problem=$_POST["pa_prob_e"];
$Problem=$_POST["pa_prob"];
$Existing_Infrastructure=$_POST["pa_e_infra"];
$Problems_Faced_Regarding_Infrastructure=$_POST["pa_infra_prob"];
$Changes_Made_in_Infrastructure=$_POST["pa_add_infra"];
$Suggestions=$_POST["pa_sug"];


$mysql_qry = "insert into feedback(pa_c, pa_activity, pa_venue, pa_time, pa_duration, pa_invites, pa_participants, participants, pa_ofcl, ofcl_identity, pa_prob_e, pa_prob, pa_e_infra, pa_infra_prob, pa_add_infra, pa_sug) 
values ('$Positive_Activity_Completion', '$Positive_Activity_Performed', '$Activity_Venue','$Time_at_Which_Activity_Was_Performed', '$Activity_Duration', '$Number_of_People_Invited_to_Participate','$Actual_Number_of_Participants','$Participants','$Availability_of_an_Official','$Identity_of_the_Official','$Existence_of_Problem','$Problem','$Existing_Infrastructure','$Problems_Faced_Regarding_Infrastructure','$Changes_Made_in_Infrastructure','$Suggestions')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission Successful";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
