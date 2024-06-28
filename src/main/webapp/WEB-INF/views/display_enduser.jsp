<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link rel="stylesheet" href="resources/css/style.css" />
<body>
<div >
		<jsp:include page="Nav.jsp"></jsp:include>
		<div class="container-fluid">
	
		<div class="row">
		<jsp:include page="Sidebar.jsp"></jsp:include>
			<div class="col">
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
			</div>
		</div>
	</div>
	</div>

	
</body>
</html>