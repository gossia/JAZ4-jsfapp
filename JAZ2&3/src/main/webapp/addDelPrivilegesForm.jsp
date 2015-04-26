<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Change privileges for user:</h3>
<form action="Privilege" method="post">
	<table>
 	<tr><td>Username:</td><td><input type="text" name="username"></td>
 	<td><input type="submit" value="Confirm"></td></tr>
 	</table>
</form>
<p><br><a href="listOfUsers.jsp">List of users</a></p>
<h4><font color=red>
	<%
		if(request.getAttribute("noSuchUser") != null)
			out.println(request.getAttribute("noSuchUser"));
		if(request.getAttribute("badUser") != null)
			out.println(request.getAttribute("badUser"));
	%>
</font></h4>
</body>
</html>