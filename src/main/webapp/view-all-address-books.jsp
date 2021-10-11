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
		
			<c:forEach items = "${requestScope.allAddressBooks}" var = "currentaddressbook">
			
				<tr>
				
					<td><input type = "radio" name = "id" value = "${currentaddressbook.id}"></td>
					<td><h2>${currentaddressbook.listName}</h2></td>
				
				</tr>
				<tr>

					<td colspan = "3">Number of Contacts: ${currentAddressBook.contactCount}  </td>
					<td colspan = "3">Creation Date: ${currentAddressBook.creationDate} </td>
									
				</tr>
				<c:forEach var = "contactVal" items = "${currentAddressBook.contactList}">
					<tr>
						<td></td>
						<td colspan = "3">${contactVal.name},${contactVal.dob},${contactVal.address},${phoneNumber},${contactCreated}</td>
					</tr>
				</c:forEach>
			</c:forEach>
		
		</table>
		
		<input type = "submit" value = "edit" name = "command">
		<input type = "submit" value = "delete" name = "command">
		<input type = "submit" value = "add" name = "command">
	</form>
	
	<a href = "generateContactListForAddressBook">Create a new Address Book</a>
	<a href = "main-menu">Return to main menu</a>
	
</body>
</html>