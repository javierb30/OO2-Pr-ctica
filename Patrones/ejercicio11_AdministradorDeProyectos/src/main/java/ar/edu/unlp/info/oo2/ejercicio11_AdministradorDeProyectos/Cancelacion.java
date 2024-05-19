package ar.edu.unlp.info.oo2.ejercicio11_AdministradorDeProyectos;

public class Cancelacion extends EstadoProyecto{

	public Cancelacion(Proyecto p) {
		super(p);
	}

	@Override
	public void aprobarEtapa() {
		// No hace nada
	}

	@Override
	public boolean margenValido(double margen) {
		return false;
	}
	
	public void cancelarProyecto() {
		//No pasa nada
	}
}
