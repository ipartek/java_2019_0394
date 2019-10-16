package com.ipartek.formacion.ejemplotransaccionesjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
        String URL = "jdbc:mysql://root:@localhost:3306/banco?serverTimezone=UTC";
        String sql1 = "INSERT INTO movimientos (cuentas_id, concepto, cantidad, divisa) VALUES (1, 'Transacción a 2', -200.5, 'EUR')";
        String sql2 = "INSERT INTO movimientos (cuentas_id, concepto, cantidad, divisa) VALUES (2, 'Transacción desde 1', 200.5, 'EUR')";
        
        try (Connection con = DriverManager.getConnection(URL)) {
        	
        	con.setAutoCommit(false);
        	
        	try(Statement stmt = con.createStatement()) {
        		stmt.executeUpdate(sql1);
        		stmt.executeUpdate(sql2);
        		
        		System.out.println("Finalizado");
        		
        		con.commit();
        		
        	} catch(Exception e) {
        		System.out.println("Error en la operación");
        		
        		con.rollback();
        		
        	}
        }
    }
}
