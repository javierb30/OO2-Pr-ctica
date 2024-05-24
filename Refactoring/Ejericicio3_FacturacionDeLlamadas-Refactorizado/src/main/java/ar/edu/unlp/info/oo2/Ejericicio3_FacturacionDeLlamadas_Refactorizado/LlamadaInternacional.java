package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

public class LlamadaInternacional extends Llamada{

	private static final int PRECIOEXTRA = 50;
	static final int PRECIOPORSEGUNDO = 150;
	
	public LlamadaInternacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}

	public double calcularMonto(double auxMonto) {
		return super.calcularMonto(auxMonto) + PRECIOEXTRA;
	}
	
	public int getPrecioporsegundo() {
		return PRECIOPORSEGUNDO;
	}
}
