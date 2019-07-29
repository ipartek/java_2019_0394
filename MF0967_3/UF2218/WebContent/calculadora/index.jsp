<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculadora</title>
</head>
<body>
	<form action="#">
		<input type="number" name="op1" /> 
		<select name="op">
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select> 
		<input type="number" name="op2" />
		<button>=</button>
		<input disabled="disabled" value="${resultado}" />
	</form>
</body>
</html>
