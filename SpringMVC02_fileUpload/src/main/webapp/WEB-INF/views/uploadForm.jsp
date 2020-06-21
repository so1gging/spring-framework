<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 선택</h2>
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>업로드 할 파일 선택</h3>
		파일:<input type="file" name="file" /> 
		<p style="color:red; font-weight:bold;">
			<form:errors path="file" />
		</p>
		<br>
		설명:<br>
		<textarea rows="10" cols="40" name="desc"></textarea>
		<br>
		<input type="submit" value="전송">
	</form:form>
	
</body>
</html>