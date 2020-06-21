<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<c:redirect url="form"/>
	<!-- 해당 주소는 DispatcherServlet가 받는다. form이라는 요청이 들어간다. 하지만 form이 없으므로 404오류가 뜨는 것이다.-->
</body>
</html>