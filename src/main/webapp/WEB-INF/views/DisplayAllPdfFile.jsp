<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>PDF Files List</title>
<!-- Bootstrap CSS -->
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
				<div class="col">
					<c:if test="${not empty message}">
						<div class="alert alert-info">${message}</div>
					</c:if>

					<div class="container mt-5">
						<h1 class="mb-4">PDF Files List</h1>

						<!-- Upload Form -->
						<form action="/boundaryOfLaws/upload" method="post"
							enctype="multipart/form-data" class="mb-4">
							<div class="form-group">
								<label for="file">Upload PDF File</label> <input type="file"
									class="form-control-file" id="file" name="file" required>
							</div>
							<button type="submit" class="btn btn-primary">Upload</button>
						</form>
						

						<!-- Table for displaying PDF files -->
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID</th>
									<th>File Name</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="pdf" items="${pdfFile}">
									<tr>
										<td>${pdf.id}</td>
										<td>${pdf.name}</td>
										<td><a href="/boundaryOfLaws/download/${pdf.id}"
											class="btn btn-sm btn-info">Download</a>
													<a href="${pdf.content}">Cli</a>
											 <a
											href="/boundaryOfLaws/delete/${pdf.id}"
											class="btn btn-sm btn-danger">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>
