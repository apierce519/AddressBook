<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
<h1>Add a Contact</h1>
	<form action = "addContactServlet" method="post">
	Name: <input type ="text" name = "name">
	Phone Number: <input type = "text" name = "phone#">
	Address: <input type = "text" name = "address">
	Date of Birth: <input type="text" name = "month" placeholder="mm" size="4">
	<input type="text" name = "day" placeholder="dd" size="4">
	<input type="text" name = "year" placeholder="yyyy" size="4">
	<input type = "submit" value="Add Contact">
	<a href = "viewAllContactsServlet">View all of the Contacts</a> <br />
</form> <br />
</body>
</html>