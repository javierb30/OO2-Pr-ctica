package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

import java.util.SortedSet;

public class UltimoGenerador implements NumeroGenerador{

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = lineas.last();
        lineas.remove(linea);
        return linea;
	}

}
