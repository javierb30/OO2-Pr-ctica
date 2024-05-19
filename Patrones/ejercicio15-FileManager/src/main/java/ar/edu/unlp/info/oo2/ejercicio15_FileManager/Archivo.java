package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

import java.time.LocalDate;

public class Archivo implements FileOO2{
	private String nombre;
	private String extension;
	private double tamaño;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private String permisos;
	
	public Archivo(String n, String e, double t, LocalDate fC, LocalDate fM,String p) {
		this.nombre = n;
		this.extension = e;
		this.tamaño = t;
		this.fechaCreacion = fC;
		this.fechaModificacion = fM;
		this.permisos = p;
	}

	@Override
	public String prettyPrint() {
		return "Archivo data:\n";
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String getExtension() {
		return this.extension;
	}

	public String getTamaño() {
		return Double.toString(this.tamaño);
	}

	@Override
	public String getFechaCreacion() {
		return this.fechaCreacion.toString();
	}

	@Override
	public String getFechaModificacion() {
		return this.fechaModificacion.toString();
	}

	@Override
	public String getPermisos() {
		return this.permisos;
	}
}
