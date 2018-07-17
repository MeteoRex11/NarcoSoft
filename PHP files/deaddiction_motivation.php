<?php
require "Bridge.php";

$Place_of_Approach=$_POST["Place_of_Approach"];
$Method_of_Approach=$_POST["Method_of_Approach"];
$Problems_Regarding_Victims=$_POST["Problems_Regarding_Victims"];
$Problems_Regarding_Victims_Families=$_POST["Problems_Regarding_Victim's_Families"];
$Arguments_given_by_them=$_POST["Arguments_given_by_them"];
$Convincing_Factor_Given=$_POST["Convincing_Factor_Given"];
$Attitude_of_Victims=$_POST["Attitude_of_Victims"];
$Suggestions=$_POST["Suggestionss"];


$mysql_qry = "insert into awareness_info(Place_of_Approach, Method_of_Approach,Problems_Regarding_Victims,Problems_Regarding_Victim's_Families,Arguments_given_by_them, Convincing_Factor_Given,
Attitude_of_Victims,Suggestionss) 
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
