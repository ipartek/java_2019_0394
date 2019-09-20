package com.ipartek.formacion.tiendavirtual.servicios;

import com.ipartek.formacion.tiendavirtual.accesodatos.Dao;
import com.ipartek.formacion.tiendavirtual.accesodatos.ProductosDaoMySql;
import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public class ProductosServicioImpl implements ProductoServicio {

	@Override
	public Iterable<Producto> getAll() {
		Dao<Long, Producto> dao = new ProductosDaoMySql();
		
		return dao.getAll();
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
