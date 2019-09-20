package com.ipartek.formacion.tiendavirtual.modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductoTest {
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void setNombreNull() {
		Producto producto = new Producto();
		thrown.expect(ModeloException.class);
        thrown.expectMessage("No se admiten nombres nulos");
		producto.setNombre(null);
	}
	
	@Test
	public void setNombreVacio() {
		Producto producto = new Producto();
		producto.setNombre("    ");
		assertEquals("No se permiten nombres vacíos", producto.getErrorNombre());
		assertTrue(producto.isError());
	}
}