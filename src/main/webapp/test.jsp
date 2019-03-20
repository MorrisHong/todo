<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="name" scope="request" value="홍은모"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
	이름 : ${requestScope.name }</br>
	<c:remove var="name"/>
	이름 : ${requestScope.name }</br>	
	</body>
</html>
