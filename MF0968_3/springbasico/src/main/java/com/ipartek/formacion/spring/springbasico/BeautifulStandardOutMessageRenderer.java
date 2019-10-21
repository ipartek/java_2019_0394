package com.ipartek.formacion.spring.springbasico;

public class BeautifulStandardOutMessageRenderer extends StandardOutMessageRenderer {

	@Override
	public void render() {
		if (getMessageProvider() == null) {
			throw new RuntimeException(
					"You must set the property messageProvider of class:" + StandardOutMessageRenderer.class.getName());
		}
		
		String mensaje = getMessageProvider().getMessage();
		int longitud = mensaje.length();
		
		String separador = new String(new char[longitud]).replace("\0", "-");
		
		System.out.println(separador);
		System.out.println(mensaje);
		System.out.println(separador);
	}

	
}
