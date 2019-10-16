<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transferencias</title>
</head>
<body>

<form action="transferencias" method="post">
	<input type="number" name="cuentaOrigen" placeholder="cuentaOrigen" value="${form.cuentaOrigen}" />
	<span class="error">${form.errorCuentaOrigen}</span>
	<br />
	<input type="number" name="cuentaDestino" placeholder="cuentaDestino" value="${form.cuentaDestino}"  />
	<span class="error">${form.errorCuentaDestino}</span>
	<br />
	<input type="text" name="conceptoOrigen" placeholder="conceptoOrigen" value="${form.conceptoOrigen}"  />
	<span class="error">${form.errorConceptoOrigen}</span>
	<br />
	<input type="text" name="conceptoDestino" placeholder="conceptoDestino" value="${form.conceptoDestino}"  />
	<span class="error">${form.errorConceptoDestino}</span>
	<br />
	<input type="number" name="importe" placeholder="importe" value="${form.importe}"  />
	<span class="error">${form.errorImporte}</span>
	<br />
	<input type="text" name="divisa" placeholder="divisa" value="${form.divisa}"  />
	<span class="error">${form.errorDivisa}</span>
	<br />
	<button>Transferir</button>
	<span class="error">${form.errorGeneral}</span>
	
</form>

</body>
</html>