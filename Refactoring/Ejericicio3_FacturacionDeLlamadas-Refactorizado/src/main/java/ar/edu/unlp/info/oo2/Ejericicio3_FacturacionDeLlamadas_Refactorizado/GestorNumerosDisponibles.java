package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private NumeroGenerador tipoGenerador;
	
	public GestorNumerosDisponibles() {
        this.tipoGenerador = new UltimoGenerador();
    }
	
	public SortedSet<String> getLineas() {
		return lineas;
	}

	public String obtenerNumeroLibre() {
		return this.tipoGenerador.obtenerNumeroLibre(lineas);
	}

	public void cambiarTipoGenerador(NumeroGenerador tipoGenerador) {
		this.tipoGenerador = tipoGenerador;
	}
}
