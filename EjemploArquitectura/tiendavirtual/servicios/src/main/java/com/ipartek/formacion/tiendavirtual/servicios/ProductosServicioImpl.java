package com.ipartek.formacion.tiendavirtual.servicios;

import com.ipartek.formacion.tiendavirtual.accesodatos.AccesoDatosException;
import com.ipartek.formacion.tiendavirtual.accesodatos.Dao;
import com.ipartek.formacion.tiendavirtual.accesodatos.FabricaDao;
import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public class ProductosServicioImpl implements ProductoServicio {

	private String configuracion;
	private FabricaDao fabrica;
	private Dao<Long, Producto> dao;
	
	public String getConfiguracion() {
		return configuracion;
	}

	private static ProductosServicioImpl instancia = null;
	
	public static ProductosServicioImpl getInstancia() {
		if(instancia == null) {
			throw new AccesoDatosException("Debes crear una instancia con la configuración con el método crearInstancia");
		}
		return instancia;
	}
	
	public static ProductosServicioImpl crearInstancia(String configuracion) {
		return instancia = new ProductosServicioImpl(configuracion);
	}
	
	private ProductosServicioImpl(String configuracion) {
		try {
			this.configuracion = configuracion;
			this.fabrica = FabricaDao.crearInstancia(configuracion);
			this.dao = fabrica.getDaoProducto();
		} catch (AccesoDatosException e) {
			throw new ServiciosException("Error al crear el dao", e);
		}
	}
	
	@Override
	public Iterable<Producto> getAll() {
		try {
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
		return dao.insert(producto);
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
