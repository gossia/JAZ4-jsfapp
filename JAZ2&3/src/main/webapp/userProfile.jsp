<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.User"%>
<%@ page import="repository.DummyDb"%>
<%@ page import="domain.Address"%>
<%@ page import="web.WebContextNames"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> Hello <%=request.getSession().getAttribute("username")%>! This is your profile.</h3>
Your username: <%=session.getAttribute("username")%><br><br>
Your email: <%=session.getAttribute("email")%><br><br>

<jsp:useBean id="addresses" class="domain.Address" scope="application" />
<%
	ServletContext ctx = request.getServletContext();
	DummyDb db = (DummyDb)ctx.getAttribute(WebContextNames.listOfAddresses);
	
	for(Address a : db.addresses) {
		if(a.getUser().equals(request.getSession().getAttribute("username")))
		{
			if(a.getType().equals("permanent"))
			{
				out.println("<p>Permanent address:<br>"+a.getVoivodeship()+", "+a.getPostalCode()+" "+a.getCity()+", "
				+a.getStreet()+" "+a.getHouseNumber()
				+"  <a href='addressForm.jsp'>change</a>"
				+"  <a href='Address?user="+a.getUser()+"&typeofaddress="+a.getType()+"'>delete</a></p>");
			}
			else if(a.getType().equals("mailing"))
			{
				out.println("<p>Mailing address:<br>"+a.getVoivodeship()+", "+a.getPostalCode()+" "+a.getCity()+", "
				+a.getStreet()+" "+a.getHouseNumber()
				+"  <a href='addressForm.jsp'>change</a>"
				+"  <a href='Address?user="+a.getUser()+"&typeofaddress="+a.getType()+"'>delete</a></p>");
			}
			else
			{
				out.println("<p>Work address:<br>"+a.getVoivodeship()+", "+a.getPostalCode()+" "+a.getCity()+", "
				+a.getStreet()+" "+a.getHouseNumber()
				+"  <a href='addressForm.jsp'>change</a>"
				+"  <a href='Address?user="+a.getUser()+"&typeofaddress="+a.getType()+"'>delete</a></p>");
			}
		}
	}
	
%>

<p><a href="addressForm.jsp">Add new address</a></p>
<p><br><a href="premium.jsp">Premium page</a></p>
<p><a href="Logout">Log out</a></p>

<jsp:useBean id="users" class="domain.User" scope="application" />
<%
	if(request.getSession().getAttribute("username").equals("admin"))
	{
		out.println("<br><br>Admin panel: ");
		out.println("<p><a href='listOfUsers.jsp'>List of users</a></p>");
		out.println("<p><a href='addDelPrivilegesForm.jsp'>Privilege management</a></p>");
	}
%>

</body>
</html>