package com.ipartek.formacion.banco.servicios;

public class ServiciosBancariosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiciosBancariosException() {
		
	}

	public ServiciosBancariosException(String arg0) {
		super(arg0);
		
	}

	public ServiciosBancariosException(Throwable arg0) {
		super(arg0);
		
	}

	public ServiciosBancariosException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ServiciosBancariosException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
