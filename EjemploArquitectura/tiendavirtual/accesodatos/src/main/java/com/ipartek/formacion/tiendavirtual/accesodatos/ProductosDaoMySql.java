package com.ipartek.formacion.tiendavirtual.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public class ProductosDaoMySql implements Dao<Long, Producto> {

	private static final String PRODUCTOS_GET_ALL = "{ call productos_getAll() }";

	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/tiendavirtual?serverTimezone=UTC";
		String user = "root";
		String password = "";
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al conectar a la base de datos", e);
		}
	}
	
	@Override
	public Iterable<Producto> getAll() {
		try(Connection con = getConnection()) {
			try(CallableStatement cs = con.prepareCall(PRODUCTOS_GET_ALL)) {
				ResultSet rs = cs.executeQuery();
				
				ArrayList<Producto> productos = new ArrayList<>();
				
				Producto producto;
				
				while(rs.next()) {
					producto = new Producto(
							rs.getLong("id"), 
							rs.getString("nombre"), 
							rs.getString("descripcion"),
							rs.getBigDecimal("precio"));
					
					productos.add(producto);
				}
				
				return productos;
				
			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + PRODUCTOS_GET_ALL);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
	}

	@Override
	public Producto getById(Long id) {
		throw new UnsupportedOperationException("Método no implementado");
	}

	@Override
	public Producto insert(Producto objeto) {
		throw new UnsupportedOperationException("Método no implementado");
	}

	@Override
	public Producto update(Producto objeto) {
		throw new UnsupportedOperationException("Método no implementado");
	}

	@Override
	public Producto delete(Producto objeto) {
		throw new UnsupportedOperationException("Método no implementado");
	}

	@Override
	public Producto deleteById(Long id) {
		throw new UnsupportedOperationException("Método no implementado");
	}

}
