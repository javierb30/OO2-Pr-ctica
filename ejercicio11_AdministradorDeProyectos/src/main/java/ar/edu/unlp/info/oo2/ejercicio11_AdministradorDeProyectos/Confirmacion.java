package ar.edu.unlp.info.oo2.ejercicio11_AdministradorDeProyectos;

public class Confirmacion extends EstadoProyecto{

	public Confirmacion(Proyecto p) {
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

}
