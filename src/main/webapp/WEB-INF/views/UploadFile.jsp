<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload PDF File</title>
</head>
<body>
    <h1>Upload PDF File</h1>
    <form method="post" action="upload" enctype="multipart/form-data">
        <input type="file" name="pdfFile" />
        <br/>
        <input type="submit" value="Upload" />
    </form>
</body>
</html>
