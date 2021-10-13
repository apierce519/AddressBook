<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
</head>
<body>
<h1>Edit a Contact</h1>
<form action = "editContactServlet" method="post">
	Name : <input type ="text" name = "name" value= "${contactToEdit.name}">
	Phone Number: <input type = "text" name = "phone#" value= "${contactToEdit.phoneNumber}">
	Address: <input type = "text" name = "address" value= "${contactToEdit.address}">
	Date of Birth: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> <input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
	<input type = "hidden" name = "id" value="${contactToEdit.id}">
	<input type = "submit" value="Save Edited Contact">
</form>
</body>
</html>