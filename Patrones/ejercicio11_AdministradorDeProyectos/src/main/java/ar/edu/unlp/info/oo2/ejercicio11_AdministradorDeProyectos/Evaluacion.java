package ar.edu.unlp.info.oo2.ejercicio11_AdministradorDeProyectos;

public class Evaluacion extends EstadoProyecto{

	public Evaluacion(Proyecto p) {
		super(p);
	}

	@Override
	public void aprobarEtapa() {
		this.getContext().cambiarEstado(new Confirmacion(this.getContext()));
	}

	@Override
	public boolean margenValido(double margen) {
		return ((margen >= 11) && (margen <=15));
	}

}
