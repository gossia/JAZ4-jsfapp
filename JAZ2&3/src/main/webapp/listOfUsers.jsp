<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.User"%>
<%@ page import="repository.DummyDb"%>
<%@ page import="web.WebContextNames"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>List of registered users:</h3>
<jsp:useBean id="users" class="domain.User" scope="application" />
<%
	ServletContext ctx = request.getServletContext();
	DummyDb db = (DummyDb)ctx.getAttribute(WebContextNames.listOfUsers);
	for(User u : db.users) {
		out.println(u.getUserName()+" "+u.getPrivilege()+"<br>");
	}
	
%>
<p><br><a href="addDelPrivilegesForm.jsp">Privilege management</a></p>
<p><a href="userProfile.jsp">Return to user profile</a></p>
</body>
</html>