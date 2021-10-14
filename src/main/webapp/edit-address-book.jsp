<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Address Book</title>
</head>
<body>
<h1>Edit Selected Address Book</h1>
	<form action = "editAddressBookServlet" method = "post">
	
		<input type = "hidden" name = "id" value = "${addressBookToEdit.id}">
		Address Book Name: <input type = "text" name = "listName" value = "${addressBookToEdit.listName}"><br>
		 
		All Contacts:<br>
			
			<select name = "allContacts" multiple size = "6">
				 <c:forEach items = "${requestScope.allContacts}" var = "currentContact">
				 	<option value = "${currentContact.id }">${currentContact.name} | ${currentContact.dob} | ${currentContact.address} | ${currentContact.phoneNumber} | ${currentContact.contactCreated}</option>
				 </c:forEach>
			</select>
			<br>
			<input type = "submit" value = "Edit List and Add Contacts">
			
	</form>
	<br>
	<a href = "main-menu.html">Add new Contacts.</a>

</body>
</html>