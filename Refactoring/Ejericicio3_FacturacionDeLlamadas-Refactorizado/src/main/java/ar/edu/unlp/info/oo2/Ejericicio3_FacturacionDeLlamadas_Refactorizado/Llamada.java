package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

public abstract class Llamada {
	private static final double PRECIOIVA = 0.21;
	
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String origen, String destino, int duracion) {
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}
	
	public abstract int getPrecioporsegundo();
	
	public String getDestino() {
		return destino;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getOrigen() {
		return origen;
	}

	public double ivaAdicional(double precioPorSegundo) {
		return montoBase(precioPorSegundo) * PRECIOIVA;
	}

	public double montoBase(double precioPorSegundo) {
		return getDuracion() * precioPorSegundo;
	}
	
	public double calcularMonto(double auxMonto) {
		auxMonto += this.montoBase(getPrecioporsegundo()) + this.ivaAdicional(getPrecioporsegundo());
		return auxMonto;
	}
}
