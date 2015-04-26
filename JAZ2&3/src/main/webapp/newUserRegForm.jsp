<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Register:</h3>
<form action="Reg" method="post">
	<table>
 	<tr><td>Username:</td><td><input type="text" name="username"></td></tr>
 	<tr><td>Password:</td><td><input type="text" name="password"></td></tr>
 	<tr><td>Confirm Password:</td><td><input type="text" name="password_confirm"></td></tr>
 	<tr><td>Email:</td><td><input type="text" name="email"></td></tr>
 	</table><br>
 	<input type="submit" value="Register">	
</form>
<h4><font color=red>
	<%
		if(request.getAttribute("retypePassword") != null)
			out.println(request.getAttribute("retypePassword"));
		if(request.getAttribute("fillAll") != null)
			out.println(request.getAttribute("fillAll"));
		if(request.getAttribute("usernameExists") != null)
			out.println(request.getAttribute("usernameExists"));
	%>
</font></h4>
</body>
</html>