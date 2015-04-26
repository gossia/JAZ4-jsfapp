<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Log in:</h3>
<form action="Login" method="post">
	<table>
 	<tr><td>Username:</td><td><input type="text" name="username"></td></tr>
 	<tr><td>Password:</td><td><input type="text" name="password"></td></tr>
 	</table><br>
 	<input type="submit" value="Log in">
</form>
<br>
<h4>Don't have an account? <a href="newUserRegForm.jsp">Register</a></h4>
<h4><font color=red>
	<%
		if(request.getAttribute("badUserOrPass") != null)
			out.println(request.getAttribute("badUserOrPass"));
	%>
</font></h4>
</body>
</html>