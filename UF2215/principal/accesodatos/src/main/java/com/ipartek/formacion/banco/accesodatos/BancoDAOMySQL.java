package com.ipartek.formacion.banco.accesodatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.banco.entidades.Cuenta;
import com.ipartek.formacion.banco.entidades.Importe;
import com.ipartek.formacion.banco.entidades.Movimiento;

public class BancoDAOMySQL implements BancoDAO {
	private final static String URL = "jdbc:mysql://root:@localhost:3306/banco?serverTimezone=UTC";
	private final static String GET_MOVIMIENTOS_BY_CUENTA = "{ call get_movimientos_by_cuenta(?) }";
	private final static String GET_CUENTA_BY_ID = "{ call get_cuenta_by_id(?) }";
	private final static String ADD_MOVIMIENTO = "{ call add_movimiento(?, ?, ?, ?) }";

	public BancoDAOMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL", e);
		}
	}
	
	@Override
	public void addMovimiento(Movimiento movimiento) {
		try(Connection con = DriverManager.getConnection(URL)) {
			try(CallableStatement cs = con.prepareCall(ADD_MOVIMIENTO)) {
				
				cs.setLong(1, movimiento.getCuenta().getId());
				cs.setString(2, movimiento.getConcepto());
				cs.setBigDecimal(3, movimiento.getImporte().getCantidad());
				cs.setString(4, movimiento.getImporte().getDivisa());
				
				int numeroRegistrosModificados = cs.executeUpdate();
				
				if(numeroRegistrosModificados != 1) {
					throw new AccesoDatosException("No se ha insertado ningún registro o se ha insertado más de uno");
				}
			} catch(SQLException e) {
				throw new AccesoDatosException("No se ha podido hacer la inserción", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Movimiento> getMovimientos(Long idCuenta) {
		Cuenta cuenta = null;

		try (Connection con = DriverManager.getConnection(URL)) {

			try (CallableStatement cs = con.prepareCall(GET_CUENTA_BY_ID)) {

				cs.setLong(1, idCuenta);

				try (ResultSet rs = cs.executeQuery()) {

					if (!rs.next()) {
						throw new AccesoDatosException("No se ha encontrado la cuenta");
					}

					cuenta = new Cuenta(rs.getLong("id"), rs.getString("codigobanco"), rs.getString("codigooficina"),
							rs.getString("codigocuenta"));

				} catch (SQLException e) {
					throw new AccesoDatosException("Error en el ResultSet", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error al crear la sentencia", e);
			}

			try (CallableStatement cs = con.prepareCall(GET_MOVIMIENTOS_BY_CUENTA)) {
				
				cs.setLong(1, idCuenta);
				
				try (ResultSet rs = cs.executeQuery()) {

					ArrayList<Movimiento> movimientos = new ArrayList<>();

					while (rs.next()) {
						String concepto = rs.getString("concepto");
						Importe importe = new Importe(rs.getBigDecimal("cantidad"), rs.getString("divisa"));
						
						Movimiento movimiento = new Movimiento(idCuenta, cuenta, concepto, importe);
						
						movimientos.add(movimiento);
					}
					
					return movimientos;
				} catch (SQLException e) {
					throw new AccesoDatosException("Error en el ResultSet", e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException("Error al crear la sentencia", e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha fallado la conexión", e);
		}
	}

}
