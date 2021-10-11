<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Contacts</title>
</head>
<body>

<form method = "post" action = "contactNavigationServlet">
<table>
	<c:forEach items="${requestScope.allContacts}" var="currentcontact">
		<tr>
 	 <td><input type="radio" name="id" value="${currentcontact.id}"></td>
 	 <td> Name: 	     ${currentcontact.name}</td>
	 <td> Date of Birth: ${currentcontact.dob}</td>
	 <td> Address: 		 ${currentcontact.address}</td>
 	 <td> Phone#:  		 ${currentcontact.phoneNumber}</td>
 	 <td> Date Created:  ${currentcontact.contactCreated}</td>
  </tr>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToContact">
<input type = "submit" value = "delete" name="doThisToContact">
<input type="submit" value = "add" name = "doThisToContact">
</form>
</body>
</html>