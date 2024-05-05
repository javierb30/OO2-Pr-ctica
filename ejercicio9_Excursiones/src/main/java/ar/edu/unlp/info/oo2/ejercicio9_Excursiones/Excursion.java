package ar.edu.unlp.info.oo2.ejercicio9_Excursiones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Excursion {
	private EstadoExcursion state;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	private List<Usuario> inscriptos;
	private List<Usuario> listaDeEspera;
	
	public Excursion(String n, LocalDate fI, LocalDate fF, String pE, double c, int cMin, int cMax) {
		this.state = new CupoIncompleto(this);
		this.nombre = n;
		this.fechaInicio = fI;
		this.fechaFin = fF;
		this.puntoEncuentro = pE;
		this.costo = c;
		this.cupoMinimo = cMin;
		this.cupoMaximo = cMax;
		inscriptos = new ArrayList<Usuario>();
		listaDeEspera = new ArrayList<Usuario>();
	}
	
	public EstadoExcursion getEstado() {
		//Para test
		return this.state;
	}
	
	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public String getPuntoEncuentro() {
		return puntoEncuentro;
	}

	public double getCosto() {
		return costo;
	}

	
	public List<Usuario> getInscriptos(){
		return this.inscriptos;
	}
	
	public int cantidadFaltantesInscripcionMinima() {
		return (this.getCupoMinimo() - this.getInscriptos().size());
	}
	
	public boolean faltanInscriptosMinimo() {
		return !(this.cantidadFaltantesInscripcionMinima() == 0);
	}
	
	public int cantidadFaltantesInscripcionMaxima() {
		return (this.getCupoMaximo() - this.getInscriptos().size());
	}
	
	public boolean faltanInscriptosMaximo() {
		return !(this.cantidadFaltantesInscripcionMaxima() == 0);
	}
	
	public int getCupoMinimo() {
		return this.cupoMinimo;
	}
	
	public int getCupoMaximo() {
		return this.cupoMaximo;
	}
	
	public List<Usuario> getListaDeEspera(){
		return this.listaDeEspera;
	}
	
	public void inscribirUsuario(Usuario u) {
		state.inscribirUsuario(u);
	}
	
	public void cambiarEstado(EstadoExcursion newEstado) {
		this.state = newEstado;
	}
	
	public String informacion() {
		return state.informacion();
	}
	
	public String getEmailsInscriptos() {
		return this.getInscriptos().stream()
									.map(u -> u.getEmail())
									.collect(Collectors.joining("\n"));
	}
	
	public String obtenerInformacionBasica() {
		String informacion = "Nombre: " + this.getNombre() + "\n"
				+ "Costo: " + this.getCosto() + "\n"
				+ "Fecha de Inicio: " + this.getFechaInicio() + "\n"
				+ "Fecha de Fin: " + this.getFechaFin() + "\n"
				+ "Punto de Encuentro: " + this.getPuntoEncuentro() + "\n";
		return informacion;
	}
}
