<?php
require "Bridge.php";
$Number_of_Vulnerable_Groups_Identified=$_POST["Number_of_Vulnerable_Groups_Identified"];
$Number_of_Vulnerable_Groups_Counseled=$_POST["Number_of_Vulnerable_Groups_Counseled"];
$Problems=$_POST["Problems"];
$Suggestions=$_POST["Suggestions"];


$mysql_qry = "insert into awareness_info(Number_of_Vulnerable_Groups_Identified, Number_of_Vulnerable_Groups_Counseled, Problems,
Suggestions) values ('$Number_of_Vulnerable_Groups_Identified', '$Number_of_Vulnerable_Groups_Counseled', '$Problems',
'$Suggestions')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();

?>
