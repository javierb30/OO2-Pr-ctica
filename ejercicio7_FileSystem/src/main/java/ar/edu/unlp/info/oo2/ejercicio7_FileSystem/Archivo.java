package ar.edu.unlp.info.oo2.ejercicio7_FileSystem;

import java.time.LocalDate;
import java.util.List;

public class Archivo extends FileSystem{
	private int tamaño;
	
	public Archivo(String n, LocalDate fC, int t) {
		super(n, fC);
		this.tamaño = t;
	}

	@Override
	public int tamanoTotalOcupado() {
		return this.tamaño;
	}

	@Override
	public Archivo archivoMasGrande() {
		return this;
	}

	@Override
	public Archivo archivoMasNuevo() {
		return this;
	}

	@Override
	public FileSystem buscar(String nombre) {
		if (this.getNombre().equals(nombre))
			return this;
		return null;
	}

	@Override
	public void buscarTodos(String nombre, List<FileSystem> elementos) {
		if (this.getNombre().equals(nombre))
			elementos.add(this);
	}

	@Override
	public String listadoDeContenido() {
		return (this.getNombre());
	}
	
}
