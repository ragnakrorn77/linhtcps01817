<?php
	include_once "config.php";
if (isset($_GET['email']))
{
	
	$email = $_GET['email'];
	$pass = $_GET['pass'];
	$passcode = $_GET['passcode'];
	
	
	if (check($email))
	{
		echo "exits";
	}
	else
	{
	
	$sql = "INSERT INTO taikhoan(email,pass,passcode) VALUES('$email','$pass','$passcode')";
	mysql_query($sql);
	

	
	mkdir($email);
	$to = $email."/"."thuchi.db";
        $toupload = $email."/"."UploadToServer.php";
	copy('thuchi.db', $to );
	copy('UploadToServer.php', $toupload);

	echo "success";
	}
}

function check($email)
{
  $sql="select * from taikhoan where email='$email'";
  $query=mysql_query($sql);
 
  
  if(mysql_num_rows($query) > 0)
  {
	return 1;
  }
  return 0;
}


?>