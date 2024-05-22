package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private List<Llamada> llamadas;
	private String nombre;
	private String numeroTelefono;
	final static double descuentoJur = 0.15;
	final static double descuentoFis = 0;
	
	public Cliente(String nombre, String numeroTelefono){
        this.llamadas = new ArrayList<Llamada>(); 
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }
	
	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

    public abstract double calcularMonto(double auxMonto);

    public double calcularMontoTotalLlamadas() {
        return getLlamadas().stream()
                .mapToDouble(llamada -> {
                    double auxMonto = 0;
                    auxMonto = llamada.calcularMonto(auxMonto);
                    return calcularMonto(auxMonto);
                })
                .sum();
    }

	public void agregarLlamada(Llamada llamada) {
		getLlamadas().add(llamada);
	}
}