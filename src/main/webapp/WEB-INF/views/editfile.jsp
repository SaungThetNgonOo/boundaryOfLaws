
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit PDF File</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" />
<link rel="stylesheet" href="resources/css/style.css" />

</head>
<body>
	<div>
		<jsp:include page="Nav.jsp"></jsp:include>
		<div class="container-fluid">
			<div class="row">
				<jsp:include page="Sidebar.jsp"></jsp:include>
				<c:if test="${not empty message}">
					<div class="alert alert-info">${message}</div>
				</c:if>

				<div class="col">
					<h2>Edit PDF File</h2>
					<c:if test="${not empty pdfFile}">
						<form method="post"
							action="${pageContext.request.contextPath}/update/${pdfFile.id}"
							enctype="multipart/form-data">
							<label for="name">Current File Name:</label> <span>${pdfFile.name}</span>
							<br /> <label for="file">Select New PDF File (optional):</label>
							<input type="file" id="file" name="file" accept="application/pdf" />
							<br /> <input type="submit" value="Update File" />
						</form>
					</c:if>
					<c:if test="${empty pdfFile}">
						<p style="color: red;">File not found or error loading file
							details.</p>
					</c:if>
					<c:if test="${not empty message}">
						<p style="color: green;">${message}</p>
					</c:if>
					<c:if test="${not empty errorMessage}">
						<p style="color: red;">${errorMessage}</p>
					</c:if>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
