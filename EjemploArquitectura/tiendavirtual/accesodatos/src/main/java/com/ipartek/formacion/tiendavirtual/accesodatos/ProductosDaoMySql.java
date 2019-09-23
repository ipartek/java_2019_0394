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
	private static final String PRODUCTOS_INSERT = "{ call productos_insert(?,?,?,?) }";
	
	public String url, user, password, driver;
	
	private static ProductosDaoMySql instancia;
	
	public static ProductosDaoMySql crearInstancia(String driver, String url, String user, String password) {
		return instancia = new ProductosDaoMySql(driver, url, user, password);
	}
	
	public static ProductosDaoMySql getInstancia() {
		if(instancia == null) {
			throw new AccesoDatosException("Se debe crear la instancia con crearInstancia y los datos de configuración");
		}
		return instancia;
	}
	
	private ProductosDaoMySql(String driver, String url, String user, String password) {
		
		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;
	}

	private Connection getConnection() {
		
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al conectar a la base de datos", e);
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de JDBC de MySQL", e);
		}
	}

	@Override
	public Iterable<Producto> getAll() {
		try (Connection con = getConnection()) {
			try (CallableStatement cs = con.prepareCall(PRODUCTOS_GET_ALL)) {
				ResultSet rs = cs.executeQuery();

				ArrayList<Producto> productos = new ArrayList<>();

				Producto producto;

				while (rs.next()) {
					producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getString("descripcion"),
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
	public Producto insert(Producto producto) {
		try (Connection con = getConnection()) {
			try (CallableStatement cs = con.prepareCall(PRODUCTOS_INSERT)) {
				cs.setString(1, producto.getNombre());
				cs.setString(2, producto.getDescripcion());
				cs.setBigDecimal(3, producto.getPrecio());
				
				cs.registerOutParameter(4, java.sql.Types.INTEGER);
				
				cs.executeUpdate();
				
				producto.setId(cs.getLong(4));
				
				return producto;

			} catch (SQLException e) {
				throw new AccesoDatosException("No se ha podido llamar al procedimiento " + PRODUCTOS_GET_ALL);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al cerrar la conexión a la base de datos", e);
		}
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
