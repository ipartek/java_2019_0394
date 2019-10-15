<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movimientos</title>
</head>
<body>
	<!-- 1234-5678-12345678 | Ingreso inicial | Importe(cantidad=123.45, divisa=EUR) -->
	<table>
		<thead>
			<tr>
				<th>Número de cuenta</th>
				<th>Concepto</th>
				<th>Importe</th>
				<th>Divisa</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movimientos}" var="movimiento">
				<tr>
					<td>${movimiento.cuenta}</td>
					<td>${movimiento.concepto}</td>
					<td>${movimiento.importe.cantidad}</td>
					<td>${movimiento.importe.divisa}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>