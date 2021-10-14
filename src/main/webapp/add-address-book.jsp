<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Address Book</title>
</head>
<body>
<h1>Add New Address Book</h1>
	
	<form action = "addAddressBookServlet" method = "post">
	
		Address Book name: <input type = "text" name = "abName"><br>
		
		Available Contacts:<br>
		
		<select name = "contactsToAdd" multiple size = "6">
		
			<c:forEach items = "${requestScope.allContacts}" var = "currentContact">
			
				 	<option value = "${currentContact.id }">${currentContact.name} | ${currentContact.dob} | ${currentContact.address} | ${currentContact.phoneNumber} | ${currentContact.contactCreated}</option>
			
			</c:forEach>
		
		</select>
		<br>
		<input type = "submit" value = "Create list and Add Items">
	</form>
	<br>
<a href = "main-menu.html">Return to main menu.</a>


</body>
</html>