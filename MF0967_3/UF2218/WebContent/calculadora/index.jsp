<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculadora</title>
</head>
<body>
	<form action="calcular">
		<input type="number" name="op1" value="${op1}"/> 
		<select name="op">
			<option <c:if test="${op eq '+'.charAt(0)}">selected</c:if>>+</option>
			<option <c:if test="${op eq '-'.charAt(0)}">selected</c:if>>-</option>
			<option <c:if test="${op eq '*'.charAt(0)}">selected</c:if>>*</option>
			<option <c:if test="${op eq '/'.charAt(0)}">selected</c:if>>/</option>
		</select> 
		<input type="number" name="op2" value="${op2}" />
		<button>=</button>
		<input disabled="disabled" value="${res}" />
	</form>
</body>
</html>
