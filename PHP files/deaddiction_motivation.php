<?php
require "Bridge.php";

$Place_of_Approach=$_POST["apprch_plc"];
$Method_of_Approach=$_POST["apprch_mthd"];
$Problems_Regarding_Victims=$_POST["prblm_victim"];
$Problems_Regarding_Victims_Families=$_POST["prblm_victim_fam"];
$Arguments_given_by_them=$_POST["args_victim"];
$Convincing_Factor_Given=$_POST["cnvnce_factor"];
$Attitude_of_Victims=$_POST["attd_victim"];
$Suggestions=$_POST["sggs_mtv"];


$mysql_qry = "insert into awareness_info(apprch_plc,apprch_mthd,prblm_victim,prblm_victim_fam,args_victim, cnvnce_factor,
attd_victim,sggs_mtv) 
values ('$Place_of_Approach', '$Method_of_Approach', '$Problems_Regarding_Victims','$Problems_Regarding_Victim's_Families', '$Arguments_given_by_them', '$Convincing_Factor_Given',
'$Attitude_of_Victims','$Suggestionss')";


if($Bridge->query($mysql_qry) === TRUE){
	echo "Submission sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $Bridge->error;
}

$Bridge->close();
?>
