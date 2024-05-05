package ar.edu.unlp.info.oo2.ejercicio11_AdministradorDeProyectos;

import java.time.LocalDate;
import java.time.Period;

public class Proyecto {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String objetivo;
	private int cantIntegrantes;
	private double margenGanancia;
	private double montoPorDiaPorIntegrante;
	private EstadoProyecto state;
	
	public Proyecto(String n, LocalDate fI, LocalDate fF, String o, int cI, double mPDPI) {
		this.nombre= n;
		this.fechaInicio = fI;
		this.fechaFin = fF;
		this.objetivo = o;
		this.cantIntegrantes = cI;
		this.montoPorDiaPorIntegrante = mPDPI;
		this.margenGanancia = 7;
		this.state = new Construccion(this);
	}
	
	public double getMargenGanancia() {
		return margenGanancia;
	}

	public void setMargenGanancia(double margenGanancia) {
		this.margenGanancia = margenGanancia;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public void agregarModificacionObjetivo(String o) {
		this.setObjetivo(this.objetivo + o);
	}
	
	public void aprobarEtapa() {
		this.state.aprobarEtapa();
	}
	
	public void cambiarEstado(EstadoProyecto newEstado) {
		this.state = newEstado;
	}
	
	public double calcularCostoDelProyecto() {
		return (this.montoPorDiaPorIntegrante * this.duracionTotal() * this.cantIntegrantes);
	}
	
	public double calcularPrecioDelProyecto() {
		return (this.calcularCostoDelProyecto() * (1 + this.margenGanancia/100));
	}
	
	private int duracionTotal() {
		return Period.between(fechaInicio, fechaFin).getDays();
	}
	
	public void modificarMargenGanancia(double margen) {
		this.state.modificarMargenGanancia(margen);
	}
	
	public void cancelarProyecto() {
		this.state.cancelarProyecto();
	}
	
	public EstadoProyecto getEstado() {
		//Para el test
		return this.state;
	}
}
