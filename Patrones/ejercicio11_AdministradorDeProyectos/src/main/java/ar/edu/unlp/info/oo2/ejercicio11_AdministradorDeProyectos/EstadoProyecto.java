package ar.edu.unlp.info.oo2.ejercicio11_AdministradorDeProyectos;

public abstract class EstadoProyecto {
	private Proyecto context;
	
	public EstadoProyecto(Proyecto p) {
		this.context= p;
	}
	
	public Proyecto getContext() {
		return this.context;
	}
	
	public abstract void aprobarEtapa();
	
	public void modificarMargenGanancia(double margen) {
		if (this.margenValido(margen))
			this.context.setMargenGanancia(margen);
	}
	
	public abstract boolean margenValido(double margen);
	
	public void cancelarProyecto() {
		this.context.agregarModificacionObjetivo(" (Cancelado)");
		this.context.cambiarEstado(new Cancelacion(this.context));
	}
}