package com.ipartek.formacion.tiendavirtual.servicios;

import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public interface ProductoServicio {
	Iterable<Producto> getAll();
	Producto getById(Long id);
	
	Producto insert(Producto producto);
	Producto update(Producto producto);
	Producto delete(Producto producto);
}
