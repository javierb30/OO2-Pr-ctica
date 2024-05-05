package ar.edu.unlp.info.oo2.ejercicio9_Excursiones;

public class CupoMaximo extends EstadoExcursion{

	public CupoMaximo(Excursion e) {
		super(e);
	}
	
	public void inscribirUsuario(Usuario u) {
		this.getContext().getListaDeEspera().add(u);
	}

	@Override
	public String informacion() {
		return this.getContext().obtenerInformacionBasica();
	}
}
