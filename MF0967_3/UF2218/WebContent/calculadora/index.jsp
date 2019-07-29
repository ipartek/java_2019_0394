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
		<input type="number" name="op1" value="${cal.op1}"/>
		<span class="error">${cal.errorOp1}</span>
		<select name="op">
			<option <c:if test="${cal.op eq '+'.charAt(0)}">selected</c:if>>+</option>
			<option <c:if test="${cal.op eq '-'.charAt(0)}">selected</c:if>>-</option>
			<option <c:if test="${cal.op eq '*'.charAt(0)}">selected</c:if>>*</option>
			<option <c:if test="${cal.op eq '/'.charAt(0)}">selected</c:if>>/</option>
		</select> 
		<span class="error">${cal.errorOp}</span>
		<input type="number" name="op2" value="${cal.op2}" />
		<span class="error">${cal.errorOp2}</span>
		<button>=</button>
		<input disabled="disabled" value="${cal.res}" />
		<span class="error">${cal.errorRes}</span>
	</form>
</body>
</html>
