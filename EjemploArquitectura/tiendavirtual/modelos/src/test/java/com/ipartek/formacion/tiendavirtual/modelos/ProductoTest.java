package com.ipartek.formacion.tiendavirtual.modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductoTest {
	private Producto producto;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Antes de TODOS los test de esta clase
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//Después de TODOS los test de esta clase
	}

	@Before
	public void setUp() throws Exception {
		//Antes de cada test
		producto = new Producto();
	}

	@After
	public void tearDown() throws Exception {
		//Después de cada test
	}
	
	@Test
	public void setNombreNull() {
		thrown.expect(ModeloException.class);
        thrown.expectMessage("No se admiten nombres nulos");
		producto.setNombre(null);
	}
	
	@Test
	public void setNombreVacio() {
		producto.setNombre("    ");
		assertEquals("No se permiten nombres vacíos", producto.getErrorNombre());
		assertEquals("is-invalid", producto.getValidezNombre());
		assertTrue(producto.isError());
	}
	
	@Test
	public void setNombreCorrecto() {
		producto.setNombre("Nombre del producto");
		assertEquals("", producto.getErrorNombre());
		assertEquals("is-valid", producto.getValidezNombre());
		assertFalse(producto.isError());
	}
	
	@Test
	public void setDescripcionCorrecta() {
		producto.setDescripcion("Descripción correcta");
		assertEquals("", producto.getErrorDescripcion());
		assertEquals("is-valid", producto.getValidezDescripcion());
		assertFalse(producto.isError());
	}
	
	@Test
	public void valoresIniciales() {
		assertFalse(producto.isError());
		
		assertEquals("", producto.getErrorNombre());
		assertEquals("", producto.getErrorDescripcion());
		assertEquals("", producto.getErrorPrecio());
		
		
		assertEquals("", producto.getValidezNombre());
		assertEquals("", producto.getValidezDescripcion());
		assertEquals("", producto.getValidezPrecio());
	}
	
	@Test
	public void setPrecioNull() {
		thrown.expect(ModeloException.class);
        thrown.expectMessage("No se admite un precio nulo");
		
        producto.setPrecio((BigDecimal)null);
		producto.setPrecio((String)null);
	}
	
	@Test
	public void setPrecioVacio() {
		producto.setPrecio("    ");
		assertEquals("El precio se debe rellenar", producto.getErrorPrecio());
		assertEquals("is-invalid", producto.getValidezPrecio());
		assertTrue(producto.isError());
	}
	
	@Test
	public void setPrecioNegativo() {
		producto.setPrecio(new BigDecimal("-123"));
		assertTrue(producto.isError());
		assertEquals("is-invalid", producto.getValidezPrecio());
		assertEquals("El precio debe ser 0 o positivo", producto.getErrorPrecio());
	}
	
	@Test
	public void setPrecioCorrecto() {
		producto.setPrecio(new BigDecimal("123.22"));
		assertFalse(producto.isError());
		assertEquals("is-valid", producto.getValidezPrecio());
		assertEquals("", producto.getErrorPrecio());
	}
}