package ar.edu.unlp.info.oo2.ejercicio13_DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaSimilaridad extends Sugerencia{

	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador d) {
		return d.getPeliculasReproducidas().stream()
												.map(p -> p.getPeliculasSimilares())
												.flatMap(simil -> simil.stream())
												.distinct()
												.collect(Collectors.toList());
	}

}