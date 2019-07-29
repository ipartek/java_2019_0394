package com.ipartek.formacion.uf2218.modelos;

public class Calculadora {
	private long op1, op2, res;
	private char op;
	private String errorOp1, errorOp2, errorOp, errorRes;
	private boolean datosCorrectos = true;

	public Calculadora(long op1, char op, long op2) {
		super();
		this.op1 = op1;
		this.op2 = op2;
		this.op = op;
	}

	public Calculadora(String op1, String op, String op2) {
		setOp1(op1);
		setOp2(op2);
		setOp(op);
	}

	private void setOp(String op) {
		if(op.length() != 1) {
			setErrorOp("La operación debe ser definida con un caracter");
		}
		
		if(!op.matches("[\\+\\-\\*\\/]")) {
			setErrorOp("La operación " + op + " no está disponible");
		}
		
		setOp(op.charAt(0));
	}

	private void setOp2(String op2) {
		try {
			setOp2(Long.parseLong(op2));
		} catch (NumberFormatException e) {
			setErrorOp2("Necesito un número");
		}
	}

	private void setOp1(String op1) {
		try {
			setOp1(Long.parseLong(op1));
		} catch (NumberFormatException e) {
			setErrorOp1("Necesito un número");
		}
	}

	public long getOp1() {
		return op1;
	}

	public void setOp1(long op1) {
		this.op1 = op1;
	}

	public long getOp2() {
		return op2;
	}

	public void setOp2(long op2) {
		this.op2 = op2;
	}

	public long getRes() {
		switch (op) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			try {
				return op1 / op2;
			} catch (Exception e) {
				setErrorRes("No se ha podido efectuar la división");
				return 0;
			}
		default:
			setErrorRes("La operación " + op + " no existe");
			return 0;
		}
	}

	public char getOp() {
		return op;
	}

	public void setOp(char op) {
		this.op = op;
	}

	public String getErrorOp1() {
		return errorOp1;
	}

	public void setErrorOp1(String errorOp1) {
		this.errorOp1 = errorOp1;
		this.datosCorrectos = false;
	}

	public String getErrorOp2() {
		return errorOp2;
	}

	public void setErrorOp2(String errorOp2) {
		this.errorOp2 = errorOp2;
		this.datosCorrectos = false;
	}

	public String getErrorOp() {
		return errorOp;
	}

	public void setErrorOp(String errorOp) {
		this.errorOp = errorOp;
		this.datosCorrectos = false;
	}

	public String getErrorRes() {
		return errorRes;
	}

	public void setErrorRes(String errorRes) {
		this.errorRes = errorRes;
		this.datosCorrectos = false;
	}

	public boolean isDatosCorrectos() {
		return datosCorrectos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + op;
		result = prime * result + (int) (op1 ^ (op1 >>> 32));
		result = prime * result + (int) (op2 ^ (op2 >>> 32));
		result = prime * result + (int) (res ^ (res >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculadora other = (Calculadora) obj;
		if (op != other.op)
			return false;
		if (op1 != other.op1)
			return false;
		if (op2 != other.op2)
			return false;
		if (res != other.res)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calculadora [op1=" + op1 + ", op2=" + op2 + ", res=" + res + ", op=" + op + "]";
	}

}
