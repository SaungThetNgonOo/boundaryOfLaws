<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<body class="Register">
	<div class="register_form">
		<div class="form">
		<form:form class="userregistration_form" style="background-color:smoke-white;margin:350px" action="/boundaryOfLaws/addenduser" method="post" modelAttribute="enduser">
				<h2>EndUserRegistration</h2>
			<div class="mb-4">
					<input type="hidden" class="form-control" name="id" placeholder="ID"
						path="id"></input>
				</div>

				<div class="mb-3">
					<lable for="username" class="form-lable">Username</lable>
					<input type="text" class="form-control" name="name"
						placeholder="Username" path="name" />

				</div>


				<div class="mb-3">
					<lable for="email" class="form-lable">Email</lable>
					<input type="email" class="form-control" name="email"
						placeholder="Email" path="email" />
				</div>


				<div class="mb-3">
					<lable for="password" class="form-lable">Password </lable>

					<input type="password" class="form-control" name="password"
						placeholder="Password" path="password" />
				</div>


				<div class="mb-3">
					<lable for="phone" class="form-lable"> Phone</lable>
					<input type="text" class="form-control" name="phone"
						placeholder="+95" path="phone" value="+95" />

				</div>


				<div class="mb-3">
					<lable for="NRC" class="form-lable">NRC</lable>

					<input type="text" class="form-control" name="NRC"
						placeholder="NRC" path="NRC" />

				</div>



				<div class="mb-3">
					<lable for="current_state" class="form-lable" path="current_state">Current_State</lable>
					<select name="current_state" required>
						<option value="" disabled selected>Select your state</option>
						<option value="ygn">Yangon</option>
						<option value="mdy">Mandalay</option>
						<option value="npt">NaypyiTaw</option>
					</select>


				</div>



				<div class="mb-3">
					<lable for="id" class="form-lable" path="gender">Gender </lable>

					<div class="gender-container">
						<label><input type="radio" name="gender" value="male">
							Male</label> <label><input type="radio" name="gender"
							value="female"> Female</label> <label><input type="radio"
							name="gender" value="other"> Other</label>
					</div>

				</div>

				<div>
					<form:input type="hidden" class="form-control" path='status'></form:input>
				</div>

				<input type="submit" name="register" value="Register"
					class="btn btn-primary">
			</form:form>

		</div>
	</div>

</body>
</html>