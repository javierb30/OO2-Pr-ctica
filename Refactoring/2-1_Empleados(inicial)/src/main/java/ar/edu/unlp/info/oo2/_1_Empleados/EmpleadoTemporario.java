package ar.edu.unlp.info.oo2._1_Empleados;

public class EmpleadoTemporario {
	public String nombre;
	public String apellido;
	public double sueldoBasico = 0;
	public double horasTrabajadas = 0;
	public int cantidadHijos = 0;


	public double sueldo() {
		return this.sueldoBasico
			+ (this.horasTrabajadas * 500)
			+ (this.cantidadHijos * 1000)
			- (this.sueldoBasico * 0.13);
		}
}