<?php
require "awareinit.php";
$no_of_VG=$_POST["no_of_VG"];
$no_of_VG_counseled=$_POST["no_of_VG_counseled"];
$probs=$_POST["probs"];
$suggestions=$_POST["suggestions"];


$mysql_qry = "insert into awareness_info(no_of_VG, no_of_VG_counseled, probs,
suggestions) values ('$no_of_VG', '$no_of_VG_counseled', '$probs',
'$suggestions')";


if($awareinit->query($mysql_qry) === TRUE){
	echo "Submition sucessfull";
	
}
else{
	echo "Error: " . $mysql_qry . "<br>" . $awareinit->error;
}

$awareinit->close();

?>
