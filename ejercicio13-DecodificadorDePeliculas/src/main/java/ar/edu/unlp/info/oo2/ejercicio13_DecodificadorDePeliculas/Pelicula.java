package ar.edu.unlp.info.oo2.ejercicio13_DecodificadorDePeliculas;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private Year añoEstreno;
	private double puntaje;
	private List<Pelicula> peliculasSimilares;
	
	public Pelicula(String t, Year año, int p) {
		this.titulo = t;
		this.añoEstreno = año;
		this.puntaje = p;
		this.peliculasSimilares = new ArrayList<Pelicula>();
	}
	
	public boolean agregarPeliculaSimilar(Pelicula otraPelicula) {
		if (this.peliculasSimilares.contains(otraPelicula))
				return false;
		else {
			this.peliculasSimilares.add(otraPelicula);
			otraPelicula.agregarPeliculaSimilar(this);
			return true;
		}
	}
	
	public Year getAñoEstreno() {
		return this.añoEstreno;
	}
	
	public List<Pelicula> getPeliculasSimilares(){
		return this.peliculasSimilares;
	}
	
	public double getPuntaje() {
		return this.puntaje;
	}
	
}
