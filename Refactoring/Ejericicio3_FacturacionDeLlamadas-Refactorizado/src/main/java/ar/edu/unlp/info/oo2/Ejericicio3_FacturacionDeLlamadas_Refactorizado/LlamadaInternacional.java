package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

public class LlamadaInternacional extends Llamada{

	public LlamadaInternacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}

	@Override
	public double calcularMonto(double auxMonto) {
		// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
		auxMonto += getDuracion() * 150 + (getDuracion() * 150 * 0.21) + 50;
		return auxMonto;
	}
}
