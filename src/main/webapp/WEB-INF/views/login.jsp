<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/login.css" />'>
</head>
<body>
	<div class="container">
            <form:form class="login w-50 h-50 p-5 d-flex flex-column w-50 bg-info rounded-2" action="/boundaryOfLaws/systemusers" method="post" modelAttribute="systemusers">
                <div class="m-2 form-group pt-5 d-flex justify-content-center">
                  <form:label path="email" class="w-25">Email:</form:label>
                  <form:input path="email" type="text" class=""  ></form:input>
                </div>
                <div class="m-2 form-group pb-5 d-flex justify-content-center">
                  <form:label path="password" class="w-25">Password:</form:label>
                  <form:input path="password" type="password" class="" ></form:input>
                </div>
                <button type="submit" class="pb-2 m-auto btn btn-success">Login</button>
              </form:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>