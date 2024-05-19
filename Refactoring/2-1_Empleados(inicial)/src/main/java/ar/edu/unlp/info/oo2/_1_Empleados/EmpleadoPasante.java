package ar.edu.unlp.info.oo2._1_Empleados;

public class EmpleadoPasante {
	public String nombre;
	public String apellido;
	public double sueldoBasico = 0;
	// ......
	public double sueldo() {
		return this.sueldoBasico - (this.sueldoBasico * 0.13);
	}
}
