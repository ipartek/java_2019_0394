package com.ipartek.formacion.ejemplotransaccionesjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class App 
{
	static {
		System.setProperty("java.util.logging.config.file",
				App.class.getClassLoader().getResource("logging.properties").getFile().replace("%20", " "));
	}
	
	private final static Logger LOGGER = Logger.getLogger("com.ipartek.formacion.ejemplotransaccionesjdbc");
	
    public static void main( String[] args ) throws SQLException
    {
        String URL = "jdbc:mysql://root:@localhost:3306/banco?serverTimezone=UTC";
        String sql1 = "INSERT INTO movimientos (cuentas_id, concepto, cantidad, divisa) VALUES (1, 'Transacción a 2', -200.5, 'EUR')";
        String sql2 = "INSERT INTO movimientos (cuentas_id, concepto, cantidad, divisa) VALUES (6, 'Transacción desde 1', 200.5, 'EUR')";
        
        LOGGER.info("Inicio de la aplicación");
        
        try (Connection con = DriverManager.getConnection(URL)) {
        	
        	con.setAutoCommit(false);
        	
        	try(Statement stmt = con.createStatement()) {
        		LOGGER.fine(sql1);
        		stmt.executeUpdate(sql1);
        		
        		LOGGER.fine(sql2);
        		stmt.executeUpdate(sql2);
        		
        		con.commit();
        		
        		LOGGER.info("Se ha finalizado la transacción");
        		
        	} catch(Exception e) {
        		LOGGER.severe("Error en la operación");
        		
        		con.rollback();
        		
        	}
        }
    }
}
