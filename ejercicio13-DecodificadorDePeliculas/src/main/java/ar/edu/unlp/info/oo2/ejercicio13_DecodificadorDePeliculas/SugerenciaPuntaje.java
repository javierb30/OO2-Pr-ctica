package ar.edu.unlp.info.oo2.ejercicio13_DecodificadorDePeliculas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPuntaje extends Sugerencia{

	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador d) {
		return d.getGrilla().stream()
								.sorted(Comparator.comparing(Pelicula::getPuntaje).reversed().thenComparing(Pelicula::getAñoEstreno))
					            .collect(Collectors.toList());
	}/*
								.sorted((p1,p2) -> {
									if (p2.getPuntaje() > p1.getPuntaje()) {
					                    return 1; // Ordenar de mayor a menor puntaje
					                } else if (p2.getPuntaje() < p1.getPuntaje()) {
					                    return -1;
					                } else { // En caso de empate
					                    return p2.getAnioLanzamiento().compareTo(p1.getAnioLanzamiento()); // Ordenar por año de lanzamiento de más reciente a más antiguo
					                }
								})
								.collect(Collectors.toList());
	}*/
}
