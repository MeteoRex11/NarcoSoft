<?php
require "Bridge.php";

$Number_of_Victims_Approached_Monthly=$_POST["victims_vstd_monthly"];
$Number_of_Victims_Needed_to_be_Revisited_for_Convincing=$_POST["victims_revstd_monthly"];
$Number_of_Victims_Linked_to_an_OOAT_Centre=$_POST["victims_linked_ooat"];
$Price_of_Drugs=$_POST["prc_drg"];
$Reason_for_Drug_Abuse=$_POST["rsn_drg"];
$Drug_Abuse_Prone_Area=$_POST["drug_prn_area"];
$Gathering_Area_for_Abuser=$_POST["gathering_area"];
$Time_of_Supply=$_POST["supply_time"];
$Time_of_Consumption=$_POST["consump_time"];
$Place_of_Purchase=$_POST["plc_prchse"];
$Suggestions=$_POST["sggs_id"];


$mysql_qry = "insert into awareness_info(victims_vstd_monthly,victims_revstd_monthly,victims_linked_ooat,prc_drg,rsn_drg,drug_prn_area,
gathering_area,supply_time,consump_time,plc_prchse,sggs_id) 
values ('$Number_of_Victims_Approached_Monthly', '$Number_of_Victims_Needed_to_be_Revisited_for_Convincing', '$Number_of_Victims_Linked_to_an_OOAT_Centre','$Price_of_Drugs', '$Reason_for_Drug_Abuse', '$Drug_Abuse_Prone_Area',
'$Gathering_Area_for_Abuser','$Time_of_Supply','$Time_of_Consumption','$Place_of_Purchase','$Suggestionss')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
