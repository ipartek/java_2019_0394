package com.ipartek.formacion.banco.accesodatos;

import com.ipartek.formacion.banco.entidades.Movimiento;

public interface BancoDAO {
	void addMovimiento(Movimiento movimiento);
	Iterable<Movimiento> getMovimientos(Long idCuenta);
}
