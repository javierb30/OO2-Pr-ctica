package ar.edu.unlp.info.oo2.ejercicio7_FileSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio extends FileSystem{
	
	private List<FileSystem> elementos;
	
	public Directorio(String n, LocalDate fC) {
		super(n, fC);
		this.elementos = new ArrayList<FileSystem>();
	}

	@Override
	public int tamanoTotalOcupado() {
		int cantInicial = 32;
		int tamañoContenido = this.elementos.stream()
									.mapToInt(elem -> elem.tamanoTotalOcupado())
									.sum();
		return (tamañoContenido + cantInicial);
	}

	@Override
	public Archivo archivoMasGrande() {
		return this.elementos.stream()
					.map(componente1 -> componente1.archivoMasGrande())
					.max((componente1, componente2) -> Integer.compare(componente1.tamanoTotalOcupado(), componente2.tamanoTotalOcupado()))
					.orElse(null);
	}

	@Override
	public Archivo archivoMasNuevo() {
		return this.elementos.stream()
					.map(componente1 -> componente1.archivoMasNuevo())
					.max((componente2, componente3) -> componente2.getFechaCreacion().compareTo(componente3.getFechaCreacion()))
					.orElse(null);
	}

	@Override
	public FileSystem buscar(String nombre) {
		if (this.getNombre().equals(nombre))
			return this;
		else
			return this.elementos.stream()
					.filter(elem -> elem.buscar(nombre) != null)
					.findFirst().orElse(null);
		
	}

	@Override
	public void buscarTodos(String nombre, List<FileSystem> elem) {
		if(this.getNombre().equals(nombre))
			elem.add(this);
		this.elementos.stream()
						.forEach(comp -> comp.buscarTodos(nombre, elem));
	}

	@Override
	public String listadoDeContenido() {
		// Terminar
		return null;
	}
	
	
}
