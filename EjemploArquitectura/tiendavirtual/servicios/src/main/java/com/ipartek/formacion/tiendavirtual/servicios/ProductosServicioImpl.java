package com.ipartek.formacion.tiendavirtual.servicios;

import com.ipartek.formacion.tiendavirtual.accesodatos.AccesoDatosException;
import com.ipartek.formacion.tiendavirtual.accesodatos.Dao;
import com.ipartek.formacion.tiendavirtual.accesodatos.ProductosDaoMySql;
import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public class ProductosServicioImpl implements ProductoServicio {

	private static ProductosServicioImpl instancia = new ProductosServicioImpl();
	
	public static ProductosServicioImpl getInstancia() {
		return instancia;
	}
	
	private ProductosServicioImpl() {
	}
	
	@Override
	public Iterable<Producto> getAll() {
		try {
			Dao<Long, Producto> dao = new ProductosDaoMySql();
			
			return dao.getAll();
		} catch (AccesoDatosException e) {
			throw new ServiciosException("Ha habido un error al pedir el listado", e);
		}
	}

	@Override
	public Producto getById(Long id) {
		throw new UnsupportedOperationException("Método no implementado");
	}

	@Override
	public Producto insert(Producto producto) {
		throw new UnsupportedOperationException("Método no implementado");
	}

	@Override
	public Producto update(Producto producto) {
		throw new UnsupportedOperationException("Método no implementado");
	}

	@Override
	public Producto delete(Producto producto) {
		throw new UnsupportedOperationException("Método no implementado");
	}

}
