package ar.edu.unlp.info.oo2.ejercicio9_Excursiones;

public class CupoMinimo extends EstadoExcursion{

	public CupoMinimo(Excursion e) {
		super(e);
	}
	
	public void inscribirUsuario(Usuario u) {
		super.inscribirUsuario(u);
		if (!this.getContext().faltanInscriptosMaximo())
			this.getContext().cambiarEstado(new CupoMaximo(this.getContext()));
	}

	@Override
	public String informacion() {
		String info = this.getContext().obtenerInformacionBasica();
		info += "Cantidad de usuarios faltantes para el cupo maximo: " + this.getContext().cantidadFaltantesInscripcionMinima();
		info += "Email de usuarios inscriptos: "+ this.getContext().getEmailsInscriptos();
		return info;
	}
}
