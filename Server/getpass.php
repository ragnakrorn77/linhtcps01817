<?php
	include_once "config.php";
if (isset($_GET['email']))
{
	
	$email = $_GET['email'];
	$pass = $_GET['passcode'];
	
	
	if (strcmp(check($email,$pass),"null") == 0)
	{
		echo "error";
	}
	else
	{
		echo check($email,$pass);
	}
}

function check($email,$pass)
{
  $sql="select * from taikhoan where email='$email' and passcode='$pass'";
  $query=mysql_query($sql);

  if(mysql_num_rows($query) > 0)
  {
        while($row=mysql_fetch_array($query))
	{
	      return $row['pass'];
        }
  }
  return "null";
}


?>	