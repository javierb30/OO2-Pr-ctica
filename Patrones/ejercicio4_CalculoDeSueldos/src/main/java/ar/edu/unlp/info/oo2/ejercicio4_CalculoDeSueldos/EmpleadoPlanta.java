package ar.edu.unlp.info.oo2.ejercicio4_CalculoDeSueldos;

public class EmpleadoPlanta extends EmpleadoConFamilia{
	private int antiguedad;
	
	public EmpleadoPlanta(boolean EC,int cantH, int ant) {
		super(EC, cantH);
		this.antiguedad = ant;
	}
	
	public double calcularBasico() {
		return 50000;
	}
	
	private double calcularAdicionalAntiguedad(int valor) {
		return (this.getAntiguedad() * valor);
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	
	public double calcularAdicional() {
		return (this.calcularAdicionalCasado(5000) + this.calcularAdicionalHijos(2000) + this.calcularAdicionalAntiguedad(2000));
	}
}
