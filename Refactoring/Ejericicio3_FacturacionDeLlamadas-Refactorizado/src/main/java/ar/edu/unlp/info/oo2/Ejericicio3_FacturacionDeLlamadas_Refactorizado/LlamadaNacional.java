package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

public class LlamadaNacional extends Llamada{

	public LlamadaNacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}

	public double calcularMonto(double auxMonto) {
		// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
		auxMonto += getDuracion() * 3 + (getDuracion() * 3 * 0.21);
		return auxMonto;
	}
	
}
