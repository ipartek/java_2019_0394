<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vista JSP</title>
</head>
<body>
	<h1>Vista JSP en Spring MVC</h1>

	<ul>
		<c:forEach items="${datos}" var="dato">
			<li>${dato}</li>
		</c:forEach>
	</ul>
	<h2>${datos}</h2>

</body>
</html>