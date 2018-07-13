<?php
require "awareinit.php";

$Efforts_Made_for_Protection_of_Vulnerable_Group=$_POST["Efforts_Made_for_Protection_of_Vulnerable_Group"];
$Activities_Promoted_for_Protection_of_Vulnerable_Groups=$_POST["Activities_Promoted_for_Protection_of_Vulnerable_Groups"];
$Vulnerable_Individuals_Linked_to_a_Positive_Activity=$_POST["Vulnerable_Individuals_Linked_to_a_Positive_Activity"];
$Individuals_Recommended_for_Specific_Expert_Counselling=$_POST["time"];
$Problems_Regarding_Acceptance_of_a_Need_of_Protection=$_POST["Problems_Regarding_Acceptance_of_a_Need_of_Protection"];
$Problems_Regarding_Counselling_Arrangement=$_POST["Problems_Regarding_Counselling_Arrangement"];
$Other_Problems=$_POST["Other_Problems"];
$Suggestion=$_POST["Suggestions"];


$mysql_qry = "insert into awareness_info(Efforts_Made_for_Protection_of_Vulnerable_Group, Activities_Promoted_for_Protection_of_Vulnerable_Groups,Vulnerable_Individuals_Linked_to_a_Positive_Activity,Individuals_Recommended_for_Specific_Expert_Counselling,Problems_Regarding_Acceptance_of_a_Need_of_Protection, Problems_Regarding_Counselling_Arrangement,
Other_Problems,Suggestions) 
values ('$Efforts_Made_for_Protection_of_Vulnerable_Group', '$Activities_Promoted_for_Protection_of_Vulnerable_Groups', '$Vulnerable_Individuals_Linked_to_a_Positive_Activity','$Individuals_Recommended_for_Specific_Expert_Counselling', '$Problems_Regarding_Acceptance_of_a_Need_of_Protection', '$Problems_Regarding_Counselling_Arrangement','$Other_Problems','$Suggestions')";


if($awareinit->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $awareinit->error;
}

$awareinit->close();
?>
