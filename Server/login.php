<?php
	include_once "config.php";
if (isset($_GET['email']))
{
	
	$email = $_GET['email'];
	$pass = $_GET['pass'];
	
	
	if (check($email,$pass))
	{
		echo "success";
	}
	else
	{
		echo "error";
	}
}

function check($email,$pass)
{
  $sql="select * from taikhoan where email='$email' and pass='$pass'";
  $query=mysql_query($sql);

  if(mysql_num_rows($query) > 0)
  {
	return 1;
  }
  return 0;
}


?>