<?php
$servername = "mysql.hostinger.vn";
$username = "u806092161_money";
$password = "receivetheletter";

$conn=mysql_connect($servername, $username, $password) or die("can't connect database");
mysql_select_db("u806092161_thuch",$conn);
mysql_set_charset('utf8',$conn);



?>