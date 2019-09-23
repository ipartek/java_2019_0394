package com.ipartek.formacion.tiendavirtual.accesodatos;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public class ProductosDaoMySqlTest {

	@Test
	public void getAll() {
		String rutaConfiguracion = ProductosDaoMySqlTest.class.getClassLoader().getResource("configuracionTest.properties").toString().replace("%20", " ").replace("file:", "");
		Dao<Long, Producto> dao = FabricaDao.crearInstancia(rutaConfiguracion).getDaoProducto();
		
		ArrayList<Producto> productos = (ArrayList<Producto>) dao.getAll();
		
		assertEquals(2, productos.size());
		
		assertEquals(
				new Producto(1L, "Pantalla", "Pantalla de super resolución que mola un mónton", 
						new BigDecimal("123.12")), productos.get(0));
		assertEquals(
				new Producto(2L, "Ratón", "Ratón que te ...", 
						new BigDecimal("23.12")), productos.get(1));
		
	}

}
