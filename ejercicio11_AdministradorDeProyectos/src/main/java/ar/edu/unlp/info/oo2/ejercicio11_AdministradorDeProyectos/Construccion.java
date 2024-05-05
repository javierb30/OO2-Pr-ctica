package ar.edu.unlp.info.oo2.ejercicio11_AdministradorDeProyectos;

public class Construccion extends EstadoProyecto{

	public Construccion(Proyecto p) {
		super(p);
	}

	@Override
	public void aprobarEtapa() {
		if (this.getContext().calcularPrecioDelProyecto() > 0)
			this.getContext().cambiarEstado(new Evaluacion(this.getContext()));
		else
			throw new RuntimeException("El precio del proyecto no es mayor a cero.");
	}

	@Override
	public boolean margenValido(double margen) {
		return ((margen >= 8) && (margen <=10));
	}

}
