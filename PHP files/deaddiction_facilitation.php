<?php
require "awareinit.php";

$Number_of_Victims_Approached_Monthly=$_POST["Number_of_Victims_Approached_Monthly"];
$Number_of_Victims_Needed_to_be_Revisited_for_Convincing=$_POST["Number_of_Victims_Needed_to_be_Revisited_for_Convincing"];
$Number_of_Victims_Linked_to_an_OOAT_Centre=$_POST["Number_of_Victims_Linked_to_an_OOAT_Centre"];
$Price_of_Drugs=$_POST["Price_of_Drugs"];
$Reason_for_Drug_Abuse=$_POST["Reason_for_Drug_Abuse"];
$Drug_Abuse_Prone_Area=$_POST["Drug_Abuse_Prone_Area"];
$Gathering_Area_for_Abuser=$_POST["Gathering_Area_for_Abuser"];
$Time_of_Supply=$_POST["Time_of_Supply"];
$Time_of_Consumption=$_POST["Time_of_Consumption"];
$Place_of_Purchase=$_POST["Place_of_Purchase"];
$Suggestions=$_POST["Suggestionss"];


$mysql_qry = "insert into awareness_info(Number_of_Victims_Approached_Monthly, Number_of_Victims_Needed_to_be_Revisited_for_Convincing,Number_of_Victims_Linked_to_an_OOAT_Centre,Price_of_Drugs,Reason_for_Drug_Abuse, Drug_Abuse_Prone_Area,
Gathering_Area_for_Abuser,Time_of_Supply,Time_of_Consumption,Place_of_Purchase,Suggestionss) 
values ('$Number_of_Victims_Approached_Monthly', '$Number_of_Victims_Needed_to_be_Revisited_for_Convincing', '$Number_of_Victims_Linked_to_an_OOAT_Centre','$Price_of_Drugs', '$Reason_for_Drug_Abuse', '$Drug_Abuse_Prone_Area',
'$Gathering_Area_for_Abuser','$Time_of_Supply','$Time_of_Consumption','$Place_of_Purchase','$Suggestionss')";


if($awareinit->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $awareinit->error;
}

$awareinit->close();
?>
