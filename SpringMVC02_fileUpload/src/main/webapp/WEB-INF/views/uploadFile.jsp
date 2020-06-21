<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	파일명: ${fileobj.filename }<br>
	설명 : ${fileobj.desc } <br>
	<form action="download" method="post" >
		<input type="hidden" name="filename" value="${fileobj.filename }" />
		<input type="submit" value="DOWNLOAD" />
	</form>
</body>
</html>