package ar.edu.unlp.info.oo2.ejercicio9_Excursiones;

public class CupoIncompleto extends EstadoExcursion{

	public CupoIncompleto(Excursion e) {
		super(e);
	}

	
	public void inscribirUsuario(Usuario u) {
		super.inscribirUsuario(u);
		if (!this.getContext().faltanInscriptosMinimo())
			this.getContext().cambiarEstado(new CupoIncompleto(this.getContext()));
	}
	
	@Override
	public String informacion() {
		String info = this.getContext().obtenerInformacionBasica();
		info += "Cantidad de usuarios faltantes para el cupo minimo: " + this.getContext().cantidadFaltantesInscripcionMinima();
		return info;
	}
}
