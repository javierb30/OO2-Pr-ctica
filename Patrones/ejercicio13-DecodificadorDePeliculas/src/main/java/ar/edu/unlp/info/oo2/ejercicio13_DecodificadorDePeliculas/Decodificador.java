package ar.edu.unlp.info.oo2.ejercicio13_DecodificadorDePeliculas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Decodificador {
	
	private List<Pelicula> grilla;
	private List<Pelicula> peliculasReproducidas;
	private Sugerencia criterioSugerencia;
	
	public Decodificador() {
		this.grilla = new ArrayList<Pelicula>();
		this.peliculasReproducidas = new ArrayList<Pelicula>();
		this.criterioSugerencia = new SugerenciaNovedad();
	}
	
	public void agregarPeliculaGrilla(Pelicula p) {
		//Asumo que se agrega una no existente
		this.grilla.add(p);
	}
	
	public List<Pelicula> getGrilla(){
		return this.grilla;
	}
	
	public List<Pelicula> getPeliculasReproducidas(){
		return this.peliculasReproducidas;
	}
	
	public void peliculaReproducida(Pelicula p) {
		//Asumo que la pelicula se encuentra en la grilla
		this.peliculasReproducidas.add(p);
	}
	
	public void setCriterioSugerencia(Sugerencia s) {
		this.criterioSugerencia = s;
	}
	
	public List<Pelicula> obtenerSugerencias(){
		return this.criterioSugerencia.obtenerSugerencias(this);
	}
	/*
	public List<Pelicula> obtenerPeliculasNoReproducidas(){
		return this.grilla.stream()
							.filter(p -> !this.peliculasReproducidas.contains(p))
							.collect(Collectors.toList());
	}*/
	
	public boolean fueReproducida(Pelicula p) {
		return this.peliculasReproducidas.contains(p);
	}
}
