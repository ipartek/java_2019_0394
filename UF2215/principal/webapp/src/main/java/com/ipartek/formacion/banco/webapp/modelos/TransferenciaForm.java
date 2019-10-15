package com.ipartek.formacion.banco.webapp.modelos;

import lombok.Data;

public @Data class TransferenciaForm {
	private String cuentaOrigen, cuentaDestino, conceptoOrigen, conceptoDestino, importe, divisa;
	
	private boolean correcto = true;
	
	private String errorGeneral;
	private String errorCuentaOrigen, errorCuentaDestino, errorConceptoOrigen, errorConceptoDestino, errorImporte, errorDivisa;
	
	public void setCuentaOrigen(String cuentaOrigen) {
		if(cuentaOrigen == null) {
			throw new ModeloException("TransferenciaForm no admite ese valor nulo");
		}
		
		if(!cuentaOrigen.matches("\\d+")) {
			setErrorCuentaOrigen("Sólo se admiten números positivos");
		}
		
		this.cuentaOrigen = cuentaOrigen;
	}
	
	public void setErrorCuentaOrigen(String texto) {
		errorCuentaOrigen = texto;
		setCorrecto(false);
	}
}
