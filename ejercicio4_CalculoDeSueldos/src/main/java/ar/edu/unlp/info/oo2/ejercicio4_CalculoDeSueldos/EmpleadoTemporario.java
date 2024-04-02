package ar.edu.unlp.info.oo2.ejercicio4_CalculoDeSueldos;

public class EmpleadoTemporario extends EmpleadoConFamilia{
	
	private int cantHoras;
	
	public EmpleadoTemporario(boolean EC,int cantH, int cantHoras) {
		super(EC, cantH);
		this.cantHoras = cantHoras;
	}
	
	public double calcularBasico() {
		return (20000 + calcularValorHorasTotal(300));
	}
	
	private double calcularValorHorasTotal(int valor) {
		return valor * this.getCantHoras();
	}
	
	public int getCantHoras() {
		return this.cantHoras;
	}
	
	public double calcularAdicional() {
		return (this.calcularAdicionalCasado(5000) + this.calcularAdicionalHijos(2000));
	}
}
