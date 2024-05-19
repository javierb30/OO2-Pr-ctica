package ar.edu.unlp.info.oo2.ejercicio13_DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaNovedad extends Sugerencia{


	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador d) {
			return d.getGrilla().stream()
					.sorted((p1,p2) -> p1.getAñoEstreno().compareTo(p2.getAñoEstreno()))
					.collect(Collectors.toList());
	}
	
	
}
