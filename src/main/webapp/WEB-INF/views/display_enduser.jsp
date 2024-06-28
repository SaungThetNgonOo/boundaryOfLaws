<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/css/bootstrap.min.css"/>'/>
<body>

	<h3>All EndUsers</h3>
	<div class="container">
		<a href="/boundaryOfLaws/addenduser">Create Enduser </a>
		<div class="row">
			<div class="col">Id</div>
			<div class="col">UserName</div>
			<div class="col">Current_state</div>
			<div class="col">Gender</div>
			<div class="col">status</div>
			<div class="col"></div>
		</div>
		<c:forEach var="enduser" items="${endusers}">
			<div class="row">
				<div class="col">${enduser.id}</div>
				<div class="col">${enduser.name}</div>
				<div class="col">${enduser.current_state}</div>
				<div class="col">${enduser.gender}</div>
				<div class="col">${enduser.status}</div>
				<div class="col">
				<a href="edituser">Edit</a>
				<a href="delete">Delete</a>
				</div>
				
			</div>
		</c:forEach>
	</div>
</body>
</html>