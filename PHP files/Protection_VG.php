<?php
require "Bridge.php";

$Efforts_Made_for_Protection_of_Vulnerable_Group=$_POST["Effort_for_VG"];
$Activities_Promoted_for_Protection_of_Vulnerable_Groups=$_POST["Actvty_for_VG"];
$Vulnerable_Individuals_Linked_to_a_Positive_Activity=$_POST["Vulnrabls_for_acts"];
$Individuals_Recommended_for_Specific_Expert_Counselling=$_POST["VG_recommended"];
$Problems_Regarding_Acceptance_of_a_Need_of_Protection=$_POST["prob_accept_protect"];
$Problems_Regarding_Counselling_Arrangement=$_POST["counslling_arangment"];
$Other_Problems=$_POST["probs"];
$Suggestion=$_POST["suggest"];


$mysql_qry = "insert into awareness_info(Effort_for_VG, Actvty_for_VG,Vulnrabls_for_actvty,VG_recommended,prob_accept_protection, counslling_arangment,
probs,suggest) 
values ('$Efforts_Made_for_Protection_of_Vulnerable_Group', '$Activities_Promoted_for_Protection_of_Vulnerable_Groups', '$Vulnerable_Individuals_Linked_to_a_Positive_Activity','$Individuals_Recommended_for_Specific_Expert_Counselling', '$Problems_Regarding_Acceptance_of_a_Need_of_Protection', '$Problems_Regarding_Counselling_Arrangement','$Other_Problems','$Suggestions')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
