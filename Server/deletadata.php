<?php
	include_once "config.php";
if (isset($_GET['email']))
{
	
	
	$to = $email."/"."thuchi.db";
	copy('thuchi.db', $to );
	
	echo "success";
	
}

?>