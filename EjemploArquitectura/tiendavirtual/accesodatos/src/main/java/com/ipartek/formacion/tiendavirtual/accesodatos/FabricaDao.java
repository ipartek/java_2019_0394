package com.ipartek.formacion.tiendavirtual.accesodatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ipartek.formacion.tiendavirtual.modelos.Producto;

public class FabricaDao {
	private String motor, url, user, password, driver;

	private static FabricaDao instancia = null;

	public static FabricaDao crearInstancia(String configuracion) {
		return instancia = new FabricaDao(configuracion);
	}
	
	public static FabricaDao getInstancia() {
		if (instancia == null) {
			throw new AccesoDatosException(
					"Se debe utilizar crearInstancia para crear una nueva instancia con su configuración");
		}
		return instancia;
	}

	private FabricaDao() {
	}

	private FabricaDao(String configuracion) {
		try (InputStream inputStream = new FileInputStream(configuracion)) {

			Properties prop = new Properties();
			// load a properties file
			prop.load(inputStream);

			// get value by key
			motor = prop.getProperty("dao.motor");
			url = prop.getProperty(motor + ".url");
			user = prop.getProperty(motor + ".user");
			password = prop.getProperty(motor + ".password");
			driver = prop.getProperty(motor + ".driver");
		} catch (FileNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el fichero de configuración", e);
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración", e);
		}
	}

	public Dao<Long, Producto> getDaoProducto() {
		switch (motor) {
		case "mysql":
			return ProductosDaoMySql.crearInstancia(driver, url, user, password);
		// case "oracle": return ProductosDaoOracle.crearInstancia(....);
		default:
			throw new AccesoDatosException("No dispongo del motor " + motor);
		}
	}

}
