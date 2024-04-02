package ar.edu.unlp.info.oo2.ejercicio4_CalculoDeSueldos;

public abstract class EmpleadoConFamilia extends Empleado{
	
	private boolean estaCasado;
	private int cantHijos;
	
	public EmpleadoConFamilia(boolean estaCasado, int cantHijos) {
		this.estaCasado = estaCasado;
		this.cantHijos = cantHijos;
	}
	
	public double calcularAdicionalCasado(int valor) {
		return valor;
	}
	
	public double calcularAdicionalHijos(int valor) {
		return valor * this.cantHijos;
	}
}
