<?php
require "Bridge.php";

$Positive_Positive_Activity_Performed_Completion=$_POST["Positive_Positive_Activity_Performed_Completion"];
$Positive_Activity_Performed=$_POST["Positive_Activity_Performed"];
$Activity_Venue=$_POST["Activity_Venue"];
$Time_at_Which_Activity_Was_Performed=$_POST["Time_at_Which_Activity_Was_Performed"];
$Activity_Duration=$_POST["Activity_Duration"];
$Number_of_People_Invited_to_Participate=$_POST["Number_of_People_Invited_to_Participate"];
$Actual_Number_of_Participants=$_POST["Actual_Number_of_Participants"];
$Participants=$_POST["Participants"];
$Availability_of_an_Identity_of_the_Official=$_POST["Availability_of_an_Identity_of_the_Official"];
$Identity_of_the_Official=$_POST["Identity_of_the_Official"];
$Existence_of_Problem=$_POST["Existence_of_Problem"];
$Problem=$_POST["Problem"];
$Existing_Infrastructure=$_POST["Existing_Infrastructure"];
$Problems_Faced_Regarding_Infrastructure=$_POST["Problems_Faced_Regarding_Infrastructure"];
$Changes_Made_in_Infrastructure=$_POST["Changes_Made_in_Infrastructure"];
$Suggestions=$_POST["Suggestionss"];


$mysql_qry = "insert into awareness_info(Positive_Positive_Activity_Performed_Completion, Positive_Activity_Performed,Activity_Venue,Time_at_Which_Activity_Was_Performed,Activity_Duration, Number_of_People_Invited_to_Participate,
Actual_Number_of_Participants,Participants,Availability_of_an_Identity_of_the_Official,Identity_of_the_Official,Existence_of_Problem,Problem,Existing_Infrastructure,Problems_Faced_Regarding_Infrastructure,Changes_Made_in_Infrastructure, Suggestionss) 
values ('$Positive_Positive_Activity_Performed_Completion', '$Positive_Activity_Performed', '$Activity_Venue','$Time_at_Which_Activity_Was_Performed', '$Activity_Duration', '$Number_of_People_Invited_to_Participate','$Actual_Number_of_Participants','$Participants','$Availability_of_an_Identity_of_the_Official','$Identity_of_the_Official','$Existence_of_Problem','$Problem','$Existing_Infrastructure','$Problems_Faced_Regarding_Infrastructure','$Changes_Made_in_Infrastructure','$Suggestionss')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
