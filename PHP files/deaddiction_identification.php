<?php
require "Bridge.php";

$Number_of_Narcotics_Users=$_POST["Number_of_Narcotics_Users"];
$Type_of_Drug_Used=$_POST["Type_of_Drug_Used"];
$Quantity_of_Drugs_Used=$_POST["Quantity_of_Drugs_Used"];
$Price_of_Drugs=$_POST["Price_of_Drugs"];
$Reason_for_Drug_Abuse=$_POST["Reason_for_Drug_Abuse"];
$Drug_Abuse_Prone_Area=$_POST["Drug_Abuse_Prone_Area"];
$Gathering_Area_for_Abuser=$_POST["Gathering_Area_for_Abuser"];
$Time_of_Supply=$_POST["Time_of_Supply"];
$Time_of_Consumption=$_POST["Time_of_Consumption"];
$Place_of_Purchase=$_POST["Place_of_Purchase"];
$Suggestions=$_POST["Suggestionss"];


$mysql_qry = "insert into awareness_info(Number_of_Narcotics_Users, Type_of_Drug_Used,Quantity_of_Drugs_Used,Price_of_Drugs,Reason_for_Drug_Abuse, Drug_Abuse_Prone_Area,
Gathering_Area_for_Abuser,Time_of_Supply,Time_of_Consumption,Place_of_Purchase,Suggestionss) 
values ('$Number_of_Narcotics_Users', '$Type_of_Drug_Used', '$Quantity_of_Drugs_Used','$Price_of_Drugs', '$Reason_for_Drug_Abuse', '$Drug_Abuse_Prone_Area',
'$Gathering_Area_for_Abuser','$Time_of_Supply','$Time_of_Consumption','$Place_of_Purchase','$Suggestionss')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
