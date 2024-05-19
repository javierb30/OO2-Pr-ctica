package ar.edu.unlp.info.oo2._1_Empleados;

public class EmpleadoPlanta {
	public String nombre;
	public String apellido;
	public double sueldoBasico = 0;
	public int cantidadHijos = 0;
	// ......
	
	public double sueldo() {
		return this.sueldoBasico
		+ (this.cantidadHijos * 2000)
		- (this.sueldoBasico * 0.13);
	}
}