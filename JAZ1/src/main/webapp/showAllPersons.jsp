<%@page import="com.example.servletjspdemo.domain.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	ArrayList<Person> persons = (ArrayList<Person>) request.getServletContext().getAttribute("persons");
	for(Person p: persons) {
		out.println(p.getFirstName()+" "+p.getLastName()+" "+p.getOrganisation()+" "+p.getEmail()+" "
				+p.getSource()+" "+p.getOtherSource()+" "+p.getJob()+"<br />");
	}
%>
<p>
  <a href="index.jsp">Return to the homepage</a></a>
</p>


</body>
</html>