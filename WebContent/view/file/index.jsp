<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/FileUpServlet" method="post" enctype="multipart/form-data">
	文件名<input type="file" name = "file"><br>
	<input type="submit" value="提交">
</form>
</body>
</html>