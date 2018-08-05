<?php
require "Bridge.php";
$Number_of_Vulnerable_Groups_Identified=$_POST["N_of_VG"];
$Number_of_Vulnerable_Groups_Counseled=$_POST["N_of_VG_cnsld"];
$Problems=$_POST["Prob"];
$Suggestions=$_POST["Suggest"];


$mysql_qry = "insert into awareness_info(N_of_VG, N_of_VG_cnsld, Prob,
Suggest) values ('$Number_of_Vulnerable_Groups_Identified', '$Number_of_Vulnerable_Groups_Counseled', '$Problems',
'$Suggestions')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();

?>
