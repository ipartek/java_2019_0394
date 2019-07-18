package com.ipartek.formacion.uf2218.modelos;

public class ModeloException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ModeloException() {
	}

	public ModeloException(String message) {
		super(message);
	}

	public ModeloException(Throwable cause) {
		super(cause);
	}

	public ModeloException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModeloException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
