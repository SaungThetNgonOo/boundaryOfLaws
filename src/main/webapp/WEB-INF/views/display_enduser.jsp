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
<link rel="stylesheet" href="resources/css/style.css"/>

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
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">UserNames</th>
      <th scope="col">Current_State</th>
      <th scope="col">Gender</th>
      <th scope="col">Status</th>
      <th scope="col"></th>
      
    </tr>
  </thead>
		<c:forEach var="enduser" items="${endusers}">
			 <tbody>
    <tr>
      <th scope="row">${enduser.id}</th>
      <td>${enduser.name}</td>
      <td>${enduser.current_state}</td>
      <td>${enduser.gender}</td>
      <td>${enduser.status}</td>
      <td><a href="/boundaryOfLaws/deleteenduser/${enduser.id}">Delete</a>
      </td>
      
    </tr>
    </tbody>
		</c:forEach>
		</table>
	</div>
			</div>
		</div>
	</div>
	</div>

	
</body>
</html>