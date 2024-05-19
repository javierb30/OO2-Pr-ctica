package ar.edu.unlp.info.oo2.ejercicio9_Excursiones;

public abstract class EstadoExcursion {
	private Excursion context;
	
	public EstadoExcursion(Excursion e) {
		this.context = e;
	}
	
	public void inscribirUsuario(Usuario u) {
		this.getContext().getInscriptos().add(u);
	}
	
	public Excursion getContext() {
		return this.context;
	}
	
	public abstract String informacion();
}
