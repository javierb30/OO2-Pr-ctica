package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

import java.util.SortedSet;

public interface NumeroGenerador {
	public String obtenerNumeroLibre(SortedSet<String> lineas);
}
