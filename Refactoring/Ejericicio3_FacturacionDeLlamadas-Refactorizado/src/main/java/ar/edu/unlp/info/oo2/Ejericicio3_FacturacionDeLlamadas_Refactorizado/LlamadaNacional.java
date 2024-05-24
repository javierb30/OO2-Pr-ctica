package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

public class LlamadaNacional extends Llamada{

	private static final int PRECIOPORSEGUNDO = 3;

	public LlamadaNacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}

	public int getPrecioporsegundo() {
		return PRECIOPORSEGUNDO;
	}
	
}
