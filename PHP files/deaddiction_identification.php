<?php
require "Bridge.php";

$Number_of_Narcotics_Users=$_POST["num_narc_usr"];
$Type_of_Drug_Used=$_POST["typ_drg"];
$Quantity_of_Drugs_Used=$_POST["quan_drg"];
$Price_of_Drugs=$_POST["prc_drg"];
$Reason_for_Drug_Abuse=$_POST["rsn_drg"];
$Drug_Abuse_Prone_Area=$_POST["drug_prn_area"];
$Gathering_Area_for_Abuser=$_POST["gathering_area"];
$Time_of_Supply=$_POST["supply_time"];
$Time_of_Consumption=$_POST["consump_time"];
$Place_of_Purchase=$_POST["plc_prchse"];
$Suggestions=$_POST["sggs_id"];


$mysql_qry = "insert into awareness_info(num_narc_usr,typ_drg,quan_drg,prc_drg,rsn_drg,drug_prn_area,gathering_area,supply_time,consump_time,plc_prchse,sggs_id) 
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
