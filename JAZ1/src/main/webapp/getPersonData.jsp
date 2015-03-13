<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conference Registration</title>
</head>
<body>

<center>
<h3>Please book for the conference "JAVA 4 US!" by filling the form below</h3>

<form action="FirstServlet" method="post">
	<table>
 	<tr><td>First name:</td><td><input type="text" name="firstName"></td></tr>
 	<tr><td>Last name:</td><td><input type="text" name="lastName"></td></tr>
	<tr><td>Organization:</td><td><input type="text" name="organization"></td></tr>
	<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
	<tr><td>Confirm Email:</td><td><input type="text" name="email_confirm"></td></tr>
	</table>
	<table>
	<tr><td><b>Where have you heard about us?</b></td></tr>
	</table>
	<table>
		<tr><td><input type="radio" name=source value="jobAd">Job Advertisement</td></tr>
		<tr><td><input type="radio" name=source value="schoolAd">School Advertisement</td></tr>
		<tr><td><input type="radio" name=source value="fb">Facebook</td></tr>
		<tr><td><input type="radio" name=source value="friends">Friends</td></tr>
		<tr><td><input type="radio" name=source value="other">Other <input type="text" name="otherSource"></td></tr>
	</table>
	<table>
	<tr><td><b>What do you do?</b></td></tr>
	<tr><td><input type="text" name="job"></td></tr>
	</table>

  <input type="submit" value=" REGISTER ">
  
</form>
</center>
</body>
</html>