package com.ipartek.formacion.tiendavirtual.servicios;

public class ServiciosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiciosException() {
	}

	public ServiciosException(String message) {
		super(message);
	}

	public ServiciosException(Throwable cause) {
		super(cause);
	}

	public ServiciosException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiciosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
