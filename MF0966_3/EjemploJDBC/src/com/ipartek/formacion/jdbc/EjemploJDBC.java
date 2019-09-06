package com.ipartek.formacion.jdbc;

import java.sql.*;

public class EjemploJDBC {

	public static void main(String[] args) {
		// Connection con = null;
		// Statement s = null;
		// ResultSet rs = null;

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			// new com.mysql.cj.jdbc.Driver();

			String usuario = "root";
			String password = "";
			String uri = "jdbc:mysql://localhost/libreria?serverTimezone=UTC";

			try (Connection con = DriverManager.getConnection(uri, usuario, password)) {

				System.out.println("Conectado");

				try (Statement s = con.createStatement()) {

					String sql = "SELECT titulo, autor FROM libros";
					// String sql = "SELECT * FROM libros";

					try (ResultSet rs = s.executeQuery(sql)) {

//		ResultSetMetaData rsmd = rs.getMetaData();
//		
//		for(int i = 1; i <= rsmd.getColumnCount(); i++) {
//			System.out.print(rsmd.getColumnName(i) + "\t");
//		}

//		System.out.println();

						while (rs.next()) {
							System.out.println(rs.getString("titulo") + ", " + rs.getString("autor"));
//			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
//				System.out.print(rs.getString(i) + "\t");
//			}

//			System.out.println();
						}
					}
				}

				int id = 1;

				String sql = "SELECT * FROM libros WHERE id=?";

				try (PreparedStatement ps = con.prepareStatement(sql)) {

					ps.setInt(1, id);

					try (ResultSet rs = ps.executeQuery()) {
						while (rs.next()) {
							System.out.println(rs.getString("autor"));
						}
					}
				}

				String descripcion = "Modificada";
				id = 1;
				
				sql = "UPDATE libros SET descripcion=? WHERE id=?";
				
				try (PreparedStatement ps = con.prepareStatement(sql)) {

					ps.setString(1, descripcion);
					ps.setInt(2, id);
					
					ps.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		finally {
//			if(rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(s != null) {
//				try {
//					s.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
	}
}
