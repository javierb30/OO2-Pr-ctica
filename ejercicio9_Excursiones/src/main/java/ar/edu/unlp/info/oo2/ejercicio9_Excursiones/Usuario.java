package ar.edu.unlp.info.oo2.ejercicio9_Excursiones;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	
	public Usuario(String n, String a, String e) {
		this.apellido = a;
		this.email = e;
		this.nombre = n;
	}
	
	public void realizarInscripcion(Excursion e) {
		e.inscribirUsuario(this);
	}
	
	public String getEmail() {
		return this.email;
	}
}
