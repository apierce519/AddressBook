<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Address Books</title>
</head>
<body>

	<form method = "post" action = "addressBookNavigationServlet">
	
		<table>
		
			<c:forEach items = "${requestScope.allAddressBooks}" var = "currentab">
			
				<tr>
				
					<td><input type = "radio" name = "id" value = "${currentab.id}"></td>
					<td><h2>${currentab.listName}</h2></td>
				
				</tr>
				<tr>

					<td colspan = "3">Number of Contacts: ${currentab.contactCount}  </td>
					<td colspan = "3">Creation Date: ${currentab.creationDate} </td>
									
				</tr>
				<c:forEach var = "contact" items = "${currentab.contactList}">
					<tr>
						<td></td>
						<td colspan = "3">Name: ${contact.name}, DOB: ${contact.dob},Address: ${contact.address}, Phone #: ${contact.phoneNumber}, Creation Date: ${contact.contactCreated}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		
		</table>
		
		<input type = "submit" value = "edit" name = "command">
		<input type = "submit" value = "delete" name = "command">
		<input type = "submit" value = "add" name = "command">
	</form>
	<br>
	<a href = "generateContactListForAddressBookServlet">Create a new Address Book</a>
	<br>
	<a href = "main-menu.html">Return to main menu</a>
	
</body>
</html>