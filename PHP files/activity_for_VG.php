<?php
require "awareinit.php";

$efforts=$_POST["efforts"];
$activity=$_POST["activity"];
$no_of_Vpeople=$_POST["no_of_Vpeople"];
$no_of_Vpeople_counseled=$_POST["time"];
$probs_counseling=$_POST["probs_counseling"];
$probs_family=$_POST["probs_family"];
$other_probs=$_POST["other_probs"];
$suggestion=$_POST["suggestions"];


$mysql_qry = "insert into awareness_info(efforts, activity,no_of_Vpeople,no_of_Vpeople_counseled,probs_counseling, probs_family,
other_probs,suggestions) 
values ('$efforts', '$activity', '$no_of_Vpeople','$no_of_Vpeople_counseled', '$probs_counseling', '$probs_family','$other_probs','$suggestions')";


if($awareinit->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $awareinit->error;
}

$awareinit->close();
?>
