package ar.edu.unlp.info.oo2.ejercicio13_DecodificadorDePeliculas;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Sugerencia {
	
	public Sugerencia() {
		
	}
	public abstract List<Pelicula> sugerirPeliculas(Decodificador d);
	
	public List<Pelicula> obtenerSugerencias(Decodificador d){
		//List<Pelicula> peliculasNoReproducidas = d.obtenerPeliculasNoReproducidas();
		return this.sugerirPeliculas(d).stream()
										.filter(p -> !d.fueReproducida(p))
										.limit(3)
										.collect(Collectors.toList());
	}
	
	
}
