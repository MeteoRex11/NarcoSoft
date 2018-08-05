<?php
require "Bridge.php";

$Number_of_Narcotics_Users=$_POST["Num_Narc_Usr"];
$Type_of_Drug_Used=$_POST["Typ_Drg"];
$Quantity_of_Drugs_Used=$_POST["Quan_Drg"];
$Price_of_Drugs=$_POST["Prc_Drg"];
$Reason_for_Drug_Abuse=$_POST["Rsn_Drg"];
$Drug_Abuse_Prone_Area=$_POST["Drug_Prn_Area"];
$Gathering_Area_for_Abuser=$_POST["Gathering_Area"];
$Time_of_Supply=$_POST["Supply_Time"];
$Time_of_Consumption=$_POST["Consump_Time"];
$Place_of_Purchase=$_POST["Plc_Prchse"];
$Suggestions=$_POST["Sggs"];


$mysql_qry = "insert into awareness_info(Num_Narc_Usr,Typ_Drg,Quan_Drg,Prc_Drg,Rsn_Drg, Drug_Prn_Area,Gathering_Area,Supply_Time,Consump_Time,Plc_Prchse,Sggs) 
values ('$Number_of_Narcotics_Users', '$Type_of_Drug_Used', '$Quantity_of_Drugs_Used','$Price_of_Drugs', '$Reason_for_Drug_Abuse', '$Drug_Abuse_Prone_Area',
'$Gathering_Area_for_Abuser','$Time_of_Supply','$Time_of_Consumption','$Place_of_Purchase','$Suggestions')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
