package ar.edu.unlp.info.oo2.ejercicio4_CalculoDeSueldos;

public class EmpleadoPasante extends Empleado{
	
	private int cantExamenesAprobados;
	
	public EmpleadoPasante(int cantExamenesAprobados) {
		this.cantExamenesAprobados = cantExamenesAprobados;
	}
	
	public double calcularBasico() {
		return 20000;
	}
	
	public int getCantExamenesAprobados() {
		return this.cantExamenesAprobados;
	}
	
	public double calcularAdicional() {
		return (2000 * this.getCantExamenesAprobados());
	}
}
