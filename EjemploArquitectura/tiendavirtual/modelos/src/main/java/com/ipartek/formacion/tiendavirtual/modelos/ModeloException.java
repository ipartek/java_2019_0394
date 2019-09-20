package com.ipartek.formacion.tiendavirtual.modelos;

public class ModeloException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ModeloException() {
	}

	public ModeloException(String arg0) {
		super(arg0);
	}

	public ModeloException(Throwable arg0) {
		super(arg0);
	}

	public ModeloException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ModeloException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
