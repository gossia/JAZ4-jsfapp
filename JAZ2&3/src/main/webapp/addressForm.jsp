<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Please enter your address:</h3>
<form action="Address" method="get">
	<table>
 	<tr><td>Select type of address:</td>
 	<td><select name="typeofaddress">
 		<option value="default"></option>
		<option value="permanent">Permanent</option>
		<option value="mailing">Mailing</option>
		<option value="work">Work</option>
	</select>
	</td></tr>
 	<tr><td>Choose voivodeship:</td>
 	<td><select name="voivodeship">
 		<option value="default"></option>
		<option value="dolnoslaskie">dolnośląskie</option>
		<option value="kujawsko-pomorskie">kujawsko-pomorskie</option>
		<option value="lubelskie">lubelskie</option>
		<option value="lubuskie">lubuskie</option>
		<option value="lodzkie">łódzkie</option>
		<option value="malopolskie">małopolskie</option>
		<option value="mazowieckie">mazowieckie</option>
		<option value="opolskie">opolskie</option>
		<option value="podkarpackie">podkarpackie</option>
		<option value="podlaskie">podlaskie</option>
		<option value="pomorskie">pomorskie</option>
		<option value="slaskie">śląskie</option>
		<option value="swietokrzyskie">świętokrzyskie</option>
		<option value="warminsko-mazurskie">warmińsko-mazurskie</option>
		<option value="wielkopolskie">wielkopolskie</option>
		<option value="zachodniopomorskie">zachodniopomorskie</option>
	</select>
	</td></tr>
	<tr><td>City:</td><td><input type="text" name="city"></td></tr>
	<tr><td>Postal code:</td><td><input type="text" name="postalcode"></td></tr>
	<tr><td>Street:</td><td><input type="text" name="street"></td></tr>
	<tr><td>House number:</td><td><input type="text" name="housenumber"></td></tr>
 	</table><br>
 	<input type="hidden" name="user" value=<%=session.getAttribute("username")%>>
 	<input type="submit" value="Submit">	
</form>
</body>
</html>