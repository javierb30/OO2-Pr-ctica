package ar.edu.unlp.info.oo2.ejercicio4_CalculoDeSueldos;

public abstract class Empleado {
	
	public double sueldo() {
		return this.calcularBasico() + this.calcularAdicional() + this.calcularDescuento();
	}
	
	public double calcularDescuento() {
		return ((this.calcularBasico() * 0.13) + (this.calcularAdicional() * 0.5));
	}
	
	public abstract double calcularBasico();
	
	public abstract double calcularAdicional();
}
